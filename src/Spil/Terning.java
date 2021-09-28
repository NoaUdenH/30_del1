package Spil;

public class Terning {
    private final int MAX = 6; // maksimal antal øjne på en terning

    private int antalOjne; // den værdi terningen viser


    public Terning() {antalOjne = 1;} // start værdi for terningen


    // generere kast med et tilfældigt antal øjne
    public int kast(){
        antalOjne = (int)(Math.random() * MAX) + 1;
        return  antalOjne;
    }

    // get og set
    public void setAntalOjne (int vaerdi) { antalOjne = vaerdi; }
    public int getAntalOjne() { return antalOjne; }


    // Repræsenterer terningen som en String
    public String toString(){
        String resultat = Integer.toString(antalOjne);
        return resultat;
    }
}
