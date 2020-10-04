package BFS;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class p107_BinaryTreeLevelOrderTraversalII {

    int val;
    p107_BinaryTreeLevelOrderTraversalII left;
    p107_BinaryTreeLevelOrderTraversalII right;

    p107_BinaryTreeLevelOrderTraversalII(int x) {
        val = x;
    }

    public static void main(String[] args) {
        p107_BinaryTreeLevelOrderTraversalII root = new p107_BinaryTreeLevelOrderTraversalII(3);
        p107_BinaryTreeLevelOrderTraversalII left = new p107_BinaryTreeLevelOrderTraversalII(9);
        p107_BinaryTreeLevelOrderTraversalII right = new p107_BinaryTreeLevelOrderTraversalII(20);
        p107_BinaryTreeLevelOrderTraversalII right1 = new p107_BinaryTreeLevelOrderTraversalII(15);
        p107_BinaryTreeLevelOrderTraversalII right2 = new p107_BinaryTreeLevelOrderTraversalII(7);
        root.left = left;
        root.right = right;
        right.left = right1;
        right.right = right2;
        List<List<Integer>> res = levelOrderBottom(root);
        System.out.println("res = " + res);
    }

    public static List<List<Integer>> levelOrderBottom(p107_BinaryTreeLevelOrderTraversalII root) {
        // 结果数组
        LinkedList<List<Integer>> res = new LinkedList<>();
        // 判空返回
        if (root == null) {
            return res;
        }
        // 存放每一层的队列
        Queue<p107_BinaryTreeLevelOrderTraversalII> queue = new LinkedList<>();
        // 先将根节点入队列
        queue.add(root);
        // 开始循环
        while (!queue.isEmpty()) {
            // 临时数组，存放每一层的结果
            List<Integer> temp = new ArrayList<>();
            // 遍历每一层的节点个数
            int count = queue.size();
            for (int i = 0; i < count; i++) {
                // 将这一层的每一个节点都放到临时数组中
                p107_BinaryTreeLevelOrderTraversalII node = queue.poll();
                temp.add(node.val);
                // 再将下一层放入队列中
                if (node.left != null) {
                    queue.add(node.left);
                }
                if (node.right != null) {
                    queue.add(node.right);
                }
            }
            // 倒序插入数组头即可
            res.addFirst(temp);
        }
        // 返回结果
        return res;
    }

}
