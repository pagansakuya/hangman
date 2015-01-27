package hangman.windows;

import hangman.utils.MenuWindow;
import java.awt.EventQueue;
import java.awt.GridLayout;

import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.JLabel;

import java.awt.Font;

import javax.swing.SwingConstants;

import java.awt.BorderLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.WindowEvent;

public class MainMenuWindow extends MenuWindow {

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainMenuWindow window = new MainMenuWindow();
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
	public MainMenuWindow() {
		initialize();
		//PlayDatabase.init();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	@Override
	protected void initialize() {

		super.initialize();

		JPanel componentPanel = new JPanel();
		componentPanel.setOpaque(false);
		background.add(componentPanel);
		componentPanel.setLayout(new BorderLayout(0, 0));

		JLabel lblNewLabel = new JLabel("Hangman");
		componentPanel.add(lblNewLabel, BorderLayout.NORTH);
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Comic Sans MS", Font.BOLD, 48));

		JPanel buttonPanel = new JPanel();
		buttonPanel.setOpaque(false);
		componentPanel.add(buttonPanel);
		buttonPanel.setLayout(new GridLayout(5, 0, 0, 0));

		JButton btnNewSingle = new JButton("New game (single player)");
		btnNewSingle.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				frame.dispose();
				SinglePlayerMenuWindow window = new SinglePlayerMenuWindow();
				window.frame.setVisible(true);
			}
		});
		buttonPanel.add(btnNewSingle);

		JButton btnNewMulti = new JButton("New game (two players)");
		btnNewMulti.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				frame.dispose();
				MultiPlayerMenuWindow window = new MultiPlayerMenuWindow();
				window.frame.setVisible(true);
			}
		});
		buttonPanel.add(btnNewMulti);

		JButton btnRecentGames = new JButton("Recent games");
		btnRecentGames.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				StatsWindow window = new StatsWindow();
				window.frame.setVisible(true);
			}
		});
		buttonPanel.add(btnRecentGames);
		
		JButton btnNewWord = new JButton("Add new word");
		btnNewWord.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				NewWordWindow window = new NewWordWindow();
				window.frame.setVisible(true);
			}
		});
		buttonPanel.add(btnNewWord);

		JButton btnExit = new JButton("Quit");
		btnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				frame.dispatchEvent(new WindowEvent(frame,
						WindowEvent.WINDOW_CLOSING));
			}
		});
		buttonPanel.add(btnExit);

	}

}
