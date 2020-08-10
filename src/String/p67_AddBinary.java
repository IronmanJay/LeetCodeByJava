package String;

public class p67_AddBinary {

    public static void main(String[] args) {
        String a = "1010";
        String b = "1011";
        String res = addBinary(a, b);
        System.out.println("res = " + res);
    }

    public static String addBinary(String a, String b) {
        // 获取字符串长度
        int lenA = a.length();
        int lenB = b.length();
        // 表示进位
        int carry = 0;
        int i, j;
        // 新建结果StringBuilder
        StringBuilder res = new StringBuilder();
        // 从后往前遍历
        for (i = lenA - 1, j = lenB - 1; i >= 0 || j >= 0; i--, j--) {
            // 有可能由于两数组长度不一样，就会有i，j小于0的情况，这时我们补零对齐即可
            int x = i < 0 ? 0 : a.charAt(i) - '0';
            int y = j < 0 ? 0 : b.charAt(j) - '0';
            // 对应位相加，另外根据carry判断是否进位，如果发生进位结果就是0，如果没发生进位结果就是1
            int num = (x + y + carry) % 2;
            // carry只能得0或者1，如果发生进位就是1，如果没发生进位就是0
            carry = (x + y + carry) / 2;
            // 将结果存入StringBuilder
            res.append(num);
        }
        // 判断最后一次是否发生进位，如果发生进位就是1，没发生进位什么也不添加
        res.append(carry == 1 ? 1 : "");
        // 因为是从后向前遍历相加，所以需要翻转字符串数组才是结果
        return res.reverse().toString();
    }

}
