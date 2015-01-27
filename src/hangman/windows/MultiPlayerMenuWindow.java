package hangman.windows;

import hangman.utils.MenuWindow;
import java.awt.EventQueue;
import java.awt.GridBagLayout;

import javax.swing.JLabel;

import java.awt.GridBagConstraints;
import java.awt.Insets;

import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JPanel;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MultiPlayerMenuWindow extends MenuWindow {

	private JTextField textFieldPlayer1;
	private JTextField textFieldPlayer2;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MultiPlayerMenuWindow window = new MultiPlayerMenuWindow();
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
	public MultiPlayerMenuWindow() {
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
		frame.getContentPane().add(panel, BorderLayout.CENTER);
		GridBagLayout gbl_panel = new GridBagLayout();
		gbl_panel.columnWidths = new int[] { 0, 0, 0 };
		gbl_panel.rowHeights = new int[] { 0, 0, 0, 0, 0, 0 };
		gbl_panel.columnWeights = new double[] { 1.0, 1.0, Double.MIN_VALUE };
		gbl_panel.rowWeights = new double[] { 0.0, 0.0, 0.0, 0.0, 1.0,
				Double.MIN_VALUE };
		panel.setLayout(gbl_panel);

		JLabel lblNewLabel = new JLabel("Type Player 1 name:");
		GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
		gbc_lblNewLabel.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel.gridx = 0;
		gbc_lblNewLabel.gridy = 0;
		panel.add(lblNewLabel, gbc_lblNewLabel);

		textFieldPlayer1 = new JTextField();
		GridBagConstraints gbc_textFieldPlayer1 = new GridBagConstraints();
		gbc_textFieldPlayer1.insets = new Insets(0, 0, 5, 0);
		gbc_textFieldPlayer1.fill = GridBagConstraints.HORIZONTAL;
		gbc_textFieldPlayer1.gridx = 1;
		gbc_textFieldPlayer1.gridy = 0;
		panel.add(textFieldPlayer1, gbc_textFieldPlayer1);
		textFieldPlayer1.setColumns(10);

		JLabel lblNewLabel_1 = new JLabel("Type Player 2 name:");
		GridBagConstraints gbc_lblNewLabel_1 = new GridBagConstraints();
		gbc_lblNewLabel_1.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_1.gridx = 0;
		gbc_lblNewLabel_1.gridy = 1;
		panel.add(lblNewLabel_1, gbc_lblNewLabel_1);

		textFieldPlayer2 = new JTextField();
		GridBagConstraints gbc_textFieldPlayer2 = new GridBagConstraints();
		gbc_textFieldPlayer2.insets = new Insets(0, 0, 5, 0);
		gbc_textFieldPlayer2.fill = GridBagConstraints.HORIZONTAL;
		gbc_textFieldPlayer2.gridx = 1;
		gbc_textFieldPlayer2.gridy = 1;
		panel.add(textFieldPlayer2, gbc_textFieldPlayer2);
		textFieldPlayer2.setColumns(10);

		JPanel panel_1 = new JPanel();
		panel_1.setOpaque(false);
		GridBagConstraints gbc_panel_1 = new GridBagConstraints();
		gbc_panel_1.gridwidth = 2;
		gbc_panel_1.insets = new Insets(0, 0, 5, 0);
		gbc_panel_1.fill = GridBagConstraints.BOTH;
		gbc_panel_1.gridx = 0;
		gbc_panel_1.gridy = 2;
		panel.add(panel_1, gbc_panel_1);

		JButton btnNewButton = new JButton("Submit");
		btnNewButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				frame.dispose();
				MultiPlayerGameWindow window = new MultiPlayerGameWindow(textFieldPlayer1.getText(),textFieldPlayer2.getText() );
				window.frame.setVisible(true);				
			}
		});
		panel_1.add(btnNewButton);

		JButton btnNewButton_1 = new JButton("Return");
		btnNewButton_1.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				MainMenuWindow window = new MainMenuWindow();
				window.frame.setVisible(true);
			}
		});
		panel_1.add(btnNewButton_1);
	}

}
