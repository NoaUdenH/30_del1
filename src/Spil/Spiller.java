package Spil;

public class Spiller {
    private final String navn;
    private int samletScore;

    Spiller(String navn){
        this.navn = navn;
    }

    String getNavn(){
        return navn;
    }

    int getSamletScore(){
        return samletScore;
    }

    void  setSamletScore(int score){
        samletScore += score;
    }


}
