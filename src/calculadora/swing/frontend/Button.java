package calculadora.swing.frontend;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;

@SuppressWarnings("serial")
public class Button extends JButton implements MouseListener {
	
	private List<ButtonObserver> observers = new ArrayList<>();
	
	public Button(String text, Color buttonColor, Color textColor) {
		
		setBackground(buttonColor);
		setText(text);
		setForeground(textColor);
		setFont(new Font("times new roman", Font.PLAIN, 15));
		setOpaque(true);
		addMouseListener(this);
	}
	
	public void registerObserver (ButtonObserver observer) {
		observers.add(observer);
	}
	
	public void notifyObservers () {
		
		for (ButtonObserver observer : observers) {
			
			observer.update(this);
		}
	}
	
	public void mousePressed(MouseEvent e) {
		
		if (e.getButton() == 1) {
			notifyObservers();
		}
	}
	
	public void mouseClicked(MouseEvent e) {}
	public void mouseEntered(MouseEvent e) {}
	public void mouseExited(MouseEvent e) {}
	public void mouseReleased(MouseEvent e) {}
}
