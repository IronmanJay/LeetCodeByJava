package SlidingWindow;

/**
 * @Author: IronmanJay
 * @Description: 2269.找到一个数字的 K 美丽值
 * @CreateTime: 2023-06-02  17:42
 */
public class p2269_FindTheKBeautyOfANumber {

    public static void main(String[] args) {
        int num = 240;
        int k = 2;
        int res = divisorSubstrings(num, k);
        System.out.println("res = " + res);
    }

    public static int divisorSubstrings(int num, int k) {
        int res = 0;
        int[] temp_num = new int[10];
        int i, count, temp;
        for (i = 0, temp = num; temp > 0; temp /= 10, i++) {
            temp_num[i] = temp % 10;
        }
        count = i - k + 1;
        for (i = 0; i < count; i++) {
            int sum = 0;
            for (int j = 0; j < k; j++) {
                sum *= 10;
                sum += temp_num[i + k - j - 1];
            }
            if (sum != 0 && num % sum == 0) {
                res++;
            }
        }
        return res;
    }

}
