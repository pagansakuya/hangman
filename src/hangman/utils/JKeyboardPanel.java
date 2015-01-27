package hangman.utils;
import hangman.engine.JTimerPanel;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;


public class JKeyboardPanel extends JPanel {

	private static final long serialVersionUID = 1L;
	private char currentLetter;

	private String keyLine = "qwertyuiopasdfghjklzxcvbnm";
	
	public JKeyboardPanel(){
		this.setLayout(new GridLayout(3,0,0,0));
		this.setBackground(Color.LIGHT_GRAY);
		
		JPanel panel1 = new JPanel();
		panel1.setLayout(new FlowLayout());
		JPanel panel2 = new JPanel();
		panel2.setLayout(new FlowLayout());
		JPanel panel3 = new JPanel();
		panel3.setLayout(new FlowLayout());
		
		this.add(panel1);
		this.add(panel2);
		this.add(panel3);
		
		for(int i = 0; i<keyLine.length();i++){
			JButton btn = new JButton(String.valueOf(keyLine.charAt(i)));
			btn.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					btn.setEnabled(false);
					currentLetter = btn.getText().charAt(0);
					JTimerPanel.breakTheTimer();
					//JOptionPane.showMessageDialog(btn, btn.getText().charAt(0));
				}
			});
			if(i>=0 && i<10) panel1.add(btn);
			if(i>=10 && i<19) panel2.add(btn);
			if(i>=19 && i<=25) panel3.add(btn);
		}
	}

	public char getCurrentLetter() {
		return currentLetter;
	}
}
