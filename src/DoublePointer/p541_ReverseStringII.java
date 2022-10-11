package DoublePointer;

public class p541_ReverseStringII {

    public static void main(String[] args) {
        String s = "abcdefg";
        int k = 2;
        String res = reverseStr(s, k);
        System.out.println("res = " + res);
    }

    public static String reverseStr(String s, int k) {
        int len = s.length();
        char[] arr = s.toCharArray();
        for (int i = 0; i < len; i += (2 * k)) {
            reverse(arr, i, Math.min(i + k, len) - 1);
        }
        return new String(arr);
    }

    public static void reverse(char[] s, int left, int right) {
        while (left < right) {
            char temp = s[left];
            s[left] = s[right];
            s[right] = temp;
            left++;
            right--;
        }
    }

}
