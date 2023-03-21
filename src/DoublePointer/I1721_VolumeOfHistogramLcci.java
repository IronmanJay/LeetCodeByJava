package DoublePointer;

/**
 * @Author: IronmanJay
 * @Description: 面试题17.21.直方图的水量
 * @CreateTime: 2023-03-21  10:29
 */
public class I1721_VolumeOfHistogramLcci {

    public static void main(String[] args) {
        int[] height = {0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1};
        int res = trap(height);
        System.out.println("res = " + res);
    }

    public static int trap(int[] height) {
        int res = 0;
        int left = 0;
        int right = height.length - 1;
        int leftMax = 0;
        int rightMax = 0;
        while (left <= right) {
            if (leftMax < rightMax) {
                res += Math.max(0, leftMax - height[left]);
                leftMax = Math.max(leftMax, height[left]);
                left++;
            } else {
                res += Math.max(0, rightMax - height[right]);
                rightMax = Math.max(rightMax, height[right]);
                right--;
            }
        }
        return res;
    }

}
