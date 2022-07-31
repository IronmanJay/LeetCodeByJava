package Tree;

import java.util.*;

public class p103_ZigzagOrderTraversalOfBinaryTrees {

    int val;
    p103_ZigzagOrderTraversalOfBinaryTrees left;
    p103_ZigzagOrderTraversalOfBinaryTrees right;

    public p103_ZigzagOrderTraversalOfBinaryTrees() {
    }

    public p103_ZigzagOrderTraversalOfBinaryTrees(int val) {
        this.val = val;
    }

    public p103_ZigzagOrderTraversalOfBinaryTrees(int val, p103_ZigzagOrderTraversalOfBinaryTrees left, p103_ZigzagOrderTraversalOfBinaryTrees right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }

    public static void main(String[] args) {
        p103_ZigzagOrderTraversalOfBinaryTrees root = new p103_ZigzagOrderTraversalOfBinaryTrees(3);
        p103_ZigzagOrderTraversalOfBinaryTrees left = new p103_ZigzagOrderTraversalOfBinaryTrees(9);
        p103_ZigzagOrderTraversalOfBinaryTrees right = new p103_ZigzagOrderTraversalOfBinaryTrees(20);
        p103_ZigzagOrderTraversalOfBinaryTrees right1 = new p103_ZigzagOrderTraversalOfBinaryTrees(15);
        p103_ZigzagOrderTraversalOfBinaryTrees right2 = new p103_ZigzagOrderTraversalOfBinaryTrees(7);
        root.left = left;
        root.right = right;
        right.left = right1;
        right.right = right2;
        List<List<Integer>> res = zigzagLevelOrder(root);
        System.out.println("res = " + res);
    }

    public static List<List<Integer>> zigzagLevelOrder(p103_ZigzagOrderTraversalOfBinaryTrees root) {
        List<List<Integer>> res = new LinkedList<List<Integer>>();
        boolean flag = true;
        if (root == null) {
            return res;
        }
        Queue<p103_ZigzagOrderTraversalOfBinaryTrees> queue = new ArrayDeque<p103_ZigzagOrderTraversalOfBinaryTrees>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            Deque<Integer> list = new LinkedList<Integer>();
            for (int i = 0; i < size; i++) {
                p103_ZigzagOrderTraversalOfBinaryTrees temp = queue.poll();
                if (flag) {
                    list.offerLast(temp.val);
                } else {
                    list.offerFirst(temp.val);
                }
                if (temp.left != null) {
                    queue.offer(temp.left);
                }
                if (temp.right != null) {
                    queue.offer(temp.right);
                }
            }
            res.add(new LinkedList<Integer>(list));
            if (flag) {
                flag = false;
            } else {
                flag = true;
            }
        }
        return res;
    }

}
