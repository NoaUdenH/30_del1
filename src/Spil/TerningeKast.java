package Spil;

public class TerningeKast {

        String Terningekast() {

            // Opretter et objekt til terningekast og ruller dem
            Terning terning1, terning2;
            int sum;

            terning1 = new Terning();
            terning2 = new Terning();

            terning1.kast();
            terning2.kast();


            sum = terning1.getAntalOjne() + terning2.getAntalOjne();

            return Terningekast();
        }

}
