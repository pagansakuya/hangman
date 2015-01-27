package hangman.utils;
import java.awt.FlowLayout;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JPanel;


public class JPasswordPanel extends JPanel {
	
	private static final long serialVersionUID = 1L;
	private String password;
	private List<JLetterLabel> letters = new ArrayList<JLetterLabel>();
	
	public JPasswordPanel(String _password){
		this.setLayout(new FlowLayout());
		password = _password;
		generateLetters();
	}
	
	public String getPassword(){
		return password;
	}
	
	private void generateLetters(){
		for(int i = 0; i<password.length();i++){
			JLetterLabel letter = new JLetterLabel(password.charAt(i));
			letters.add(letter);
		}
		for(JLetterLabel letter : letters ) this.add(letter);
	}
	
	public boolean guess(char _toGuess){
		boolean wasCorrect = false;
		for(JLetterLabel letter: letters){
			if(letter.getLetter() == _toGuess) {
				letter.setCorrect(true);
				wasCorrect = true;
			}
		}
		notifyCorrectChanged();
		return wasCorrect;
	}
	
	private void notifyCorrectChanged(){
		for(JLetterLabel letter: letters) letter.notifyCorrectChanged();
	}
	
	public void solveTheMystery(){
		for (JLetterLabel letter:letters )letter.setCorrect(true);
		notifyCorrectChanged();
	}
	
	public boolean isAllSolved(){
		boolean wereSolved = true;
		for(JLetterLabel letter:letters){
			// jezeli ktoras nie jest poprawna, to znaczy, ze nie wszystko zostalo rozwiazane
			if(!letter.isCorrect()){
				wereSolved = false;
				break;
			}
		}
		return wereSolved;
	}
}
