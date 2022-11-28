package String;

/**
 * @Author: IronmanJay
 * @Description: 557.反转字符串中的单词 III
 * @CreateTime: 2022-11-28  09:18
 */
public class p557_ReverseWordsInAStringIII {

    public static void main(String[] args) {
        String s = "Let's take LeetCode contest";
        String res = reverseWords(s);
        System.out.println("res = " + res);
    }

    public static String reverseWords(String s) {
        StringBuffer sb = new StringBuffer();
        int index = 0;
        int len = s.length();
        while (index < len) {
            int left = index;
            while (index < len && s.charAt(index) != ' ') {
                index++;
            }
            int right = index - 1;
            while (left <= right) {
                sb.append(s.charAt(right));
                right--;
            }
            while (index < len && s.charAt(index) == ' ') {
                sb.append(' ');
                index++;
            }
        }
        return sb.toString();
    }

}
