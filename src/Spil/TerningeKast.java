package Spil;

public class TerningeKast {
    public static void main (String[] args)
    {
        // Opretter et objekt til terningekast og ruller dem

        Terning terning1, terning2;
        int sum;

        terning1 = new Terning();
        terning2 = new Terning();

        terning1.kast();
        terning2.kast();
        System.out.println("Terning 1: " + terning1 + " Terning 2: " + terning2);

        sum = terning1.getAntalOjne() + terning2.getAntalOjne();
        System.out.println("Sum: " + sum);


    }
}
