package hangman.engine;

import hangman.utils.JHangmanGraph;
import hangman.utils.JKeyboardPanel;
import hangman.utils.JPasswordPanel;
import hangman.utils.PlayDatabase;
import hangman.utils.PlayModel;
import hangman.utils.User;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.Timer;

public class JTimerPanel extends JPanel {

	private static final long serialVersionUID = 1L;

	public JLabel seconds, miliseconds;
	private Timer timer;
	private static boolean timerBreak;
	public boolean result;

	public JTimerPanel() {
		this.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));

		seconds = new JLabel("0");
		this.add(seconds);

		JLabel separator = new JLabel(":");
		this.add(separator);

		miliseconds = new JLabel("000");
		this.add(miliseconds);
		timerBreak = false;

	}

	public void executeSingleGameController(JKeyboardPanel panel,
			JPasswordPanel password, JHangmanGraph graph, int delayInSeconds, User user) {
		timerBreak = false;
		long startTime = System.currentTimeMillis();

		timer = new Timer(1, new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {

				long endTime = startTime + delayInSeconds * 1000;
				long currentTime = System.currentTimeMillis();
				long timeDifference = currentTime - startTime;
				long secondDifference = (int) (currentTime - startTime) / 1000;

				seconds.setText(String.valueOf(secondDifference));
				miliseconds.setText(String
						.valueOf(timeDifference
								- (timeDifference > 1000 ? secondDifference * 1000
										: 0)));

				char chrToGuess = panel.getCurrentLetter();

				if (currentTime == endTime || timerBreak) {
					timer.stop();
					result = password.guess(chrToGuess);
					if (!result){
						graph.hangmanStep++;
						user.numberOfFails++;
					}
					graph.repaint();

					JOptionPane.showMessageDialog(panel, "Stop! You "
							+ ((result) ? "guessed" : "didn't guess")
							+ " the letter!");
					boolean winner = password.isAllSolved();

					if (graph.hangmanStep < 4 && !winner)
						executeSingleGameController(panel, password, graph,
								delayInSeconds, user);
					else {
						JOptionPane.showMessageDialog(panel, "Game over! You "
								+ ((winner) ? "won" : "lost") + "!");
						PlayModel model = new PlayModel(user);
						model.password = password.getPassword();
						model.result = ((winner) ? "won" : "lost");
						PlayDatabase.getInstance().getDatabase().add(model);
						password.solveTheMystery();
					}
				}
			}
		});

		timer.start();
	}

	public void executeMultiGameController(JKeyboardPanel panel,
			JPasswordPanel password, JHangmanGraph graph, int delayInSeconds,
			User user1, User user2) {
		timerBreak = false;
		long startTime = System.currentTimeMillis();

		timer = new Timer(1, new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {

				long endTime = startTime + delayInSeconds * 1000;
				long currentTime = System.currentTimeMillis();
				long timeDifference = currentTime - startTime;
				long secondDifference = (int) (currentTime - startTime) / 1000;

				seconds.setText(String.valueOf(secondDifference));
				miliseconds.setText(String
						.valueOf(timeDifference
								- (timeDifference > 1000 ? secondDifference * 1000
										: 0)));

				char chrToGuess = panel.getCurrentLetter();

				if (currentTime == endTime || timerBreak) {
					timer.stop();

					result = password.guess(chrToGuess);

					JOptionPane.showMessageDialog(panel, "Stop! You "
							+ ((result) ? "guessed" : "didn't guess")
							+ " the letter!");

					if (user1.isActive()) {
						if (!result)
							user1.numberOfFails++;
						user1.setActive(false);
						user2.setActive(true);
					} else if (user2.isActive()) {
						if (!result)
							user2.numberOfFails++;
						user1.setActive(true);
						user2.setActive(false);
					}

					if (!result) {
						graph.hangmanStep++;
					}

					graph.repaint();

					JOptionPane.showMessageDialog(
							panel,
							String.valueOf(user1.numberOfFails) + " "
									+ String.valueOf(user2.numberOfFails));

					boolean winner = password.isAllSolved();

					if (graph.hangmanStep < 4 && !winner)
						executeMultiGameController(panel, password, graph,
								delayInSeconds, user1, user2);
					else {
						JOptionPane.showMessageDialog(panel, "Game over! You "
								+ ((winner) ? "won" : "lost") + "!");
						
						PlayModel model = new PlayModel(user1,user2);
						model.password = password.getPassword();
						model.result = ((winner) ? "won" : "lost");
						PlayDatabase.getInstance().getDatabase().add(model);

						password.solveTheMystery();
						// wygrywa ten, kto zaliczyl mniej faili

						if (user1.numberOfFails < user2.numberOfFails)
							JOptionPane.showMessageDialog(panel,
									"Player 1 won the battle");
						else if (user2.numberOfFails < user1.numberOfFails)
							JOptionPane
									.showMessageDialog(panel, "Player 2 won");
						else
							JOptionPane.showMessageDialog(panel, "Draw!");
					}
				}
			}
		});

		timer.start();
	}

	public static void breakTheTimer() {
		timerBreak = true;
	}
}
