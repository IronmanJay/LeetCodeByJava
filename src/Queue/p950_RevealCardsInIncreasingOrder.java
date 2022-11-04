package Queue;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class p950_RevealCardsInIncreasingOrder {

    public static void main(String[] args) {
        int[] deck = {17, 13, 11, 2, 3, 5, 7};
        int[] res = deckRevealedIncreasing(deck);
        System.out.println(Arrays.toString(res));
    }

    public static int[] deckRevealedIncreasing(int[] deck) {
        int len = deck.length;
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < len; i++) {
            queue.offer(i);
        }
        int[] res = new int[len];
        Arrays.sort(deck);
        for (int num : deck) {
            res[queue.poll()] = num;
            if (!queue.isEmpty()) {
                queue.offer(queue.poll());
            }
        }
        return res;
    }

}
