package BitOperation;

/**
 * @Author: IronmanJay
 * @Description: 371.两整数之和
 * @CreateTime: 2023-03-26  09:00
 */
public class p371_SumOfTwoIntegers {

    public static void main(String[] args) {
        int a = 1;
        int b = 2;
        int res = getSum(a, b);
        System.out.println("res = " + res);
    }

    public static int getSum(int a, int b) {
        int xor = a ^ b;
        int carry = (a & b) << 1;
        while (carry != 0) {
            int temp = xor ^ carry;
            carry = (xor & carry) << 1;
            xor = temp;
        }
        return xor;
    }

}
