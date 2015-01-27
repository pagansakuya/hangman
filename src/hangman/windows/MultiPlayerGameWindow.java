package hangman.windows;

import hangman.engine.JTimerPanel;
import hangman.utils.JHangmanGraph;
import hangman.utils.JKeyboardPanel;
import hangman.utils.JPasswordPanel;
import hangman.utils.User;
import hangman.utils.WordDatabase;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;

import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;

import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class MultiPlayerGameWindow {

	protected JFrame frame;
	private JHangmanGraph hangmanDrawPanel;
	private JPasswordPanel passwordPanel;
	private JTimerPanel timer;
	private JKeyboardPanel wordPanel;
	private JLabel lblUser1;
	private JLabel lblUser2;
	private User user1;
	private User user2;

	public String player1Name = new String(), player2Name = new String();
	private JButton btnReturnToMain;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
//					 MultiGameWindow window = new MultiGameWindow();
//					 window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public MultiPlayerGameWindow(String _player1Name, String _player2Name) {
		if (player1Name.equals(""))
			player1Name = "Player 1";
		else
			player1Name = _player1Name;
		
		if (player2Name.equals(""))
			player2Name = "Player 2";
		else
			player2Name = _player2Name;
		
		initialize();
		executeHangman();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 600, 400);
		frame.setResizable(false);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[] { 300, 100, 100 };
		gridBagLayout.rowHeights = new int[] { 0, 196, 100 };
		gridBagLayout.columnWeights = new double[] { 0.0, 0.0, 0.0 };
		gridBagLayout.rowWeights = new double[] { 0.0, 1.0, 1.0 };
		frame.getContentPane().setLayout(gridBagLayout);

		passwordPanel = new JPasswordPanel(WordDatabase.getInstance().getRandomWord());
		GridBagConstraints gbc_lblPassword = new GridBagConstraints();
		gbc_lblPassword.insets = new Insets(0, 0, 5, 5);
		gbc_lblPassword.gridx = 0;
		gbc_lblPassword.gridy = 0;
		frame.getContentPane().add(passwordPanel, gbc_lblPassword);

		lblUser1 = new JLabel("");
		GridBagConstraints gbc_lblUser1 = new GridBagConstraints();
		gbc_lblUser1.insets = new Insets(0, 0, 5, 5);
		gbc_lblUser1.gridx = 1;
		gbc_lblUser1.gridy = 0;
		frame.getContentPane().add(lblUser1, gbc_lblUser1);

		lblUser2 = new JLabel("");
		GridBagConstraints gbc_lblUser2 = new GridBagConstraints();
		gbc_lblUser2.insets = new Insets(0, 0, 5, 0);
		gbc_lblUser2.gridx = 2;
		gbc_lblUser2.gridy = 0;
		frame.getContentPane().add(lblUser2, gbc_lblUser2);

		hangmanDrawPanel = new JHangmanGraph(0);
		GridBagConstraints gbc_hangmanDrawPanel = new GridBagConstraints();
		gbc_hangmanDrawPanel.insets = new Insets(0, 0, 5, 5);
		gbc_hangmanDrawPanel.fill = GridBagConstraints.BOTH;
		gbc_hangmanDrawPanel.gridx = 0;
		gbc_hangmanDrawPanel.gridy = 1;
		frame.getContentPane().add(hangmanDrawPanel, gbc_hangmanDrawPanel);

		timer = new JTimerPanel();
		GridBagConstraints gbc_clockPanel = new GridBagConstraints();
		gbc_clockPanel.gridwidth = 2;
		gbc_clockPanel.insets = new Insets(0, 0, 5, 0);
		gbc_clockPanel.fill = GridBagConstraints.BOTH;
		gbc_clockPanel.gridx = 1;
		gbc_clockPanel.gridy = 1;
		frame.getContentPane().add(timer, gbc_clockPanel);

		wordPanel = new JKeyboardPanel();
		GridBagConstraints gbc_wordPanel = new GridBagConstraints();
		gbc_wordPanel.gridwidth = 2;
		gbc_wordPanel.insets = new Insets(0, 0, 0, 5);
		gbc_wordPanel.fill = GridBagConstraints.BOTH;
		gbc_wordPanel.gridx = 0;
		gbc_wordPanel.gridy = 2;
		frame.getContentPane().add(wordPanel, gbc_wordPanel);

		user1 = new User(true, player1Name, lblUser1);
		user2 = new User(false, player2Name, lblUser2);
		
		btnReturnToMain = new JButton("Return to main menu");
		btnReturnToMain.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				MainMenuWindow window = new MainMenuWindow();
				window.frame.setVisible(true);
			}
		});
		GridBagConstraints gbc_btnReturnToMain = new GridBagConstraints();
		gbc_btnReturnToMain.gridx = 2;
		gbc_btnReturnToMain.gridy = 2;
		frame.getContentPane().add(btnReturnToMain, gbc_btnReturnToMain);
	}

	private void executeHangman() {
		timer.executeMultiGameController(wordPanel, passwordPanel,
				hangmanDrawPanel, 5, user1, user2);
	}

}
