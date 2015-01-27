package hangman.windows;

import hangman.utils.MenuWindow;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JPanel;

public class SinglePlayerMenuWindow extends MenuWindow {

	private JTextField txtNewPlayer;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SinglePlayerMenuWindow window = new SinglePlayerMenuWindow();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public SinglePlayerMenuWindow() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	@Override
	protected void initialize() {
		super.initialize();
		frame.getContentPane().setLayout(new BorderLayout(0, 0));

		JPanel panel = new JPanel();
		panel.setOpaque(false);
		frame.getContentPane().add(panel, BorderLayout.NORTH);
		panel.setLayout(new GridLayout(2, 1, 0, 0));

		JPanel panel_1 = new JPanel();
		panel_1.setOpaque(false);
		panel.add(panel_1);

		JLabel lblNewPlayer = new JLabel("Type player's name:");
		panel_1.add(lblNewPlayer);

		txtNewPlayer = new JTextField();
		panel_1.add(txtNewPlayer);
		txtNewPlayer.setColumns(10);

		JPanel panel_2 = new JPanel();
		panel_2.setOpaque(false);
		panel.add(panel_2);

		JButton btnNewButton = new JButton("Submit");
		btnNewButton.addActionListener(new ActionListener() {			
			@Override
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				SinglePlayerPlayWindow window = new SinglePlayerPlayWindow(txtNewPlayer.getText());
				//window.lblUser.setText(txtNewPlayer.getText());		
				window.frame.setVisible(true);
			}
		});
		panel_2.add(btnNewButton);

		JButton btnNewButton_1 = new JButton("Return");
		btnNewButton_1.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				MainMenuWindow window = new MainMenuWindow();
				window.frame.setVisible(true);
			}
		});
		panel_2.add(btnNewButton_1);
	}

}
