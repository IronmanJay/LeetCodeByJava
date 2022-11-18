package Sort;

/**
 * @Author: IronmanJay
 * @Description: 324.摆动排序 II
 * @CreateTime: 2022-11-18  09:02
 */
public class p324_WiggleSortII {

    public static void main(String[] args) {

    }

    public void wiggleSort(int[] nums) {
        int[] bucket = new int[5001];
        for (int num : nums) {
            bucket[num]++;
        }
        for (int i = 1, j = 5000; i < nums.length; i += 2) {
            while (bucket[j] == 0) {
                j--;
            }
            nums[i] = j;
            bucket[j]--;
        }
        for (int i = 0, j = 5000; i < nums.length; i += 2) {
            while (bucket[j] == 0) {
                j--;
            }
            nums[i] = j;
            bucket[j]--;
        }
    }

}
