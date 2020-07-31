package HashTable;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class p347_TopKFrequentElements {

    public static void main(String[] args) {
        int[] nums = {1, 1, 1, 2, 2, 3};
        int k = 2;
        int[] res = topKFrequent(nums, k);
        System.out.println("res = " + Arrays.toString(res));
    }

    public static int[] topKFrequent(int[] nums, int k) {
        // 定义结果数组，长度就是k
        int[] res = new int[k];
        // 创建HashMap，Key为元素值，Value为元素值对应的出现次数
        HashMap<Integer, Integer> map = new HashMap<>();
        // 自定义大顶堆，队列从头到尾降序排列，这里使用Map.Entry存储方便后续遍历
        PriorityQueue<Map.Entry<Integer, Integer>> maxHeap = new PriorityQueue<>((a, b) -> b.getValue() - a.getValue());
        // 遍历每个元素，统计出现的次数，如果当前元素值第一次出现就是默认值+1，如果不是第一次出现就是之前的个数+1
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
        }
        // 使用大顶堆对统计完的元素值个数进行降序排列
        for (Map.Entry<Integer, Integer> m : map.entrySet()) {
            maxHeap.offer(m);
        }
        // 从大顶堆中弹出前k个元素，就是次数最多的k个元素，加入到结果数组，另外这里是getKey，需要获取元素值，而不是具体出现的次数
        for (int i = 0; i < k; i++) {
            res[i] = maxHeap.poll().getKey();
        }
        // 返回结果
        return res;
    }

}
