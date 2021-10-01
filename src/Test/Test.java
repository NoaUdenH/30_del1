package Test;

public class Dice_without_array_statistics {
    public static void main(String[] args) {

        Die die1 = new Die();
        Die die2 = new Die();
        int sum = 0;

        //sikre at der ligger en værdi (rent dobbelt sikkerhed)
        die1.roll();
        die2.roll();

        int n2,n3,n4,n5,n6,n7,n8,n9,n10,n11,n12 = 0;

        int amountOfRolls = 1000;

        for(i=0; i<amountOfRolls; i++){
            die1.roll();
            die2.roll();
            sum = die1.getFaceValue() + die2.getFaceValue();

            switch (sum){
                case 2:
                    n2++;
                    break;
            }


        }



    }

    private static class Die(){
        private int faceValue;

        public Die(){
            roll();
        }

        public void roll() {
            final int MAX_VALUE = 6;
            faceValue =  (int)(Math.random() * MAX_VALUE) + 1;
        }

        public int getFaceValue(){
            return faceValue;
        }
    }
}
