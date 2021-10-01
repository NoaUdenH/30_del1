import java.util.Arrays;
import java.util.Scanner;
import java.util.Arrays;

public class Game {


    private spiller P1;
    private spiller P2;
    private Dice dice;
    private int ScoreForAtVinde = 40;

    void displayGameMenu() {
        System.out.println();
        System.out.println("(1) Start et nyt spil");
        System.out.println("(2) Spil en runde");
        System.out.println("(3) Who is leading now?");
        System.out.println("(4) test");
        System.out.println("(5) Afslut spil");
        System.out.print("Vælg en option: ");
    }

    void selectGameOption(int optionSelected) {
        switch (optionSelected) {
            case 1:
                this.VisSpilInstruktion();
                break;
            case 2:
                this.playOneRound(P1);
                this.playOneRound(P2);
                break;
            case 3:
                this.whoIsLeading();
                break;
            case 4:
                this.test(P1);
            default:
                break;
        }
    }

    void VisSpilInstruktion() {
        String P1Navn;
        String P2Navn;

        Scanner sc = new Scanner(System.in);
        System.out.print("Indtast venligst først spillerens navn: ");
        P1Navn = sc.nextLine();
        System.out.print("Indtast venligst anden spillerens navn: ");
        P2Navn = sc.nextLine();


        P1 = new spiller(P1Navn);
        P2 = new spiller(P2Navn);
        dice = new Dice();
    }

    void test(spiller n) {


        for (int i = 0; i < 1000; i++) {


            int gen = dice.rollDice();
            int gen1 = dice.rollDice();
            n.getTotalScore();
            int result = Integer.sum(gen, gen1);
            System.out.println(i + "=" + Integer.sum(gen, gen1));

           /* int[] numbers = new int[1000];
            for (int d = 0; d < 1000; d++) {
                numbers[d] = result;
                System.out.println(d + "=" + Arrays.toString(numbers));
            }

*/
        }
         /*   System.out.println(i + "=" + Integer.sum(gen, gen1));
            System.out.println(result);
*/

           /* for (int d = 0; d < 1000; d++) {
                numbers[d] = result;
                System.out.println(d + "=" + Arrays.toString(numbers));
            }

            // System.out.println(i + "=" + Integer.sum(gen, gen1));

*/






           /*
             System.out.println(numbers.length);
            System.out.println(Arrays.toString(numbers));
            for (int k = 0; k < numbers.length; ) {
                int key = numbers[k];
                int counter = 0;
                for (int j = k; j < numbers.length; j++) {
                    if (key == numbers[j]) {
                        counter++;
                    } else {
                        k = j;
                        break;
                    }
                    if (counter >= 1) {
                        System.out.println(key + ":" + counter + "gange");
                    }




*/

                /*
                 System.out.println(result);

             System.out.println(Arrays.toString(numbers));Arrays.sort(thirteenMultiples);
                System.out.println(thirteenMultiples.length);
                System.out.println(i + "=" + thirteenMultiples.length);
*/
    }


    void playOneRound(spiller p) {
        int result;

        int FørsteTerningKast = dice.rollDice();
        int AndenTerningKast = dice.rollDice();


        if (FørsteTerningKast == AndenTerningKast) {
            result = (FørsteTerningKast + AndenTerningKast) * 2;
            p.setTotalScore(result);
            System.out.printf("%s rolled %d and %d, "
                            + "and scored %d points(BONUS DOUBLE POINTS), "
                            + "for a total of %d points",
                    p.getName(), FørsteTerningKast, AndenTerningKast,
                    result, p.getTotalScore()
            );
        } else {
            result = (FørsteTerningKast + AndenTerningKast);
            p.setTotalScore(result);
            System.out.printf("%s rolled %d and %d, "
                            + "and scored %d points, "
                            + "for a total of %d points",
                    p.getName(), FørsteTerningKast, AndenTerningKast,
                    result, p.getTotalScore()
            );
        }

        System.out.println();
    }

    void whoIsLeading() {
        if (P1.getTotalScore() == P2.getTotalScore()) {
            System.out.format("Its currently a draw, "
                            + "%s has %d, %s has %d",
                    P1.getName(), P1.getTotalScore(),
                    P2.getName(), P2.getTotalScore()
            );
        } else if (P1.getTotalScore() > P2.getTotalScore()) {
            System.out.printf("%s is leading, %s has %d points, "
                            + "%s has %d points",
                    P1.getName(), P1.getName(), P1.getTotalScore(),
                    P2.getName(), P2.getTotalScore());
        } else if (P1.getTotalScore() < P2.getTotalScore()) {
            System.out.format("%s is leading, %s has %d points, "
                            + "%s has %d points.",
                    P2.getName(), P2.getName(), P2.getTotalScore(),
                    P1.getName(), P1.getTotalScore()
            );
        }
    }

    boolean TjekHvisNogenHarVndet() {
        if (P1.getTotalScore() >= ScoreForAtVinde && P2.getTotalScore() >= ScoreForAtVinde) {
            System.out.println("Det er uafgjort! Begge spillere har overskredet scoregrænsen");
            return true;
        } else if (P1.getTotalScore() >= ScoreForAtVinde && P2.getTotalScore() < ScoreForAtVinde) {
            System.out.format("%s vandt", P1.getName());
            return true;
        } else if (P1.getTotalScore() < ScoreForAtVinde && P2.getTotalScore() >= ScoreForAtVinde) {
            System.out.format("%s vandt", P2.getName());
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        System.out.println("Welcome to the Dice and Roll game!");

        Game game = new Game();

        int optionSelected;

        while (true) {
            game.displayGameMenu();
            System.out.println();
            Scanner sc = new Scanner(System.in);
            optionSelected = sc.nextInt();

            while (optionSelected > 5 || optionSelected < 0) {

                System.out.print("Option entered invalid, please enter a number from 1 to 5: ");
                optionSelected = sc.nextInt();
            }

            if (optionSelected == 5) {
                System.out.println("Exiting Spill");
                break;
            }

            game.selectGameOption(optionSelected);

            boolean anyoneWin = game.TjekHvisNogenHarVndet();
            if (anyoneWin) {
                System.out.println();
                System.out.println("Spillet sluttede .");
                break;
            }
        }
    }

}