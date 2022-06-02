package main;

import java.util.Arrays;

import static java.lang.Integer.max;

public class Player {
    String name;
    String level;
    String[] score = new String[21];
    int[] sum;
    int rank;

    private final String[] levelType = {"professional", "expert", "normal", "beginner", "shudou"};

    //コンストラクタ
    public Player(String name, String level) {
        this.name = name;
        if(Arrays.asList(levelType).contains(level)) {
            this.level = level;
        }else{
            this.level = "normal";
        }
        //System.out.println(this.level);
    }

    public void writeSum() {
        this.sum = ScoreCalculator.calculateTotal(this.score);
    }

    public void makeScore(Level lv) {
        if(lv.level.equals("shudou")) {
            //手入力用
            this.score =new String[] {"G", "-", "3", "/", "X", " ", "4", "-", "2", "/",
                    "X", " ", "X", " ", "1", "6", "3", "5", "2", "/", "8"};
            return;
        }
        //ここから本題
        for(int i = 0; i <= 9; i++) {
            score[2 * i] = firstBall(lv);
            score[2 * i + 1] = secondBall(lv, score[2 * i]);
        }
        score[20] = " ";
        //score[20]は基本的に空白
        //10フレーム目でストライクorスペアを取った場合に以下で書き換える。
        //10フレーム目の第1投にストライクを取った場合
        if(score[18].equals("X")) {
            score[19] = firstBall(lv);
            score[20] = secondBall(lv, score[19]);
        }
        //10フレーム目の第2投にストライクかスペアを取った場合
        if(score[19].equals("X") || score[19].equals("/")) {
            score[20] = firstBall(lv);
        }
    }

    public String firstBall(Level lv) {
        int rand = new java.util.Random().nextInt(101);
        if(rand < lv.garter) {
            //ガータの処理
            return "G";
        }else if(rand < lv.garter + lv.low ) {
            //lowスコアの処理
            return String.valueOf(new java.util.Random().nextInt(4) + 1);
        }else if(rand < lv.garter + lv.low + lv.middle) {
            //middleスコアの処理
            return String.valueOf(new java.util.Random().nextInt(3) + 5);
        }else if(rand < lv.garter + lv.low + lv.middle + lv.high) {
            //highスコアの処理
            return String.valueOf(new java.util.Random().nextInt(2) + 8);
        }else{
            //ストライク！
            return "X";
        }
    }

    public String secondBall(Level lv, String first) {
        //firstNumに1回目の得点を数字で代入
        int firstNum;
        if(first.equals("X")) {
            return " ";
        }else if(first.equals("G")) {
            firstNum = 0;
        }else{
            firstNum = Integer.parseInt(first);
        }
        int spareRate = max(lv.spare - firstNum * 5, lv.strike);

        int rand = new java.util.Random().nextInt(101);
        if(rand < lv.garter) {
            return "-";
            //ガータの処理
        }else if(rand < lv.garter + spareRate ) {
            //スペアの処理
            return "/";
        }else{
            int _2ndScore = new java.util.Random().nextInt(10 - firstNum);
            if(_2ndScore == 0) {
                return "-";
            }else{
                return String.valueOf(_2ndScore);
            }
        }
    }

}
