package calculadora.swing.frontend;

import java.awt.Color;
import java.awt.GridLayout;

import javax.swing.JPanel;

@SuppressWarnings("serial")
public class Keyboard extends JPanel {
	
	public Keyboard(Display display) {
		
		setLayout(new GridLayout(5, 4));
		
		Button c = new Button("C", Color.LIGHT_GRAY, Color.RED);
		c.registerObserver(display);
		add(c);
		Button plusMinus = new Button("+/-", Color.LIGHT_GRAY, Color.BLACK);
		plusMinus.registerObserver(display);
		add(plusMinus);
		Button module = new Button("%", Color.LIGHT_GRAY, Color.BLACK);
		module.registerObserver(display);
		add(module);
		Button cross = new Button("X", Color.LIGHT_GRAY, Color.BLACK);
		cross.registerObserver(display);
		add(cross);
		Button num7 = new Button("7", Color.LIGHT_GRAY, Color.BLACK);
		num7.registerObserver(display);
		add(num7);
		Button num8 = new Button("8", Color.LIGHT_GRAY, Color.BLACK);
		num8.registerObserver(display);
		add(num8);
		Button num9 = new Button("9", Color.LIGHT_GRAY, Color.BLACK);
		num9.registerObserver(display);
		add(num9);
		Button div = new Button("/", Color.LIGHT_GRAY, Color.BLACK);
		div.registerObserver(display);
		add(div);
		Button num4 = new Button("4", Color.LIGHT_GRAY, Color.BLACK);
		num4.registerObserver(display);
		add(num4);
		Button num5 = new Button("5", Color.LIGHT_GRAY, Color.BLACK);
		num5.registerObserver(display);
		add(num5);
		Button num6 = new Button("6", Color.LIGHT_GRAY, Color.BLACK);
		num6.registerObserver(display);
		add(num6);
		Button multi = new Button("*", Color.LIGHT_GRAY, Color.BLACK);
		multi.registerObserver(display);
		add(multi);
		Button num1 = new Button("1", Color.LIGHT_GRAY, Color.BLACK);
		num1.registerObserver(display);
		add(num1);
		Button num2 = new Button("2", Color.LIGHT_GRAY, Color.BLACK);
		num2.registerObserver(display);
		add(num2);
		Button num3 = new Button("3", Color.LIGHT_GRAY, Color.BLACK);
		num3.registerObserver(display);
		add(num3);
		Button minus = new Button("-", Color.LIGHT_GRAY, Color.BLACK);
		minus.registerObserver(display);
		add(minus);
		Button equal = new Button("=", Color.GREEN, Color.WHITE);
		equal.registerObserver(display);
		add(equal);
		Button num0 = new Button("0", Color.LIGHT_GRAY, Color.BLACK);
		num0.registerObserver(display);
		add(num0);
		Button dot = new Button(".", Color.LIGHT_GRAY, Color.BLACK);
		dot.registerObserver(display);
		add(dot);
		Button plus = new Button("+", Color.LIGHT_GRAY, Color.BLACK);
		plus.registerObserver(display);
		add(plus);
	}
}
