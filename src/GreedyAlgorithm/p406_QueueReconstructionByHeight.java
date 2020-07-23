package GreedyAlgorithm;

import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;

public class p406_QueueReconstructionByHeight {

    public static void main(String[] args) {
        int[][] people = {
                {7, 0},
                {4, 4},
                {7, 1},
                {5, 0},
                {6, 1},
                {5, 2}
        };
        int[][] res = reconstructQueue(people);
        System.out.println(Arrays.deepToString(res));
    }

    public static int[][] reconstructQueue(int[][] people) {
        // 对二维数组进行排序，按照身高降序，如果两个人身高相等按前面有多少个比这个人高升序
        Arrays.sort(people, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0] == o2[0] ? o1[1] - o2[1] : o2[0] - o1[0];
            }
        });
        // 因为矮个子的人相对于高个子的人是看不见的，所以只需要插入对应索引位置即可，这个索引就是前面有多少个比这个人高的值
        List<int[]> list = new LinkedList<>();
        for (int[] p : people) {
            list.add(p[1], p);
        }
        // 返回结果
        return list.toArray(new int[list.size()][2]);
    }

}
