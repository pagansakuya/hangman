package hangman.windows;

import hangman.utils.MenuWindow;
import hangman.utils.WordDatabase;

import java.awt.EventQueue;

import javax.swing.DefaultListModel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.BorderLayout;

import javax.swing.JTextField;

import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JPanel;
import javax.swing.JList;
import javax.swing.JScrollPane;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

public class NewWordWindow extends MenuWindow{

	private JTextField txtPassword;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					NewWordWindow window = new NewWordWindow();
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
	public NewWordWindow() {
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
		frame.getContentPane().add(panel, BorderLayout.NORTH);

		JLabel lblNewLabel = new JLabel("Type a new password:");
		panel.add(lblNewLabel);

		txtPassword = new JTextField();
		panel.add(txtPassword);
		txtPassword.setColumns(10);

		JPanel panel_1 = new JPanel();
		frame.getContentPane().add(panel_1, BorderLayout.SOUTH);

		JButton btnNewButton = new JButton("OK");
		panel_1.add(btnNewButton);

		JButton btnNewButton_1 = new JButton("Return");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				MainMenuWindow window = new MainMenuWindow();
				window.frame.setVisible(true);
			}
		});
		panel_1.add(btnNewButton_1);
		
		JButton btnGetRandomWord = new JButton("Get random word!");
		btnGetRandomWord.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(panel, WordDatabase.getInstance().getRandomWord());
			}
		});
		panel_1.add(btnGetRandomWord);
		
		JScrollPane scrollPane = new JScrollPane();
		frame.getContentPane().add(scrollPane, BorderLayout.CENTER);
		
		DefaultListModel<String> model = new DefaultListModel<String>();
		model.removeAllElements();
		for (String pass : WordDatabase.getInstance().getDatabase())
			model.addElement(pass);
		
		JList<String> list = new JList<String>();
		list.setModel(model);
		scrollPane.setViewportView(list);
		
		list.addListSelectionListener(new ListSelectionListener() {
			
			@Override
			public void valueChanged(ListSelectionEvent arg0) {
				// TODO Auto-generated method stub
				int location = list.getSelectedIndex();
				if(location != -1) {
					model.remove(location);
					WordDatabase.getInstance().getDatabase().remove(location);
				}
			}
		});		

		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (!txtPassword.getText().isEmpty()) {
					WordDatabase.getInstance().getDatabase()
							.add(txtPassword.getText());
					model.addElement(txtPassword.getText());
				}
			}
		});
	}

}
