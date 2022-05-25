package main;
import java.util.ArrayList;

public class Main {
	public static void main(String[] args){
		final int numberOfPlayers = 5;
		String[] playerLevel ={"professional", "expert", "normal", "beginner", "shudou"};
		ArrayList<Player> players = new ArrayList<Player>();
		for(int i = 0; i< numberOfPlayers; i++) {
			players.add(new Player("testPlayer" + (i + 1 ), playerLevel[i]));
			players.get(i).writeScore();
			players.get(i).writeSum();
		}

		ScoreBoard sb = new ScoreBoard(players);
		sb.printIndex();
		sb.printScore();
	}

}
