package BFS;

import java.util.LinkedList;
import java.util.Queue;

public class l44_OpeningCeremonyFireworks {

    int val;
    l44_OpeningCeremonyFireworks left;
    l44_OpeningCeremonyFireworks right;

    public l44_OpeningCeremonyFireworks(int val) {
        this.val = val;
    }

    public static void main(String[] args) {
        l44_OpeningCeremonyFireworks root = new l44_OpeningCeremonyFireworks(1);
        l44_OpeningCeremonyFireworks left = new l44_OpeningCeremonyFireworks(3);
        l44_OpeningCeremonyFireworks right = new l44_OpeningCeremonyFireworks(2);
        l44_OpeningCeremonyFireworks left1 = new l44_OpeningCeremonyFireworks(1);
        l44_OpeningCeremonyFireworks right1 = new l44_OpeningCeremonyFireworks(2);
        root.left = left;
        root.right = right;
        left.left = left1;
        right.left = right1;
        int res = numColor(root);
        System.out.println("res = " + res);
    }

    public static int numColor(l44_OpeningCeremonyFireworks root) {
        int[] hash = new int[1001];
        Queue<l44_OpeningCeremonyFireworks> queue = new LinkedList<>();
        queue.offer(root);
        while (queue.size() != 0) {
            l44_OpeningCeremonyFireworks node = queue.poll();
            hash[node.val]++;
            if (node.left != null) {
                queue.offer(node.left);
            }
            if (node.right != null) {
                queue.offer(node.right);
            }
        }
        int res = 0;
        for (int i = 0; i < 1001; i++) {
            if (hash[i] != 0) {
                res++;
            }
        }
        return res;
    }

}
