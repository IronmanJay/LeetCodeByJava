package String;

public class p647_PalindromicSubstrings {

    public static void main(String[] args) {
        String s = "aba";
        int res = countSubstrings(s);
        System.out.println("res = " + res);
    }

    // 存储结果
    private static int res = 0;

    public static int countSubstrings(String s) {
        for (int i = 0; i < s.length(); i++) {
            // 当选取的中心点为奇数个，也就是一个字符
            count(s, i, i);
            // 当选取的中心点为偶数个，也就是两个字符
            count(s, i, i + 1);
        }
        // 返回结果
        return res;
    }

    /**
     * 根据奇数或者偶数计算回文子串的个数
     *
     * @param s     待计算的字符串
     * @param left  左指针
     * @param right 右指针
     */
    public static void count(String s, int left, int right) {
        // 当left和right不越界的时候，从中心点向两边拓展，遇到相等的说明有回文子串
        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            res++;
            left--;
            right++;
        }
    }

}
