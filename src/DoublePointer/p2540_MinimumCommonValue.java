package DoublePointer;

/**
 * @Author: IronmanJay
 * @Description: 2540.最小公共值
 * @CreateTime: 2023-03-18  10:48
 */
public class p2540_MinimumCommonValue {

    public static void main(String[] args) {
        int[] nums1 = {1, 2, 3};
        int[] nums2 = {2, 4};
        int res = getCommon(nums1, nums2);
        System.out.println("res = " + res);
    }

    public static int getCommon(int[] nums1, int[] nums2) {
        int index1 = 0;
        int index2 = 0;
        int len1 = nums1.length;
        int len2 = nums2.length;
        while (index1 < len1 && index2 < len2) {
            if (nums1[index1] == nums2[index2]) {
                return nums1[index1];
            } else if (nums1[index1] < nums2[index2]) {
                index1++;
            } else if (nums1[index1] > nums2[index2]) {
                index2++;
            }
        }
        return -1;
    }

}
