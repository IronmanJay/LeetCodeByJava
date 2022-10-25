package BFS;

import java.util.LinkedList;
import java.util.Queue;

public class p965_UnivaluedBinaryTree {

    int val;
    p965_UnivaluedBinaryTree left;
    p965_UnivaluedBinaryTree right;

    public p965_UnivaluedBinaryTree(int val) {
        this.val = val;
    }

    public p965_UnivaluedBinaryTree(int val, p965_UnivaluedBinaryTree left, p965_UnivaluedBinaryTree right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }

    public static void main(String[] args) {
        p965_UnivaluedBinaryTree root = new p965_UnivaluedBinaryTree(1);
        p965_UnivaluedBinaryTree left = new p965_UnivaluedBinaryTree(1);
        p965_UnivaluedBinaryTree left1 = new p965_UnivaluedBinaryTree(1);
        p965_UnivaluedBinaryTree left2 = new p965_UnivaluedBinaryTree(1);
        p965_UnivaluedBinaryTree right = new p965_UnivaluedBinaryTree(1);
        p965_UnivaluedBinaryTree right1 = new p965_UnivaluedBinaryTree(1);
        root.left = left;
        left.left = left1;
        left.right = left2;
        root.right = right;
        right.right = right1;
        boolean res = isUnivalTree(root);
        System.out.println("res = " + res);
    }

    public static boolean isUnivalTree(p965_UnivaluedBinaryTree root) {
        Queue<p965_UnivaluedBinaryTree> queue = new LinkedList<>();
        queue.offer(root);
        while (queue.size() != 0) {
            p965_UnivaluedBinaryTree node = queue.poll();
            if (node.left != null) {
                if (node.val != node.left.val) {
                    return false;
                }
                queue.offer(node.left);
            }
            if (node.right != null) {
                if (node.val != node.right.val) {
                    return false;
                }
                queue.offer(node.right);
            }
        }
        return true;
    }

}
