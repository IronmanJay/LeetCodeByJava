package Tree;

/**
 * @Author: IronmanJay
 * @Description: 543.二叉树的直径
 * @CreateTime: 2022-12-12  10:17
 */
public class p543_DiameterOfBinaryTree {

    int val;
    p543_DiameterOfBinaryTree left;
    p543_DiameterOfBinaryTree right;

    public p543_DiameterOfBinaryTree(int val) {
        this.val = val;
    }

    public p543_DiameterOfBinaryTree(int val, p543_DiameterOfBinaryTree left, p543_DiameterOfBinaryTree right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }

    public static void main(String[] args) {
        p543_DiameterOfBinaryTree root = new p543_DiameterOfBinaryTree(1);
        p543_DiameterOfBinaryTree left = new p543_DiameterOfBinaryTree(2);
        p543_DiameterOfBinaryTree right = new p543_DiameterOfBinaryTree(3);
        p543_DiameterOfBinaryTree left1 = new p543_DiameterOfBinaryTree(4);
        p543_DiameterOfBinaryTree left2 = new p543_DiameterOfBinaryTree(5);
        root.left = left;
        root.right = right;
        left.left = left1;
        left.right = left2;
        int res = diameterOfBinaryTree(root);
        System.out.println("res = " + res);
    }

    private static int res = 0;

    public static int diameterOfBinaryTree(p543_DiameterOfBinaryTree root) {
        dfsDiameter(root);
        return res;
    }

    public static int dfsDiameter(p543_DiameterOfBinaryTree root) {
        if (root == null) {
            return 0;
        }
        int left = dfsDiameter(root.left);
        int right = dfsDiameter(root.right);
        res = Math.max(res, left + right);
        return Math.max(left, right) + 1;
    }

}
