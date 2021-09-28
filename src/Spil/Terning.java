package Spil;

public class Terning {
    private final int MAX = 6; // maksimal antal øjne

    private int antalØjne; // terningens værdi


    public Terning() {antalØjne = 1;} // start værdi for terningen


    public int kast(){
        antalØjne = (int)(Math.random() * MAX) + 1;
        return  antalØjne;
    }

    public void setAntalØjne (int værdi) { antalØjne = værdi; }
    public int getAntalØjne() { return antalØjne; }


    public String toString(){
        String resultat = Integer.toString(antalØjne);
        return resultat;
    }
}
