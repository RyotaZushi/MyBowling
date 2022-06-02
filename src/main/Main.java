package main;
import java.util.ArrayList;
import java.util.LinkedHashMap;

public class Main {
	public static void main(String[] args) {

		//参加プレイヤーの名前とレベル設定
		LinkedHashMap<String, String> players = new LinkedHashMap<>();
		players.put("Taro","professional");
		players.put("Jiro", "beginner");
		players.put("Saburo", "shudou");
		players.put("Shiro", "shudou");
		players.put("Goro", "expert");
		players.put("God", "god");//levelに間違った値が入っていた場合

		ArrayList<Player> playerList = new ArrayList<Player>();
		for(String name : players.keySet()) {
			Player pl = new Player(name, players.get(name));
			playerList.add(pl);
			Level lv = new Level(pl.level);
			pl.makeScore(lv);
			pl.writeSum();
		}

		ScoreBoard sb = new ScoreBoard(playerList);
		sb.printIndex();
		sb.printScore();
	}

}
