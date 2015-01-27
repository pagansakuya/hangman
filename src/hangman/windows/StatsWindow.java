package hangman.windows;

import hangman.utils.PlayDatabase;
import hangman.utils.PlayModel;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JScrollPane;

import java.awt.BorderLayout;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JList;
import javax.swing.JLabel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class StatsWindow {

	protected JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					StatsWindow window = new StatsWindow();
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
	public StatsWindow() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JScrollPane scrollPane = new JScrollPane();
		frame.getContentPane().add(scrollPane, BorderLayout.CENTER);
		
		DefaultListModel<PlayModel> model = new DefaultListModel<PlayModel>();		
		
		JList<PlayModel> list = new JList<PlayModel>(model);
		model.removeAllElements();
		for(PlayModel mdl : PlayDatabase.getInstance().getDatabase()){
			model.addElement(mdl);
		}
		scrollPane.setViewportView(list);
		
		JButton btnReturn = new JButton("Return");
		btnReturn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				frame.dispose();
				MainMenuWindow window = new MainMenuWindow();
				window.frame.setVisible(true);
			}
		});
		frame.getContentPane().add(btnReturn, BorderLayout.SOUTH);
		
		JLabel lblNewLabel = new JLabel("Play statistics");
		frame.getContentPane().add(lblNewLabel, BorderLayout.NORTH);
	}

}
