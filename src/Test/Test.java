package Test;

public class Test {
    public static void main(String[] args) {

        Die die1 = new Die();
        Die die2 = new Die();
        int sum = 0;

        //sikre at der ligger en værdi (rent dobbelt sikkerhed)
        die1.roll();
        die2.roll();

        int n2 = 0, n3 = 0, n4 = 0, n5 = 0, n6 = 0, n7 = 0, n8 = 0, n9 = 0, n10 = 0, n11 = 0, n12 = 0;

        int amountOfRolls = 1000;
        int i;

        for (i = 0; i < amountOfRolls; i++) {
            die1.roll();
            die2.roll();
            sum = die1.getFaceValue() + die2.getFaceValue();

            switch (sum) {
                case 2:
                    n2 += 1;
                    break;
                case 3:
                    n3 += 1;
                    break;
                case 4:
                    n4 += 1;
                    break;
                case 5:
                    n5 += 1;
                    break;
                case 6:
                    n6 += 1;
                    break;
                case 7:
                    n7 += 1;
                    break;
                case 8:
                    n8 += 1;
                    break;
                case 9:
                    n9 += 1;
                    break;
                case 10:
                    n10+= 1;
                    break;
                case 11:
                    n11 += 1;
                    break;
                case 12:
                    n12 += 1;
                    break;
            }
        }
            // print antallet af hver kombination af øjne
        System.out.println(n2);
        System.out.println(n3);
        System.out.println(n4);
        System.out.println(n5);
        System.out.println(n6);
        System.out.println(n7);
        System.out.println(n8);
        System.out.println(n9);
        System.out.println(n10);
        System.out.println(n11);
        System.out.println(n12);

    }

    private static class Die {
        private int faceValue;

        public Die() {
            roll();
        }

        public void roll() {
            final int MAX_VALUE = 6;
            faceValue = (int) (Math.random() * MAX_VALUE) + 1;
        }

        public int getFaceValue() {
            return faceValue;
        }
    }
}
