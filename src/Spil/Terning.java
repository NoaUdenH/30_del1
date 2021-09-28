package Spil;

public class Terning {
    private final int MAX = 6; // maksimal antal øjne på en terning

    private int antalØjne; // den værdi terningen viser


    public Terning() {antalØjne = 1;} // start værdi for terningen


    // generere kast med et tilfældigt antal øjne
    public int kast(){
        antalØjne = (int)(Math.random() * MAX) + 1;
        return  antalØjne;
    }

    // get og set
    public void setAntalØjne (int værdi) { antalØjne = værdi; }
    public int getAntalØjne() { return antalØjne; }


    // Repræsenterer terningen som en String
    public String toString(){
        String resultat = Integer.toString(antalØjne);
        return resultat;
    }
}
