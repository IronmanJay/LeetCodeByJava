package Tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class p637_LevelAverageOfBinaryTrees {

    int val;
    p637_LevelAverageOfBinaryTrees left;
    p637_LevelAverageOfBinaryTrees right;

    public p637_LevelAverageOfBinaryTrees() {
    }

    public p637_LevelAverageOfBinaryTrees(int val) {
        this.val = val;
    }

    public p637_LevelAverageOfBinaryTrees(int val, p637_LevelAverageOfBinaryTrees left, p637_LevelAverageOfBinaryTrees right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }

    public static void main(String[] args) {
        p637_LevelAverageOfBinaryTrees root = new p637_LevelAverageOfBinaryTrees(3);
        p637_LevelAverageOfBinaryTrees left = new p637_LevelAverageOfBinaryTrees(9);
        p637_LevelAverageOfBinaryTrees right = new p637_LevelAverageOfBinaryTrees(20);
        p637_LevelAverageOfBinaryTrees right1 = new p637_LevelAverageOfBinaryTrees(15);
        p637_LevelAverageOfBinaryTrees right2 = new p637_LevelAverageOfBinaryTrees(7);
        root.left = left;
        root.right = right;
        right.left = right1;
        right.right = right2;
        List<Double> res = averageOfLevels(root);
        System.out.println("res = " + res);
    }

    public static List<Double> averageOfLevels(p637_LevelAverageOfBinaryTrees root) {
        List<Double> res = new ArrayList<>();
        Queue<p637_LevelAverageOfBinaryTrees> queue = new LinkedList<>();
        queue.add(root);
        while (queue.size() != 0) {
            double sum = 0;
            int len = queue.size();
            for (int i = 0; i < len; i++) {
                p637_LevelAverageOfBinaryTrees temp = queue.poll();
                sum += temp.val;
                if (temp.left != null) {
                    queue.add(temp.left);
                }
                if (temp.right != null) {
                    queue.add(temp.right);
                }
            }
            res.add(sum / len);
        }
        return res;
    }

}
