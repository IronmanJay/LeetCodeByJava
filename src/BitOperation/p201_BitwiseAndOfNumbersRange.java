package BitOperation;

/**
 * @Author: IronmanJay
 * @Description: 201.数字范围按位与
 * @CreateTime: 2023-03-25  08:50
 */
public class p201_BitwiseAndOfNumbersRange {

    public static void main(String[] args) {
        int left = 5;
        int right = 7;
        int res = rangeBitwiseAnd(left, right);
        System.out.println("res = " + res);
    }

    public static int rangeBitwiseAnd(int left, int right) {
        int count = 0;
        while (left != right) {
            left >>= 1;
            right >>= 1;
            count++;
        }
        return left << count;
    }

}
