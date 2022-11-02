package Queue;

import java.util.LinkedList;
import java.util.Queue;

public class oII042_NumberOfRecentRequests {

    Queue<Integer> queue;

    public void RecentCounter() {
        queue = new LinkedList<>();
    }

    public int ping(int t) {
        queue.offer(t);
        while (t - 3000 > queue.peek()) {
            queue.poll();
        }
        return queue.size();
    }

}
