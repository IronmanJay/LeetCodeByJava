package Tree;

public class p110_BalancedBinaryTree {

    int val;
    p110_BalancedBinaryTree left;
    p110_BalancedBinaryTree right;

    p110_BalancedBinaryTree(int x) {
        val = x;
    }

    public static void main(String[] args) {
        p110_BalancedBinaryTree root = new p110_BalancedBinaryTree(1);
        p110_BalancedBinaryTree left = new p110_BalancedBinaryTree(2);
        p110_BalancedBinaryTree right = new p110_BalancedBinaryTree(2);
        p110_BalancedBinaryTree left1 = new p110_BalancedBinaryTree(3);
        p110_BalancedBinaryTree left2 = new p110_BalancedBinaryTree(3);
        p110_BalancedBinaryTree left3 = new p110_BalancedBinaryTree(4);
        p110_BalancedBinaryTree left4 = new p110_BalancedBinaryTree(4);
        root.left = left;
        root.right = right;
        left.left = left1;
        left.right = left2;
        left1.left = left3;
        left1.right = left4;
        boolean balanced = isBalanced(root);
        System.out.println("balanced = " + balanced);
    }

    public static boolean isBalanced(p110_BalancedBinaryTree root) {
        // 返回结果
        return recur(root) != -1;
    }

    public static int recur(p110_BalancedBinaryTree root) {
        // 遍历到叶子节点直接返回
        if (root == null) {
            return 0;
        }
        // 向左子树递归，返回左子树高度
        int left = recur(root.left);
        // 如果左子树本身不平衡就直接返回-1
        if (left == -1) {
            return -1;
        }
        // 向右子树递归，返回右子树高度
        int right = recur(root.right);
        // 如果右子树本身不平衡就直接返回-1
        if (right == -1) {
            return -1;
        }
        // 如果当前递归子树左右子树高度差不超过1，说明当前递归子树是平衡二叉树，只需要在当前把递归的子树+1，说明整棵树高度+1
        // 如果当前递归子树左右子树高度差超过1，说明当前递归子树不是平衡二叉树，直接返回-1
        return Math.abs(left - right) < 2 ? Math.max(left, right) + 1 : -1;
    }

}
