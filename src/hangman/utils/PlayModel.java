package hangman.utils;

public class PlayModel {
	private User user1;
	private User user2;
	public String result;
	public String password;
	
	public PlayModel(User user){
		user1 = user;
		user2 = null;
	}
	
	public PlayModel(User user1, User user2){
		this.user1 = user1;
		this.user2 = user2;
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		if(user2==null){
			// single player
			return user1.userName + " Number of failures: " + user1.numberOfFails + " Result: " + result + " Password: " + this.password;
		} else {
			return user1.userName + "- fails: " + user1.numberOfFails + " vs. " + user2.userName + "- fails: " + user2.numberOfFails + " Result: " + result + " Password: " + this.password;
		}
		
	}
}
