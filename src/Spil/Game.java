package Spil;
import java.util.Scanner;

public class Game {


    private spiller P1;
    private spiller P2;
    private Dice dice;
    private int ScoreForAtVinde = 40;

    void displayGameMenu() {
        System.out.println();
        System.out.println("(1) Start et nyt spil");
        System.out.println("(2) Spil en runde");
        System.out.println("(3) Hvem fører??");
        System.out.println("(4) Afslut spil");
        System.out.print("Vælg en mulighed: ");
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
            default:
                break;
        }
    }

    void VisSpilInstruktion() {
        String P1Navn;
        String P2Navn;

        Scanner sc = new Scanner(System.in);
        System.out.print("Indtast venligst først spillers navn: ");
        P1Navn = sc.nextLine();
        System.out.print("Indtast venligst anden spillers navn: ");
        P2Navn = sc.nextLine();


        P1 = new spiller(P1Navn);
        P2 = new spiller(P2Navn);
        dice = new Dice();
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
            System.out.format("Det står lige, "
                            + "%s har %d, %s har %d",
                    P1.getName(), P1.getTotalScore(),
                    P2.getName(), P2.getTotalScore()
            );
        } else if (P1.getTotalScore() > P2.getTotalScore()) {
            System.out.printf("%s fører, %s har %d point, "
                            + "%s har %d point",
                    P1.getName(), P1.getName(), P1.getTotalScore(),
                    P2.getName(), P2.getTotalScore());
        } else if (P1.getTotalScore() < P2.getTotalScore()) {
            System.out.format("%s fører, %s har %d point, "
                            + "%s har %d point.",
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
        System.out.println("Velkommen til terningespillet!");

        Game game = new Game();

        int optionSelected;

        while (true) {
            game.displayGameMenu();
            System.out.println();
            Scanner sc = new Scanner(System.in);
            optionSelected = sc.nextInt();

            while (optionSelected > 4 || optionSelected < 0) {

                System.out.print("Mulighed ikke tilgængelig. Indtast veligst et tal mellem 1 og 5: ");
                optionSelected = sc.nextInt();
            }

            if (optionSelected == 4) {
                System.out.println("Afslutter Spil");
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
