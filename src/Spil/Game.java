package Spil;
import java.util.Scanner;

public class Game {


    private player P1;
    private player P2;
    private Dice dice;
    private int scoreToWin = 40;

    void displayGameMenu() {
        System.out.println();
        System.out.println("(1) Start new game");
        System.out.println("(2) Play a round");
        System.out.println("(3) Who's in the lead??");
        System.out.println("(4) Test 1000 dice throws");
        System.out.println("(5) End game");
        System.out.print("Choose an option: ");
    }

    void selectGameOption(int optionSelected) {
        switch (optionSelected) {
            case 1:
                this.showGameOptions();
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

    void showGameOptions() {
        String P1Name;
        String P2Name;

        Scanner sc = new Scanner(System.in);
        System.out.print("Please enter the name of the first player: ");
        P1Name = sc.nextLine();
        System.out.print("Please enter the name of the second player: ");
        P2Name = sc.nextLine();


        P1 = new player(P1Name);
        P2 = new player(P2Name);
        dice = new Dice();
    }

    void test(player n) {


        for (int i = 0; i < 1000; i++) {


            int gen = dice.rollDice();
            int gen1 = dice.rollDice();
            n.getTotalScore();
            int result = Integer.sum(gen, gen1);
            System.out.println(i + "=" + Integer.sum(gen, gen1));

        }
    }


    void playOneRound(player p) {
        int result;

        int firstDiceThrow = dice.rollDice();
        int secondDiceThrow = dice.rollDice();


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

    boolean checkIfSomeoneHasWon() {
        if (P1.getTotalScore() >= scoreToWin && P2.getTotalScore() >= scoreToWin) {
            System.out.println("It's a draw! Both players have exceeded the scoreline");
            return true;
        } else if (P1.getTotalScore() >= scoreToWin && P2.getTotalScore() < scoreToWin) {
            System.out.format("%s won", P1.getName());
            return true;
        } else if (P1.getTotalScore() < scoreToWin && P2.getTotalScore() >= scoreToWin) {
            System.out.format("%s won", P2.getName());
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
                System.out.println("Exiting Game");
                break;
            }

            game.selectGameOption(optionSelected);

            boolean anyoneWin = game.checkIfSomeoneHasWon();
            if (anyoneWin) {
                System.out.println();
                System.out.println("Game is over");
                break;
            }
        }
    }

}