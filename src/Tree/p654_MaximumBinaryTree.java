package Tree;

public class p654_MaximumBinaryTree {

    int val;
    p654_MaximumBinaryTree left;
    p654_MaximumBinaryTree right;

    public p654_MaximumBinaryTree(int val) {
        this.val = val;
    }

    public p654_MaximumBinaryTree(int val, p654_MaximumBinaryTree left, p654_MaximumBinaryTree right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }

    public p654_MaximumBinaryTree() {
    }


    public static void main(String[] args) {
        int[] nums = {3, 2, 1, 6, 0, 5};
        p654_MaximumBinaryTree res = constructMaximumBinaryTree(nums);
        preOrder(res);
    }

    public static void preOrder(p654_MaximumBinaryTree root) {
        if (root != null) {
            System.out.print(root.val + " ");
            preOrder(root.left);
            preOrder(root.right);
        }
    }

    public static p654_MaximumBinaryTree constructMaximumBinaryTree(int[] nums) {
        return getMaxTree(nums, 0, nums.length - 1);
    }

    public static p654_MaximumBinaryTree getMaxTree(int[] nums, int left, int right) {
        if (left > right) {
            return null;
        }
        int maxIndex = getMaxIndex(nums, left, right);
        p654_MaximumBinaryTree root = new p654_MaximumBinaryTree(nums[maxIndex]);
        root.left = getMaxTree(nums, left, maxIndex - 1);
        root.right = getMaxTree(nums, maxIndex + 1, right);
        return root;
    }

    public static int getMaxIndex(int[] nums, int left, int right) {
        int max = -1;
        int maxIndex = left;
        for (int i = left; i <= right; i++) {
            if (max < nums[i]) {
                max = nums[i];
                maxIndex = i;
            }
        }
        return maxIndex;
    }

}
