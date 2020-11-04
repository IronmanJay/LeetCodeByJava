package Queue;

import java.util.*;

public class p102_BinaryTreeLevelOrderTraversal {

    int val;
    p102_BinaryTreeLevelOrderTraversal left;
    p102_BinaryTreeLevelOrderTraversal right;

    p102_BinaryTreeLevelOrderTraversal(int x) {
        val = x;
    }

    public static void main(String[] args) {
        p102_BinaryTreeLevelOrderTraversal root = new p102_BinaryTreeLevelOrderTraversal(3);
        p102_BinaryTreeLevelOrderTraversal left = new p102_BinaryTreeLevelOrderTraversal(9);
        p102_BinaryTreeLevelOrderTraversal right = new p102_BinaryTreeLevelOrderTraversal(20);
        p102_BinaryTreeLevelOrderTraversal right1 = new p102_BinaryTreeLevelOrderTraversal(15);
        p102_BinaryTreeLevelOrderTraversal right2 = new p102_BinaryTreeLevelOrderTraversal(7);
        root.left = left;
        root.right = right;
        right.left = right1;
        right.right = right2;
        List<List<Integer>> res = levelOrder(root);
        System.out.println("res = " + res);
    }

    public static List<List<Integer>> levelOrder(p102_BinaryTreeLevelOrderTraversal root) {
        // 结果数组
        List<List<Integer>> res = new ArrayList<>();
        // 判空返回
        if (root == null) {
            return res;
        }
        // 存放每一层结点的队列
        Queue<p102_BinaryTreeLevelOrderTraversal> queue = new LinkedList<>();
        // 先将头结点值加入结果数组
        List<Integer> rootList = new ArrayList<>();
        rootList.add(root.val);
        res.add(rootList);
        // 头结点入队列
        queue.offer(root);
        // 开始遍历
        while (!queue.isEmpty()) {
            // 获取当前层结点个数
            int size = queue.size();
            // 存放当前层结点值
            List<Integer> tempList = new ArrayList<>();
            // 开始遍历当前层
            while (size > 0) {
                p102_BinaryTreeLevelOrderTraversal tempNode = queue.poll();
                if (tempNode.left != null) {
                    queue.offer(tempNode.left);
                    tempList.add(tempNode.left.val);
                }
                if (tempNode.right != null) {
                    queue.offer(tempNode.right);
                    tempList.add(tempNode.right.val);
                }
                size--;
            }
            // 将当前层结点值加入到结果数组，注意空数组不要加
            if (tempList.size() != 0) {
                res.add(tempList);
            }
        }
        // 返回结果
        return res;
    }

}
