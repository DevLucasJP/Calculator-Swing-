package calculadora.swing.frontend;

import java.awt.BorderLayout;
import java.awt.Dimension;

import javax.swing.JFrame;

@SuppressWarnings("serial")
public class Window extends JFrame {

	public Window() {
		
		layoutManager();
		
		setSize(232, 322);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		setVisible(true);
	}
	
	private void layoutManager() {
		
		setLayout(new BorderLayout());
		
		Display display = new Display();
		
		display.setPreferredSize(new Dimension(232, 60));
		add(display, BorderLayout.NORTH);
		
		Keyboard keyboard = new Keyboard(display);
		add(keyboard, BorderLayout.CENTER);
	}

	public static void main(String[] args) {
		
		new Window();
	}
}
