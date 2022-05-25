package main;

import java.util.Arrays;
import java.util.List;

public class Player {
    String name;
    String level;
    String[] score;
    int[] sum;
    int rank;

    private String[] levelType = {"professional", "expert", "normal", "beginner", "shudou"};

    //コンストラクタ
    public Player(String name, String level) {
        this.name = name;
        if(Arrays.asList(levelType).contains(level)) {
            this.level = level;
        }else{
            this.level = "normal";
        }
    }
    public Player(String name) {
        this(name, "normal");
    }
    public Player() {
        this("player");
    }
    
    public void writeScore() {
        ScoreMaker sm = new ScoreMaker(this.level);
        this.score = sm.makeScore();
    }

    public void writeSum() {
        ScoreCalculator sc = new ScoreCalculator();
        this.sum = sc.calculateTotal(this.score);
    }
}
