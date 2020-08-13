package String;

public class p125_ValidPalindrome {

    public static void main(String[] args) {
        String s = "A man, a plan, a canal: Panama";
        boolean res = isPalindrome(s);
        System.out.println("res = " + res);
    }

    public static boolean isPalindrome(String s) {
        if (s.length() == 0 || s == null) {
            return true;
        }
        String str = s.toLowerCase();
        int left = 0;
        int right = str.length() - 1;
        while (left <= right) {
            while (left <= right && !Character.isLetterOrDigit(str.charAt(left))) {
                left++;
            }
            while (left <= right && !Character.isLetterOrDigit(str.charAt(right))) {
                right--;
            }
            if (left <= right && str.charAt(left) != str.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }

}
