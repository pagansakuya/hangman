package hangman.utils;

import javax.swing.JLabel;

public class User {
	
	public int numberOfFails;
	private JLabel userLabel;
	public String userName;
	private boolean isActive;
	
	public User(boolean _isActive, String _userName, JLabel _label){
		userName = _userName;
		numberOfFails = 0;
		userLabel = _label;
		setActive(_isActive);
	}
	
	public boolean isActive(){
		return this.isActive;
	}
	
	public void setActive(boolean _active){
		isActive = _active;
		notifyActiveChanged();
	}
	
	private void notifyActiveChanged(){
		this.userLabel.setText(this.userName + (this.isActive()?"*":""));
	}
}
