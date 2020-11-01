package Queue;

import java.util.LinkedList;
import java.util.Queue;

public class p993_CousinsInBinaryTree {

    int val;
    p993_CousinsInBinaryTree left;
    p993_CousinsInBinaryTree right;

    p993_CousinsInBinaryTree() {

    }

    p993_CousinsInBinaryTree(int val) {
        this.val = val;
    }

    p993_CousinsInBinaryTree(int val, p993_CousinsInBinaryTree left, p993_CousinsInBinaryTree right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }

    public static void main(String[] args) {
        p993_CousinsInBinaryTree root = new p993_CousinsInBinaryTree(1);
        p993_CousinsInBinaryTree left = new p993_CousinsInBinaryTree(2);
        p993_CousinsInBinaryTree right = new p993_CousinsInBinaryTree(3);
        p993_CousinsInBinaryTree left1 = new p993_CousinsInBinaryTree(4);
        p993_CousinsInBinaryTree right1 = new p993_CousinsInBinaryTree(5);
        root.left = left;
        root.right = right;
        left.right = left1;
        right.right = right1;
        int x = 5;
        int y = 4;
        boolean res = isCousins(root, x, y);
        System.out.println("res = " + res);
    }

    public static boolean isCousins(p993_CousinsInBinaryTree root, int x, int y) {
        // 判空和特殊情况返回false
        if (root == null || x == root.val || y == root.val) {
            return false;
        }
        // 层序遍历的队列
        Queue<p993_CousinsInBinaryTree> queue = new LinkedList<>();
        // 和x值相等的节点
        p993_CousinsInBinaryTree xNode = null;
        // 和y值相等的节点
        p993_CousinsInBinaryTree yNode = null;
        // 和x值相等的节点的父节点
        p993_CousinsInBinaryTree xFatherNode = null;
        // 和y值相等的节点的父节点
        p993_CousinsInBinaryTree yFatherNode = null;
        // 头结点入队列
        queue.add(root);
        // 开始层序遍历
        while (!queue.isEmpty()) {
            // 当前层的结点数量
            int size = queue.size();
            // 当前层有几个结点就遍历几次
            while (size > 0) {
                // 出队列
                p993_CousinsInBinaryTree tempNode = queue.poll();
                // 当前层的结点数量-1
                size--;
                // 先看左子树
                if (tempNode.left != null) {
                    // 入队列
                    queue.add(tempNode.left);
                    // 找目标结点和目标结点的父结点
                    if (tempNode.left.val == x) {
                        xNode = tempNode.left;
                        xFatherNode = tempNode;
                    }
                    if (tempNode.left.val == y) {
                        yNode = tempNode.left;
                        yFatherNode = tempNode;
                    }
                }
                // 再看右子树
                if (tempNode.right != null) {
                    // 入队列
                    queue.add(tempNode.right);
                    // 找目标节点和目标结点的父结点
                    if (tempNode.right.val == x) {
                        xNode = tempNode.right;
                        xFatherNode = tempNode;
                    }
                    if (tempNode.right.val == y) {
                        yNode = tempNode.right;
                        yFatherNode = tempNode;
                    }
                }
                // 如果两个目标结点此次遍历都没找到不操作，等待下一次遍历
                if (xNode == null && yNode == null) {

                }
                // 如果此次遍历两个节点都找到了，判断是不是堂兄弟结点
                else if (xNode != null && yNode != null) {
                    // 在这个for循环里面遍历保证了在同一层，只要不是一个父结点就是堂兄弟结点
                    return xFatherNode != yFatherNode;
                }
                // 如果这一层都遍历完了，还没找到两个目标结点，说明已经不满足堂兄弟结点在同一层（深度）的要求的，就算下面有目标结点也不满足题意了，返回false
                else if (size == 0) {
                    return false;
                }
            }
        }
        // 遍历结束都没找到，返回false
        return false;
    }

}
