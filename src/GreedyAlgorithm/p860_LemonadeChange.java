package GreedyAlgorithm;

public class p860_LemonadeChange {

    public static void main(String[] args) {
        int[] bills = {5, 5, 5, 10, 20};
        boolean res = lemonadeChange(bills);
        System.out.println("res = " + res);
    }

    public static boolean lemonadeChange(int[] bills) {
        int five = 0;
        int ten = 0;
        for (int i = 0; i < bills.length; i++) {
            if (bills[i] == 5) {
                five++;
            } else if (bills[i] == 10) {
                if (five < 1) {
                    return false;
                }
                five--;
                ten++;
            } else if (bills[i] == 20) {
                if (ten >= 1 && five >= 1) {
                    ten--;
                    five--;
                } else if (five >= 3) {
                    five -= 3;
                } else {
                    return false;
                }
            }
        }
        return true;
    }

}
