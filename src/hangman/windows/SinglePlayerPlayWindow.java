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

public class SinglePlayerPlayWindow {

	protected JFrame frame;
	private JHangmanGraph hangmanDrawPanel;
	private JPasswordPanel passwordPanel;
	private JLabel lblUser;
	private JTimerPanel timer;
	private JKeyboardPanel wordPanel;
	
	public String userName = new String();
	private User user;
	private JButton btnReturnToMain;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SinglePlayerPlayWindow window = new SinglePlayerPlayWindow("");
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
	public SinglePlayerPlayWindow(String _userName) {
		if(_userName.equals("")) userName = "Player"; else userName = _userName;
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
		gridBagLayout.columnWidths = new int[] {300, 0};
		gridBagLayout.rowHeights = new int[] {0, 200, 100};
		gridBagLayout.columnWeights = new double[] { 0.0, 1.0 };
		gridBagLayout.rowWeights = new double[] { 0.0, 1.0, 1.0 };
		frame.getContentPane().setLayout(gridBagLayout);

		passwordPanel = new JPasswordPanel(WordDatabase.getInstance().getRandomWord());
		GridBagConstraints gbc_lblPassword = new GridBagConstraints();
		gbc_lblPassword.insets = new Insets(0, 0, 5, 5);
		gbc_lblPassword.gridx = 0;
		gbc_lblPassword.gridy = 0;
		frame.getContentPane().add(passwordPanel, gbc_lblPassword);

		lblUser = new JLabel("dane usera");
		GridBagConstraints gbc_lblUser = new GridBagConstraints();
		gbc_lblUser.anchor = GridBagConstraints.EAST;
		gbc_lblUser.insets = new Insets(0, 0, 5, 0);
		gbc_lblUser.gridx = 1;
		gbc_lblUser.gridy = 0;
		frame.getContentPane().add(lblUser, gbc_lblUser);

		hangmanDrawPanel = new JHangmanGraph(0);
		GridBagConstraints gbc_hangmanDrawPanel = new GridBagConstraints();
		gbc_hangmanDrawPanel.insets = new Insets(0, 0, 5, 5);
		gbc_hangmanDrawPanel.fill = GridBagConstraints.BOTH;
		gbc_hangmanDrawPanel.gridx = 0;
		gbc_hangmanDrawPanel.gridy = 1;
		frame.getContentPane().add(hangmanDrawPanel, gbc_hangmanDrawPanel);

		timer = new JTimerPanel();
		GridBagConstraints gbc_clockPanel = new GridBagConstraints();
		gbc_clockPanel.insets = new Insets(0, 0, 5, 0);
		gbc_clockPanel.fill = GridBagConstraints.BOTH;
		gbc_clockPanel.gridx = 1;
		gbc_clockPanel.gridy = 1;
		frame.getContentPane().add(timer, gbc_clockPanel);

		wordPanel = new JKeyboardPanel();
		GridBagConstraints gbc_wordPanel = new GridBagConstraints();
		gbc_wordPanel.insets = new Insets(0, 0, 0, 5);
		gbc_wordPanel.fill = GridBagConstraints.BOTH;
		gbc_wordPanel.gridx = 0;
		gbc_wordPanel.gridy = 2;
		frame.getContentPane().add(wordPanel, gbc_wordPanel);
		
		btnReturnToMain = new JButton("Return to main menu");
		btnReturnToMain.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				MainMenuWindow window = new MainMenuWindow();
				window.frame.setVisible(true);
			}
		});
		GridBagConstraints gbc_btnReturnToMain = new GridBagConstraints();
		gbc_btnReturnToMain.gridx = 1;
		gbc_btnReturnToMain.gridy = 2;
		frame.getContentPane().add(btnReturnToMain, gbc_btnReturnToMain);
	}

	private void executeHangman() {
		user = new User(true, userName, lblUser);
		timer.executeSingleGameController(wordPanel, passwordPanel, hangmanDrawPanel, 5, user);
	}

}
