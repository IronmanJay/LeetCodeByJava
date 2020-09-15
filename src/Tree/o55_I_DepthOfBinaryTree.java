package Tree;

import java.util.LinkedList;
import java.util.List;

public class o55_I_DepthOfBinaryTree {

    int val;
    o55_I_DepthOfBinaryTree left;
    o55_I_DepthOfBinaryTree right;

    o55_I_DepthOfBinaryTree(int val) {
        this.val = val;
    }

    public static void main(String[] args) {
        o55_I_DepthOfBinaryTree root = new o55_I_DepthOfBinaryTree(3);
        o55_I_DepthOfBinaryTree left = new o55_I_DepthOfBinaryTree(9);
        o55_I_DepthOfBinaryTree right = new o55_I_DepthOfBinaryTree(20);
        o55_I_DepthOfBinaryTree right1 = new o55_I_DepthOfBinaryTree(15);
        o55_I_DepthOfBinaryTree right2 = new o55_I_DepthOfBinaryTree(7);
        root.left = left;
        root.right = right;
        right.left = right1;
        right.right = right2;
        int res = maxDepth(root);
        System.out.println("res = " + res);
    }

    public static int maxDepth(o55_I_DepthOfBinaryTree root) {
        // 判空返回
        if (root == null) {
            return 0;
        }
        // 定义结果值
        int res = 0;
        // queue队列存储每一层的结点
        List<o55_I_DepthOfBinaryTree> queue = new LinkedList<>();
        // 先将第一层，也就是根节点入队列
        queue.add(root);
        // temp队列临时存储每一层的结点
        List<o55_I_DepthOfBinaryTree> temp;
        // 开始遍历
        while (!queue.isEmpty()) {
            // 初始化temp队列
            temp = new LinkedList<>();
            // 遍历当前这一层
            for (o55_I_DepthOfBinaryTree node : queue) {
                // 如果当前结点的左子结点不空，入临时队列
                if (node.left != null) {
                    temp.add(node.left);
                }
                // 如果当前结点的右子结点不空，入临时队列
                if (node.right != null) {
                    temp.add(node.right);
                }
            }
            // 这层遍历完，开始准备遍历下一层
            queue = temp;
            // 层数+1
            res++;
        }
        // 返回结果
        return res;
    }
}
