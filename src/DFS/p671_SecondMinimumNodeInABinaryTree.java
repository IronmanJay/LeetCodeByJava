package DFS;

/**
 * @Author: IronmanJay
 * @Description: 671.二叉树中第二小的节点
 * @CreateTime: 2023-03-11  09:23
 */
public class p671_SecondMinimumNodeInABinaryTree {

    int val;
    p671_SecondMinimumNodeInABinaryTree left;
    p671_SecondMinimumNodeInABinaryTree right;

    public p671_SecondMinimumNodeInABinaryTree() {
    }

    public p671_SecondMinimumNodeInABinaryTree(int val) {
        this.val = val;
    }

    public p671_SecondMinimumNodeInABinaryTree(int val, p671_SecondMinimumNodeInABinaryTree left, p671_SecondMinimumNodeInABinaryTree right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }

    public static void main(String[] args) {
        p671_SecondMinimumNodeInABinaryTree root = new p671_SecondMinimumNodeInABinaryTree(2);
        p671_SecondMinimumNodeInABinaryTree left = new p671_SecondMinimumNodeInABinaryTree(2);
        p671_SecondMinimumNodeInABinaryTree right = new p671_SecondMinimumNodeInABinaryTree(2);
        root.left = left;
        root.right = right;
        int res = findSecondMinimumValue(root);
        System.out.println("res = " + res);
    }

    public static int dfs(p671_SecondMinimumNodeInABinaryTree root, int minVal) {
        if (root == null) {
            return -1;
        }
        if (root.val > minVal) {
            return root.val;
        }
        int left = dfs(root.left, minVal);
        int right = dfs(root.right, minVal);
        if (left >= 0 && right >= 0) {
            return Math.min(left, right);
        }
        return Math.max(left, right);
    }

    public static int findSecondMinimumValue(p671_SecondMinimumNodeInABinaryTree root) {
        return dfs(root, root.val);
    }

}
