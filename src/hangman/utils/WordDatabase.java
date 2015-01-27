package hangman.utils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class WordDatabase {

	private List<String> database = new ArrayList<String>(Arrays.asList(
			"komputer", 
			"konstantynopol",
			"wiklina",
			"podroz",
			"rumun"
			));

	private static final WordDatabase instance = new WordDatabase();

	// private constructor to avoid client applications to use constructor
	private WordDatabase() {
	}

	public static WordDatabase getInstance() {
		return instance;
	}

	public List<String> getDatabase() {
		return database;
	}
	
	public String getRandomWord(){
		Random random = new Random();
		int item = random.nextInt(database.size());
		return database.get(item);
	}

}
