package DoublePointer;

public class p345_ReverseVowelsOfAString {

    public static void main(String[] args) {
        String s = "hello";
        String res = reverseVowels(s);
        System.out.println("res = " + res);
    }

    public static String reverseVowels(String s) {
        int left = 0;
        int right = s.length() - 1;
        char[] arr = s.toCharArray();
        while (left < right) {
            while (left < right && !isVowels(arr[left])) {
                left++;
            }
            while (left < right && !isVowels(arr[right])) {
                right--;
            }
            if (left < right) {
                char temp = arr[left];
                arr[left] = arr[right];
                arr[right] = temp;
                left++;
                right--;
            }
        }
        return new String(arr);
    }

    public static boolean isVowels(char s) {
        if (s == 'a' || s == 'A' || s == 'e' || s == 'E' || s == 'i' || s == 'I' || s == 'o' || s == 'O' || s == 'u' || s == 'U') {
            return true;
        }
        return false;
    }

}
