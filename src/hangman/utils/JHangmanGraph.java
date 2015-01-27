package hangman.utils;
import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JPanel;

public class JHangmanGraph extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public int hangmanStep;
	private final int marginX = 10;
	private final int marginY = 10;
	private Human human = new Human();

	public JHangmanGraph(int _hangmanStep) {
		hangmanStep = _hangmanStep;
	}

	@Override
	protected void paintComponent(Graphics _graphics) {
		super.paintComponent(_graphics);

		switch (hangmanStep) {
		case 0: break;
		case 1:
			Slupek(_graphics);
			break;
		case 2:
			Belka(_graphics);
			break;
		case 3:
			Petla(_graphics);
			break;
		case 4:
			Trup(_graphics);
			break;
		}
	}

	private void Slupek(Graphics _graphics) {
		_graphics.setColor(Color.black);
		_graphics.drawLine(0 + marginX, 0 + marginY, 0 + marginX, human.gallow + marginY);
	}

	private void Belka(Graphics _graphics) {
		Slupek(_graphics);
		_graphics.setColor(Color.black);
		_graphics.drawLine(0 + marginX, 0 + marginY, human.gallow + marginX, 0 + marginY); 
	}

	private void Petla(Graphics _graphics) {
		Slupek(_graphics);
		Belka(_graphics);
		_graphics.setColor(Color.red);
		_graphics.drawLine(human.gallow + marginX, 0 + marginY, human.gallow + marginX, human.ropeLength + marginY);
	}

	private void Trup(Graphics _graphics) {
		Slupek(_graphics);
		Belka(_graphics);
		Petla(_graphics);
		
		_graphics.setColor(Color.blue);
		
		_graphics.drawLine(human.gallow + marginX + 5*human.scale, human.ropeLength + marginY + human.head/4, human.gallow + marginX + 5*human.scale + human.eye, human.ropeLength + marginY + human.head/4 + human.eye);
		_graphics.drawLine(human.gallow + marginX + 5*human.scale, human.ropeLength + marginY + human.head/4 + human.eye, human.gallow + marginX + 5 + human.eye, human.ropeLength + marginY + human.head/4);
		_graphics.drawLine(human.gallow + marginX - human.head/2 + 5*human.scale, human.ropeLength + marginY + human.head/4, human.gallow + marginX - human.head/2 + human.eye + 5*human.scale, human.ropeLength + human.eye + marginY + human.head/4);
		_graphics.drawLine(human.gallow + marginX - human.head/2 + 5*human.scale, human.ropeLength + human.eye + marginY + human.head/4, human.gallow + marginX - human.head/2 + human.eye + 5*human.scale, human.ropeLength + marginY + human.head/4);
		

		_graphics.setColor(Color.orange);
		
		_graphics.drawOval(human.gallow - human.head/2 + marginX, human.ropeLength + marginY, human.head, human.head);
		_graphics.drawLine(human.gallow + marginX, human.ropeLength + human.head + marginY, human.gallow + marginX, human.ropeLength + human.head + human.body + marginY);
		_graphics.drawLine(human.gallow + marginX, human.ropeLength + human.head + human.neck + marginY, human.gallow - human.arm + marginX, human.ropeLength + human.head + human.arm + marginY);
		_graphics.drawLine(human.gallow + marginX, human.ropeLength + human.head + human.neck + marginY, human.gallow + human.arm + marginX, human.ropeLength + human.head + human.arm + marginY);
		_graphics.drawLine(human.gallow + marginX, human.ropeLength + human.head + human.body + marginY, human.gallow - human.leg + marginX, human.ropeLength + human.head + human.body + human.leg + marginY);
		_graphics.drawLine(human.gallow + marginX, human.ropeLength + human.head + human.body + marginY, human.gallow + human.leg + marginX, human.ropeLength + human.head + human.body + human.leg + marginY);
	}

}
