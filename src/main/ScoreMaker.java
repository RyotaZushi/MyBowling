/*package main;

import static java.lang.Integer.max;

public class ScoreMaker {
    String level;
    //それぞれ得点の分布に用いるフィールド
    int strike;//ストライク
    int high;//8~9本
    int middle;//5~7本
    int low;//1~4本
    int garter;//ガータ
    int spare;//スペア（2回目用）


    public ScoreMaker(String level) {
        this.level=level;

        //playerのlevelによってフィールドの設定を行う。
        switch(this.level) {
            case "professional":
                this.strike = 85;
                this.high = 10;
                this.middle = 3;
                this.low = 1;
                this.garter = 1;
                this.spare = 100;
                break;
            case "expert":
                this.strike = 40;
                this.high = 30;
                this.middle = 15;
                this.low = 10;
                this.garter = 5;
                this.spare = 80;
                break;
            case "normal":
                this.strike = 20;
                this.high = 25;
                this.middle = 25;
                this.low = 15;
                this.garter = 10;
                this.spare = 50;
                break;
            case "beginner":
                this.strike = 5;
                this.high = 30;
                this.middle = 30;
                this.low = 25;
                this.garter = 15;
                this.spare = 30;
                break;
            default:
                this.level = "shudou";
                //levelに想定外の値が入っていた場合、shudouに書き換える。
        }
    }

    public String[] makeScore() {
        if(level == "shudou") {
            //テスト用
            String[] score = {"G", "-", "3", "/", "X", " ", "4", "-", "2", "/",
                    "X", " ", "X", " ", "1", "6", "3", "5", "2", "/", "8"};
            return score;
        }
        //ここから本題
        String[] score = new String[21];
        for(int i = 0; i <= 9; i++) {
            score[2 * i] = firstBall();
            score[2 * i + 1] = secondBall(score[2 * i]);
        }
        score[20] = " ";
        //score[20]は基本的に空白
        //10フレーム目でストライクorスペアを取った場合に以下で書き換える。
        //10フレーム目の第1投にストライクを取った場合
        if(score[18] == "X") {
            score[19] = firstBall();
            score[20] = secondBall(score[19]);
        }
        //10フレーム目の第2投にストライクかスペアを取った場合
        if(score[19] == "X" || score[19] == "/") {
            score[20] = firstBall();
        }

        return score;
    }

    public String firstBall() {
        int rand = new java.util.Random().nextInt(101);
        int score;
        if(rand < this.garter) {
            //ガータの処理
            return "G";
        }else if(rand < this.garter + this.low ) {
            //lowスコアの処理
            return String.valueOf(new java.util.Random().nextInt(4) + 1);
        }else if(rand < this.garter + this.low + this.middle) {
            //middleスコアの処理
            return String.valueOf(new java.util.Random().nextInt(3) + 5);
        }else if(rand < this.garter + this.low + this.middle + this.high) {
            //highスコアの処理
            return String.valueOf(new java.util.Random().nextInt(2) + 8);
        }else{
            //ストライク！
            return "X";
        }
    }

    public String secondBall(String first) {
        //firstNumに1回目の得点を数字で代入
        int firstNum;
        if(first == "X") {
            return " ";
        }else if(first == "G") {
            firstNum = 0;
        }else{
            firstNum = Integer.parseInt(first);
        }
        int spareRate = max(spare - firstNum * 5, this.strike);

        int rand = new java.util.Random().nextInt(101);
        if(rand < this.garter) {
            return "-";
            //ガータの処理
        }else if(rand < this.garter + this.spare ) {
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
 */
