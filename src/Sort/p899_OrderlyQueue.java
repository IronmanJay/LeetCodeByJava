package Sort;

import java.util.Arrays;

/**
 * @Author: IronmanJay
 * @Description: 899.有序队列
 * @CreateTime: 2022-11-19  09:25
 */
public class p899_OrderlyQueue {

    public static void main(String[] args) {
        String s = "cba";
        int k = 1;
        String res = orderlyQueue(s, k);
        System.out.println("res = " + res);
    }

    public static String orderlyQueue(String s, int k) {
        if (k == 1) {
            String str = s;
            StringBuilder sb = new StringBuilder(s);
            int len = s.length();
            for (int i = 1; i < len; i++) {
                char c = sb.charAt(0);
                sb.deleteCharAt(0);
                sb.append(c);
                if (sb.toString().compareTo(str) < 0) {
                    str = sb.toString();
                }
            }
            return str;
        } else {
            char[] arr = s.toCharArray();
            Arrays.sort(arr);
            return new String(arr);
        }
    }

}
