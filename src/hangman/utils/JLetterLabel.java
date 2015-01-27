package hangman.utils;
import javax.swing.JLabel;


public class JLetterLabel extends JLabel {

	private static final long serialVersionUID = 1L;
	private boolean correct;
	private char letter;

	public JLetterLabel(char _letter){
		super();
		correct = false;
		letter = _letter;
		notifyCorrectChanged();
	}
	
	public boolean isCorrect() {
		return correct;
	}

	public void setCorrect(boolean correct) {
		this.correct = correct;
	}
	
	public char getLetter() {
		return letter;
	}
	
	public void notifyCorrectChanged(){
		if(correct) this.setText(String.valueOf(letter));
		else this.setText("_");
	}
}
