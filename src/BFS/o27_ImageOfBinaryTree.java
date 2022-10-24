package BFS;

import java.util.LinkedList;
import java.util.Queue;

public class o27_ImageOfBinaryTree {

    int val;
    o27_ImageOfBinaryTree left;
    o27_ImageOfBinaryTree right;

    public o27_ImageOfBinaryTree(int val) {
        this.val = val;
    }

    public o27_ImageOfBinaryTree(int val, o27_ImageOfBinaryTree left, o27_ImageOfBinaryTree right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }

    public static void main(String[] args) {
        o27_ImageOfBinaryTree root = new o27_ImageOfBinaryTree(4);
        o27_ImageOfBinaryTree left = new o27_ImageOfBinaryTree(2);
        o27_ImageOfBinaryTree right = new o27_ImageOfBinaryTree(7);
        o27_ImageOfBinaryTree left1 = new o27_ImageOfBinaryTree(1);
        o27_ImageOfBinaryTree left2 = new o27_ImageOfBinaryTree(3);
        o27_ImageOfBinaryTree right1 = new o27_ImageOfBinaryTree(6);
        o27_ImageOfBinaryTree right2 = new o27_ImageOfBinaryTree(9);
        root.left = left;
        left.left = left1;
        left.right = left2;
        root.right = right;
        right.left = right1;
        right.right = right2;
        o27_ImageOfBinaryTree res = mirrorTree(root);
        preOrder(res);
    }

    public static void preOrder(o27_ImageOfBinaryTree root) {
        if (root != null) {
            System.out.print(root.val + " ");
            preOrder(root.left);
            preOrder((root.right));
        }
    }

    public static o27_ImageOfBinaryTree mirrorTree(o27_ImageOfBinaryTree root) {
        if (root == null) {
            return root;
        }
        Queue<o27_ImageOfBinaryTree> queue = new LinkedList<o27_ImageOfBinaryTree>();
        queue.offer(root);
        while (queue.size() != 0) {
            o27_ImageOfBinaryTree node = queue.poll();
            o27_ImageOfBinaryTree temp = node.left;
            node.left = node.right;
            node.right = temp;
            if (node.left != null) {
                queue.offer(node.left);
            }
            if (node.right != null) {
                queue.offer(node.right);
            }
        }
        return root;
    }

}
