package DFS;

public class p108_ConvertSortedArrayToBinarySearchTree {

    int val;
    p108_ConvertSortedArrayToBinarySearchTree left;
    p108_ConvertSortedArrayToBinarySearchTree right;

    p108_ConvertSortedArrayToBinarySearchTree(int x) {
        val = x;
    }

    public static void main(String[] args) {
        int[] nums = {-10, -3, 0, 5, 9};
        p108_ConvertSortedArrayToBinarySearchTree res = sortedArrayToBST(nums);
        System.out.println("res = " + res);
    }

    public static p108_ConvertSortedArrayToBinarySearchTree sortedArrayToBST(int[] nums) {
        // 判空返回
        if (nums.length == 0) {
            return null;
        }
        // 因为二叉搜索树根节点为数组（已排序）中间值，所以分别向左向右递归得到左右子树即可
        return getTree(nums, 0, nums.length - 1);
    }

    public static p108_ConvertSortedArrayToBinarySearchTree getTree(int[] nums, int left, int right) {
        // 递归跳出条件，已经无法建立二叉搜索树的头结点
        if (left > right) {
            return null;
        }
        // 得到中间值
        int mid = left + (right - left) / 2;
        // 新建二叉搜索树的头结点
        p108_ConvertSortedArrayToBinarySearchTree root = new p108_ConvertSortedArrayToBinarySearchTree(nums[mid]);
        // 向左递归遍历
        root.left = getTree(nums, left, mid - 1);
        // 向右递归遍历
        root.right = getTree(nums, mid + 1, right);
        // 返回二叉搜索树的头结点
        return root;
    }

}
