package Queue;

import java.util.LinkedList;
import java.util.Queue;

public class p1823_FindTheWinnerOfTheCircularGame {

    public static void main(String[] args) {
        int res = findTheWinner(5, 2);
        System.out.println("res = " + res);
    }

    public static int findTheWinner(int n, int k) {
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 1; i <= n; i++) {
            queue.offer(i);
        }
        while (queue.size() > 1) {
            for (int i = 1; i < k; i++) {
                queue.offer(queue.poll());
            }
            queue.poll();
        }
        return queue.poll();
    }

}
