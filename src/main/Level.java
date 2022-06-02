package main;

public class Level {
    String level;
    //それぞれ得点の分布に用いるフィールド
    int strike;//ストライク
    int high;//8~9本
    int middle;//5~7本
    int low;//1~4本
    int garter;//ガータ
    int spare;//スペア（2回目用）

    //コンストラクタ
    public Level(String level) {
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
                //System.out.println(level);
                this.level = "shudou";
                //levelに想定外の値が入っていた場合、shudouに書き換える。
        }
    }


}
