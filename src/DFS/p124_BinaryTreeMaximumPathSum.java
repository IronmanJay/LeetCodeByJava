package DFS;

public class p124_BinaryTreeMaximumPathSum {

    int val;
    p124_BinaryTreeMaximumPathSum left;
    p124_BinaryTreeMaximumPathSum right;

    public p124_BinaryTreeMaximumPathSum(int val) {
        this.val = val;
    }

    public p124_BinaryTreeMaximumPathSum(int val, p124_BinaryTreeMaximumPathSum left, p124_BinaryTreeMaximumPathSum right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }

    public static void main(String[] args) {
        p124_BinaryTreeMaximumPathSum root = new p124_BinaryTreeMaximumPathSum(1);
        p124_BinaryTreeMaximumPathSum left = new p124_BinaryTreeMaximumPathSum(2);
        p124_BinaryTreeMaximumPathSum right = new p124_BinaryTreeMaximumPathSum(3);
        root.left = left;
        root.right = right;
        int res = maxPathSum(root);
        System.out.println("res = " + res);
    }

    private static int res;

    public static int maxPathSum(p124_BinaryTreeMaximumPathSum root) {
        res = Integer.MIN_VALUE;
        getRes(root);
        return res;
    }

    private static int getRes(p124_BinaryTreeMaximumPathSum root) {
        if (root == null) {
            return 0;
        }
        int left = Math.max(0, getRes(root.left));
        int right = Math.max(0, getRes(root.right));
        res = Math.max(res, left + right + root.val);
        return Math.max(left, right) + root.val;
    }

}
