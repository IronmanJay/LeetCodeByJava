package BitOperation;

/**
 * @Author: IronmanJay
 * @Description: 405.数字转换为十六进制数
 * @CreateTime: 2023-03-24  08:45
 */
public class p405_ConvertANumberToHexadecimal {

    public static void main(String[] args) {
        int num = 26;
        String res = toHex(26);
        System.out.println("res = " + res);
    }

    public static String toHex(int num) {
        if (num == 0) {
            return "0";
        }
        StringBuffer sb = new StringBuffer();
        char[] map = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};
        while (num != 0 && sb.length() < 8) {
            int index = num & 0xf;
            sb.insert(0, map[index]);
            num >>= 4;
        }
        return sb.toString();
    }

}
