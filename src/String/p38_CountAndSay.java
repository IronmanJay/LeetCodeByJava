package String;

/**
 * @Author: IronmanJay
 * @Description: 38.外观数列
 * @CreateTime: 2022-12-02  09:53
 */
public class p38_CountAndSay {

    public static void main(String[] args) {
        int n = 4;
        String res = countAndSay(n);
        System.out.println("res = " + res);
    }

    public static String countAndSay(int n) {
        String str = "1";
        for (int i = 2; i <= n; i++) {
            StringBuffer sb = new StringBuffer();
            int start = 0;
            int pos = 0;
            while (pos < str.length()) {
                while (pos < str.length() && str.charAt(start) == str.charAt(pos)) {
                    pos++;
                }
                sb.append(Integer.toString(pos - start));
                sb.append(str.charAt(start));
                start = pos;
            }
            str = sb.toString();
        }
        return str;
    }

}
