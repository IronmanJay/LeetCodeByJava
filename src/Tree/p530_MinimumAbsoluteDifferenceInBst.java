package Tree;

import java.util.Stack;

/**
 * @Author: IronmanJay
 * @Description: 530.二叉搜索树的最小绝对差
 * @CreateTime: 2022-12-13  10:53
 */
public class p530_MinimumAbsoluteDifferenceInBst {

    int val;
    p530_MinimumAbsoluteDifferenceInBst left;
    p530_MinimumAbsoluteDifferenceInBst right;

    public p530_MinimumAbsoluteDifferenceInBst(int val) {
        this.val = val;
    }

    public p530_MinimumAbsoluteDifferenceInBst(int val, p530_MinimumAbsoluteDifferenceInBst left, p530_MinimumAbsoluteDifferenceInBst right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }

    public static void main(String[] args) {
        p530_MinimumAbsoluteDifferenceInBst root = new p530_MinimumAbsoluteDifferenceInBst(4);
        p530_MinimumAbsoluteDifferenceInBst left = new p530_MinimumAbsoluteDifferenceInBst(2);
        p530_MinimumAbsoluteDifferenceInBst right = new p530_MinimumAbsoluteDifferenceInBst(6);
        p530_MinimumAbsoluteDifferenceInBst left1 = new p530_MinimumAbsoluteDifferenceInBst(1);
        p530_MinimumAbsoluteDifferenceInBst left2 = new p530_MinimumAbsoluteDifferenceInBst(3);
        root.left = left;
        root.right = right;
        left.left = left1;
        left.right = left2;
        int res = getMinimumDifference(root);
        System.out.println("res = " + res);
    }

    public static int getMinimumDifference(p530_MinimumAbsoluteDifferenceInBst root) {
        Stack<p530_MinimumAbsoluteDifferenceInBst> stack = new Stack<>();
        p530_MinimumAbsoluteDifferenceInBst pre = null;
        int min = Integer.MAX_VALUE;
        while (!stack.isEmpty() || root != null) {
            while (root != null) {
                stack.push(root);
                root = root.left;
            }
            root = stack.pop();
            if (pre != null && root.val - pre.val < min) {
                min = root.val - pre.val;
            }
            pre = root;
            root = root.right;
        }
        return min;
    }

}
