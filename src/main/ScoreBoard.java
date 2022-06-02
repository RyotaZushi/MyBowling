package main;
import java.util.ArrayList;

public class ScoreBoard {
    private final int nameLength = 10;
    ArrayList<Player> players;

    //コンストラクタ
    public ScoreBoard(ArrayList<Player> players) {
        this.players = players;
    }

    public void printIndex() {
        System.out.print("# |name");
        for (int i = 1; i <= nameLength - 4; i++) {
            System.out.print(" ");
        }
        for (int i = 1; i <= 9; i++) {
            System.out.printf("|  %d ", i);
        }
        System.out.print("|  10  ");
        System.out.print("|total|rank|\n");
    }

    public void printScore() {
        ScoreCalculator.sortPlayers(players);

        int id = 1;
        for(Player p : this.players) {
            //1行目
            System.out.printf("%2d|",id);
            System.out.printf("%-" + this.nameLength + "s|", p.name);
            for (int i = 0; i <= 8; i++) {
                System.out.printf(" %s %s|", p.score[2 * i], p.score[2 * i + 1]);
            }
            System.out.printf(" %s %s %s|", p.score[18], p.score[19], p.score[20]);
            System.out.printf("  %3d|", p.sum[9]);
            System.out.printf(" %2d |\n", p.rank);
            //2行目
            System.out.print("  |");
            for (int i = 1; i <= this.nameLength; i++) {
                System.out.print(" ");
            }
            for (int i = 0; i <= 8; i++) {
                System.out.printf("| %3d", p.sum[i]);
            }
            System.out.printf("|   %3d", p.sum[9]);
            System.out.println("|     |    |");
            id++;
        }
    }

}
