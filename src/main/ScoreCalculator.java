package main;

import java.util.ArrayList;

public class ScoreCalculator {

    public int[] translateScore(String[] score) {
        int j = 0;//translatedを指す添字
        int[] translated = new int[21];
        for (int i = 0; i <= 20; i++) {
            //iはscoreの添字
            switch(score[i]){
                case "X":
                    translated[j] = 10;
                    break;
                case "G", "-":
                    translated[j] = 0;
                    break;
                case "/":
                    translated[j] = 10 - translated[j-1];
                    break;
                case " ":
                    j--;
                    break;
                default:
                    translated[j] = Integer.parseInt(score[i]);
            }
            j++;
        }
        return translated;
    }

    public int[] calculateTotal(String[] score) {
        int[] translated = translateScore(score);
        int[] sum = new int[10];
        int j = 0;
        int prevSum = 0;
        for(int i = 0; i <= 9; i++) {
            if(translated[j] == 10) {
                //ストライクのとき
                sum[i] = 10 + translated[j + 1] + translated [j + 2] + prevSum;
                j++;
            }else if(translated[j] + translated[j + 1] == 10) {
                sum[i] = 10 + translated [j + 2] + prevSum;
                j += 2;
            }else{
                sum[i] = translated[j] + translated[j + 1] + prevSum;
                j += 2;
            }
            prevSum = sum[i];
        }
        return sum;
    }

    public static void sortPlayers(ArrayList<Player> players) {
        for(Player p: players){
            int rank = 1;
            for(Player q: players) {
                if(p.sum[9] < q.sum[9]) {
                    rank++;
                }
            }
            p.rank = rank;
        }

    }

}
