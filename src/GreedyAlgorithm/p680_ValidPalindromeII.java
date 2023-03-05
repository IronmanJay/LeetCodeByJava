package GreedyAlgorithm;

/**
 * @Author: IronmanJay
 * @Description: TODO
 * @CreateTime: 2023-03-05  11:20
 */
public class p680_ValidPalindromeII {

    public static void main(String[] args) {
        String s = "abca";
        boolean res = validPalindrome(s);
        System.out.println("res = " + res);
    }

    public static boolean validPalindrome(String s) {
        int left = 0;
        int right = s.length() - 1;
        while (left < right) {
            if (s.charAt(left) != s.charAt(right)) {
                return isPalindrome(s, left + 1, right) || isPalindrome(s, left, right - 1);
            }
            left++;
            right--;
        }
        return true;
    }

    public static boolean isPalindrome(String s, int i, int j) {
        while (i < j) {
            if (s.charAt(i) != s.charAt(j)) {
                return false;
            }
            i++;
            j--;
        }
        return true;
    }

}
