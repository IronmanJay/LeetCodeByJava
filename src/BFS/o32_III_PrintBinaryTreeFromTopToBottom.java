package BFS;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class o32_III_PrintBinaryTreeFromTopToBottom {

    int val;
    o32_III_PrintBinaryTreeFromTopToBottom left;
    o32_III_PrintBinaryTreeFromTopToBottom right;

    o32_III_PrintBinaryTreeFromTopToBottom(int x) {
        val = x;
    }

    public static void main(String[] args) {
        o32_III_PrintBinaryTreeFromTopToBottom root = new o32_III_PrintBinaryTreeFromTopToBottom(3);
        o32_III_PrintBinaryTreeFromTopToBottom left = new o32_III_PrintBinaryTreeFromTopToBottom(9);
        o32_III_PrintBinaryTreeFromTopToBottom right = new o32_III_PrintBinaryTreeFromTopToBottom(20);
        o32_III_PrintBinaryTreeFromTopToBottom right1 = new o32_III_PrintBinaryTreeFromTopToBottom(15);
        o32_III_PrintBinaryTreeFromTopToBottom right2 = new o32_III_PrintBinaryTreeFromTopToBottom(7);
        root.left = left;
        root.right = right;
        right.left = right1;
        right.right = right2;
        List<List<Integer>> res = levelOrder(root);
        System.out.println("res = " + res);
    }

    public static List<List<Integer>> levelOrder(o32_III_PrintBinaryTreeFromTopToBottom root) {
        // 结果数组
        List<List<Integer>> res = new ArrayList<>();
        // 判空返回
        if (root == null) {
            return res;
        }
        // 存放每一层的队列
        Queue<o32_III_PrintBinaryTreeFromTopToBottom> queue = new LinkedList<>();
        // 先将根节点入队列
        queue.add(root);
        // 记录是第几层
        int level = 1;
        // 开始循环
        while (!queue.isEmpty()) {
            // 临时数组，存放每一层的结果
            LinkedList<Integer> temp = new LinkedList<>();
            // 遍历每一层的节点个数
            int size = queue.size();
            // 当前这一层有几个节点就循环几次，循环到每一个节点的同时将将节点值加入到临时数组中，另外将每一个节点的孩子节点入队列，因为只遍历队列中当前层的节点，所以对孩子（下一层）的节点不构成影响
            for (int i = 0; i < size; i++) {
                o32_III_PrintBinaryTreeFromTopToBottom node = queue.poll();
                // 奇数层正常添加节点值
                if (level % 2 != 0) {
                    temp.add(node.val);
                }
                // 偶数层倒序添加节点值
                else {
                    temp.addFirst(node.val);
                }
                if (node.left != null) {
                    queue.add(node.left);
                }
                if (node.right != null) {
                    queue.add(node.right);
                }
            }
            // 将这一层的节点值加入到结果数组
            res.add(temp);
            // 层数+1
            level++;
        }
        // 返回结果
        return res;
    }

}
