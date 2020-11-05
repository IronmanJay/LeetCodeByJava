package Queue;

import java.util.Deque;
import java.util.LinkedList;

public class p116_PopulatingNextRightPointersInEachNode {

    public int val;
    public p116_PopulatingNextRightPointersInEachNode left;
    public p116_PopulatingNextRightPointersInEachNode right;
    public p116_PopulatingNextRightPointersInEachNode next;

    public p116_PopulatingNextRightPointersInEachNode() {

    }

    public p116_PopulatingNextRightPointersInEachNode(int _val) {
        val = _val;
    }

    public p116_PopulatingNextRightPointersInEachNode(int _val, p116_PopulatingNextRightPointersInEachNode _left, p116_PopulatingNextRightPointersInEachNode _right, p116_PopulatingNextRightPointersInEachNode _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }

    public static void main(String[] args) {
        p116_PopulatingNextRightPointersInEachNode root = new p116_PopulatingNextRightPointersInEachNode(1);
        p116_PopulatingNextRightPointersInEachNode two = new p116_PopulatingNextRightPointersInEachNode(2);
        p116_PopulatingNextRightPointersInEachNode three = new p116_PopulatingNextRightPointersInEachNode(3);
        p116_PopulatingNextRightPointersInEachNode four = new p116_PopulatingNextRightPointersInEachNode(4);
        p116_PopulatingNextRightPointersInEachNode five = new p116_PopulatingNextRightPointersInEachNode(5);
        p116_PopulatingNextRightPointersInEachNode six = new p116_PopulatingNextRightPointersInEachNode(6);
        p116_PopulatingNextRightPointersInEachNode seven = new p116_PopulatingNextRightPointersInEachNode(7);
        root.left = two;
        root.right = three;
        two.left = four;
        two.right = five;
        three.left = six;
        three.right = seven;
        p116_PopulatingNextRightPointersInEachNode res = connect(root);
        System.out.println("res = " + res);
    }

    public static p116_PopulatingNextRightPointersInEachNode connect(p116_PopulatingNextRightPointersInEachNode root) {
        // 判空返回
        if (root == null) {
            return root;
        }
        // 存放每层的结点的队列
        Deque<p116_PopulatingNextRightPointersInEachNode> queue = new LinkedList<>();
        // 头结点入队列
        queue.offer(root);
        // 开始循环
        while (!queue.isEmpty()) {
            // 当前层的结点个数
            int size = queue.size();
            // 遍历当前层
            while (size > 0) {
                // 当前层每一个结点
                p116_PopulatingNextRightPointersInEachNode tempNode = queue.poll();
                // 如果到当前层的最后一个结点了，指向空，否则会指向下一层的结点
                if (size == 1) {
                    tempNode.next = null;
                }
                // 如果没到当前层最后一个结点，从左指向右
                else {
                    tempNode.next = queue.peek();
                }
                // 左子结点不为空入队列
                if (tempNode.left != null) {
                    queue.offer(tempNode.left);
                }
                // 右子结点不为空入队列
                if (tempNode.right != null) {
                    queue.offer(tempNode.right);
                }
                // 当前层的结点个数-1
                size--;
            }
        }
        // 返回结果
        return root;
    }

}
