package Spil;
public class spiller {
    private final String name;
    private int totalScore;

    spiller(String name){
        this.name = name;
    }

    String getName(){
        return name;
    }

    int getTotalScore(){
        return totalScore;
    }

    void setTotalScore(int score){
        totalScore += score;
    }

}