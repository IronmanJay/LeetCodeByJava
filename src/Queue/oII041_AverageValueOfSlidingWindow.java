package Queue;

import java.util.LinkedList;
import java.util.Queue;

public class oII041_AverageValueOfSlidingWindow {

    Queue<Integer> queue;
    int size;
    double sum;

    public void MovingAverage(int size) {
        queue = new LinkedList<>();
        this.size = size;
        sum = 0;
    }

    public double next(int val) {
        if (queue.size() == size) {
            sum -= queue.poll();
        }
        queue.offer(val);
        sum += val;
        return sum / queue.size();
    }

}
