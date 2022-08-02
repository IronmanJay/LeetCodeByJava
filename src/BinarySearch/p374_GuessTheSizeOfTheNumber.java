package BinarySearch;

public class p374_GuessTheSizeOfTheNumber {

    public static void main(String[] args) {
        int res = guessNumber(10);
        System.out.println("res = " + res);
    }

    public static int guessNumber(int n) {
        int left = 1;
        int right = n;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            int pick = guess(mid);
            if (pick == 0) {
                return mid;
            } else if (pick == -1) {
                right = mid - 1;
            } else if (pick == 1) {
                left = mid + 1;
            }
        }
        return 0;
    }

    public static int guess(int num) {
        int pick = 6;
        if (num == pick) {
            return 0;
        } else if (num < pick) {
            return 1;
        } else {
            return -1;
        }
    }

}
