package Tree;

public class p230_TheKthSmallestElementInABinarySearchTree {

    int val;
    p230_TheKthSmallestElementInABinarySearchTree left;
    p230_TheKthSmallestElementInABinarySearchTree right;

    public p230_TheKthSmallestElementInABinarySearchTree() {
    }

    public p230_TheKthSmallestElementInABinarySearchTree(int val) {
        this.val = val;
    }

    public p230_TheKthSmallestElementInABinarySearchTree(int val, p230_TheKthSmallestElementInABinarySearchTree left, p230_TheKthSmallestElementInABinarySearchTree right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }

    public static void main(String[] args) {
        p230_TheKthSmallestElementInABinarySearchTree root = new p230_TheKthSmallestElementInABinarySearchTree(3);
        p230_TheKthSmallestElementInABinarySearchTree left = new p230_TheKthSmallestElementInABinarySearchTree(1);
        p230_TheKthSmallestElementInABinarySearchTree left1 = new p230_TheKthSmallestElementInABinarySearchTree(2);
        p230_TheKthSmallestElementInABinarySearchTree right = new p230_TheKthSmallestElementInABinarySearchTree(4);
        root.left = left;
        left.right = left1;
        root.right = right;
        int res = kthSmallest(root, 1);
        System.out.println("res = " + res);
    }

    private static int size;

    public static int kthSmallest(p230_TheKthSmallestElementInABinarySearchTree root, int k) {
        size = 0;
        int[] nums = new int[10001];
        inOrder(root, nums);
        return nums[k - 1];
    }

    public static void inOrder(p230_TheKthSmallestElementInABinarySearchTree root, int[] nums) {
        if (root != null) {
            inOrder(root.left, nums);
            nums[size++] = root.val;
            inOrder(root.right, nums);
        }
    }

}
