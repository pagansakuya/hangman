package hangman.utils;

import javax.imageio.ImageIO;
import javax.swing.JFrame;

import java.awt.Window.Type;
import java.awt.FlowLayout;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class MenuWindow {

	public JFrame frame;
	protected JLabel background;

	/**
	 * Initialize the contents of the frame.
	 */
	protected void initialize() {
		frame = new JFrame();
		frame.setType(Type.POPUP);
		frame.setTitle("Hangman");
		frame.setResizable(false);
		frame.setBounds(100, 100, 500, 400);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		
		BufferedImage image = null;
		
		try {
			image = ImageIO.read(getClass().getClassLoader().getResourceAsStream("resources/background.jpg"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		ImageIcon bck = new ImageIcon(image);

		background = new JLabel(bck);
		frame.setContentPane(background);
		background.setLayout(new FlowLayout());

	}

}
