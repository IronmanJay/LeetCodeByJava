package Tree;

import java.util.ArrayList;
import java.util.List;

public class p872_TreesWithSimilarLeaves {

    int val;
    p872_TreesWithSimilarLeaves left;
    p872_TreesWithSimilarLeaves right;

    public p872_TreesWithSimilarLeaves() {
    }

    public p872_TreesWithSimilarLeaves(int val, p872_TreesWithSimilarLeaves left, p872_TreesWithSimilarLeaves right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }

    public p872_TreesWithSimilarLeaves(int val) {
        this.val = val;
    }

    public static void main(String[] args) {
        p872_TreesWithSimilarLeaves root1 = new p872_TreesWithSimilarLeaves(1);
        p872_TreesWithSimilarLeaves root1left = new p872_TreesWithSimilarLeaves(2);
        p872_TreesWithSimilarLeaves root1right = new p872_TreesWithSimilarLeaves(3);
        p872_TreesWithSimilarLeaves root2 = new p872_TreesWithSimilarLeaves(1);
        p872_TreesWithSimilarLeaves root2left = new p872_TreesWithSimilarLeaves(3);
        p872_TreesWithSimilarLeaves root2right = new p872_TreesWithSimilarLeaves(2);
        root1.left = root1left;
        root1.right = root1right;
        root2.left = root2left;
        root2.right = root2right;
        boolean res = leafSimilar(root1, root2);
        System.out.println("res = " + res);
    }

    public static boolean leafSimilar(p872_TreesWithSimilarLeaves root1, p872_TreesWithSimilarLeaves root2) {
        List<Integer> list1 = new ArrayList<>();
        List<Integer> list2 = new ArrayList<>();
        preOrder(root1, list1);
        preOrder(root2, list2);
        if (list1.size() != list2.size()) {
            return false;
        }
        for (int i = 0; i < list1.size(); i++) {
            if (list1.get(i) != list2.get(i)) {
                return false;
            }
        }
        return true;
    }

    public static void preOrder(p872_TreesWithSimilarLeaves root, List<Integer> nums) {
        if (root == null) {
            return;
        }
        if (root.left == null && root.right == null) {
            nums.add(root.val);
        }
        preOrder(root.left, nums);
        preOrder(root.right, nums);
    }

}
