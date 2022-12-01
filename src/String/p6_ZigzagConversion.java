package String;

/**
 * @Author: IronmanJay
 * @Description: 6.Z 字形变换
 * @CreateTime: 2022-12-01  09:04
 */
public class p6_ZigzagConversion {

    public static void main(String[] args) {
        String s = "PAYPALISHIRING";
        int numRows = 3;
        String res = convert(s, numRows);
        System.out.println("res = " + res);
    }

    public static String convert(String s, int numRows) {
        StringBuffer sb = new StringBuffer();
        int len = s.length();
        if (len == 0 || numRows == 1) {
            return s;
        }
        int t = 2 * numRows - 2;
        for (int i = 0; i < numRows; i++) {
            for (int j = 0; j < len; j++) {
                if (j % t == i || j % t == t - i) {
                    sb.append(s.charAt(j));
                }
            }
        }
        return sb.toString();
    }

}
