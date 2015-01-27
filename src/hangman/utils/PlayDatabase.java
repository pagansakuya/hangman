package hangman.utils;

import java.util.ArrayList;
import java.util.List;

public class PlayDatabase {
	private List<PlayModel> database = new ArrayList<PlayModel>();

	private static final PlayDatabase instance = new PlayDatabase();

	// private constructor to avoid client applications to use constructor
	private PlayDatabase() {
	}

	public static PlayDatabase getInstance() {
		return instance;
	}

	public List<PlayModel> getDatabase() {
		return database;
	}
}
