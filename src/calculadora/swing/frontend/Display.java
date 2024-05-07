package calculadora.swing.frontend;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.swing.JLabel;
import javax.swing.JPanel;

@SuppressWarnings("serial")
public class Display extends JPanel implements ButtonObserver {
	
	//implementar a logica caso o usuario faça varias somas seguidas sem clicar no igual
	//refatorar com enum e try/catch

	private JLabel label = new JLabel("0");

	private String s1;
	private double n1 = 0;
	private String s2;
	private double n2 = 0;
	private String operator = null;
	private String sResult;
	private double nResult;
	private int plusMinus1 = 0;
	private int plusMinus2 = 0;

	public Display() {

		setBackground(Color.WHITE);

		label.setForeground(Color.BLACK);
		label.setFont(new Font("times new roman", Font.PLAIN, 40));
		setLayout(new FlowLayout(FlowLayout.RIGHT, 6, 15));
		add(label);
	}

	public void setLabel(JLabel label) {
		this.label = label;
	}

	public JLabel getLabel() {
		return label;
	}

	private boolean nonNumber(String text) {

		String nonNumber = "[+-/*=.%+/-]";
		Pattern pattern = Pattern.compile(nonNumber);
		Matcher matcher = pattern.matcher(text);

		return matcher.matches();
	}

	private boolean isNumber(String text) {

		String isNumber = "\\d+";
		Pattern pattern = Pattern.compile(isNumber);
		Matcher matcher = pattern.matcher(text);

		return matcher.matches();
	}

	private double doMath(String clickedButton) {

		switch (clickedButton) {
		case "+":
			nResult = n1 + n2;
			break;

		case "-":
			nResult = n1 - n2;
			break;

		case "*":
			nResult = n1 * n2;
			break;

		case "/":
			nResult = n1 / n2;
			break;

		case "%":
			nResult = n1 % n2;
			break;
		}

		return 0;
	}

	public void update(Button button) {

		if (isNumber(button.getText())) {
			
			if (!(nResult == 0) && operator == null) {
				s1 = "";
				n1 = 0;
				s2 = "";
				n2 = 0;
				nResult = 0;
				sResult = "";
				plusMinus1 = 0;
				plusMinus2 = 0;
			}
			
			if (operator == null) {
				if (s1 == null) {
					s1 = button.getText();
					label.setText(s1);
				} else {
					s1 = s1 + button.getText();
					label.setText(s1);
				}
			} else {
				if (s2 == null) {
					s2 = button.getText();
					label.setText(s2);
				} else {
					s2 = s2 + button.getText();
					label.setText(s2);
				}
			}
		} else if (button.getText().equals(".")) {
			
			if (operator == null) {
				
				if (!s1.contains(".")) {
					s1 += ".";
					label.setText(s1);
				}
			} else {
				if (!s2.contains(".")) {
					s2 += ".";
					label.setText(s2);
				}
			}
		} else if (button.getText().equals("X")) {
			
			if (operator == null) {
				s1 = s1.substring(0, s1.length() - 1);
				label.setText(s1);
			} else {
				s2 = s2.substring(0, s2.length() - 1);
				label.setText(s2);
			}
		} else if (button.getText().equals("+/-")) {
			
			if (operator == null) {
				if (plusMinus1 == 0) {
					s1 = "-" + s1;
					label.setText(s1);
					
					plusMinus1 = 1;
				} else {
					s1 = s1.substring(1);
					label.setText(s1);
					
					plusMinus1 = 0;
				}
			} else {
				if (plusMinus2 == 0) {
					s2 = "-" + s2;
					label.setText(s2);
					
					plusMinus2 = 1;
				} else {
					s2 = s2.substring(1);
					label.setText(s2);
					
					plusMinus2 = 0;
				}
			}
		} else if (button.getText().equals("=")) {
			
			n2 = Double.parseDouble(s2);
			doMath(operator);
			sResult = Double.toString(nResult);
			label.setText(sResult);
			operator = null;
		} else if (button.getText().equals("C")) {
			
			label.setText("0");
			s1 = "";
			n1 = 0;
			s2 = "";
			n2 = 0;
			plusMinus1 = 0;
			plusMinus2 = 0;
			operator = null;
			nResult = 0;
			sResult = "";
		} else if (nonNumber(button.getText())) {
			
			operator = button.getText();

			if (!(nResult == 0)) {
				s1 = Double.toString(nResult);
				n1 = nResult;
				label.setText(s1);
				s2 = "";
				n2 = 0;
			} else {
				n1 = Double.parseDouble(s1);
				label.setText(s1);
			}
		}
	}
}
