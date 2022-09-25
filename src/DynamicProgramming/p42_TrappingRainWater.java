package DynamicProgramming;

public class p42_TrappingRainWater {

    public static void main(String[] args) {
        int[] height = {0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1};
        int res = trap(height);
        System.out.println("res = " + res);
    }

    public static int trap(int[] height) {
        int len = height.length;
        int[] dpLeft = new int[len];
        dpLeft[0] = height[0];
        int[] dpRight = new int[len];
        dpRight[len - 1] = height[len - 1];
        int water = 0;
        for (int i = 1; i < len; i++) {
            dpLeft[i] = Math.max(dpLeft[i - 1], height[i]);
        }
        for (int i = len - 2; i >= 0; i--) {
            dpRight[i] = Math.max(dpRight[i + 1], height[i]);
        }

        for (int i = 1; i <= len - 1; i++) {
            int level = Math.min(dpLeft[i], dpRight[i]);
            water += Math.max(0, level - height[i]);
        }
        return water;
    }

}
