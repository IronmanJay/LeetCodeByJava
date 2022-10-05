package String;

public class p409_LongestPalindrome {

    public static void main(String[] args) {
        String s = "abccccdd";
        int res = longestPalindrome(s);
        System.out.println("res = " + res);
    }

    public static int longestPalindrome(String s) {
        int[] map = new int[128];
        for (char ch : s.toCharArray()) {
            map[ch]++;
        }
        int res = 0;
        boolean flag = false;
        for (int i = 0; i < 128; i++) {
            if (map[i] != 0) {
                if (map[i] % 2 == 0) {
                    res += map[i];
                } else {
                    res = res + map[i] - 1;
                    flag = true;
                }
            }

        }
        return flag == false ? res : res + 1;
    }

}
