package BinarySearch;

/**
 * @Author: IronmanJay
 * @Description: 275.H 指数 II
 * @CreateTime: 2022-12-29  12:58
 */
public class p275_HIndexII {

    public static void main(String[] args) {
        int[] citations = {0, 1, 3, 5, 6};
        int res = hIndex(citations);
        System.out.println("res = " + res);
    }

    public static int hIndex(int[] citations) {
        int len = citations.length;
        int left = 0;
        int right = len - 1;
        while (left < right) {
            int mid = (left + right) / 2;
            if (citations[mid] >= len - mid) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return citations[right] >= len - right ? len - right : 0;
    }

}
