package BinarySearch;

/**
 * @Author: IronmanJay
 * @Description: 1539.第 k 个缺失的正整数
 * @CreateTime: 2022-12-28  09:39
 */
public class p1539_KthMissingPositiveNumber {

    public static void main(String[] args) {
        int[] arr = {2, 3, 4, 7, 11};
        int k = 5;
        int res = findKthPositive(arr, k);
        System.out.println("res = " + res);
    }

    public static int findKthPositive(int[] arr, int k) {
        if (arr[0] > k) {
            return k;
        }
        int left = 0;
        int right = arr.length;
        while (left < right) {
            int mid = (left + right) / 2;
            int dif = arr[mid] - mid - 1;
            if (dif >= k) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return k - (arr[left - 1] - (left - 1) - 1) + arr[left - 1];
    }

}
