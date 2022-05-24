package Array;

public class p66_PlusOne {

    public static void main(String[] args) {
        int[] digits = {1, 2, 3};
        int[] res = plusOne(digits);
        for (int i = 0; i < res.length; i++) {
            System.out.print(res[i]);
        }
    }

    public static int[] plusOne(int[] digits) {
        int len = digits.length;
        for (int i = len - 1; i >= 0; i--) {
            if (digits[i] == 9) {
                digits[i] = 0;
            } else {
                digits[i]++;
                return digits;
            }
        }
        int[] res = new int[len + 1];
        res[0] = 1;
        return res;
    }

}
