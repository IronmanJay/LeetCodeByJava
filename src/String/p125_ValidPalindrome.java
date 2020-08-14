package String;

public class p125_ValidPalindrome {

    public static void main(String[] args) {
        String s = "A man, a plan, a canal: Panama";
        boolean res = isPalindrome(s);
        System.out.println("res = " + res);
    }

    public static boolean isPalindrome(String s) {
        // 判空返回
        if (s.length() == 0 || s == null) {
            return true;
        }
        // 将字符串转为小写
        String str = s.toLowerCase();
        // 定义左右指针
        int left = 0;
        int right = str.length() - 1;
        // 开始遍历
        while (left <= right) {
            // 如果在范围内且不是数字或者字母，跳过这个元素，左指针+1
            while (left <= right && !Character.isLetterOrDigit(str.charAt(left))) {
                left++;
            }
            // 如果在范围内且不是数字或者字母，跳过这个元素，右指针-1
            while (left <= right && !Character.isLetterOrDigit(str.charAt(right))) {
                right--;
            }
            // 如果在范围内且两字母不相等，返回false
            if (left <= right && str.charAt(left) != str.charAt(right)) {
                return false;
            }
            // 如果相等，左指针+1，右指针-1，继续遍历
            left++;
            right--;
        }
        // 说明是回文串，返回true
        return true;
    }

}
