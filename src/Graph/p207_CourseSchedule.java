package Graph;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;

public class p207_CourseSchedule {

    public static void main(String[] args) {
        int numCourses = 2;
        int[][] prerequisites = {
                {1, 0},
                {0, 1},
        };
        boolean res = canFinish(numCourses, prerequisites);
        System.out.println("res = " + res);
    }

    public static boolean canFinish(int numCourses, int[][] prerequisites) {
        // 特判
        if (numCourses <= 0) {
            return false;
        }
        if (prerequisites.length == 0) {
            return true;
        }
        // 表示每个节点入度个数
        int[] inDegree = new int[numCourses];
        // 邻接表，表示每个节点的下一个连接节点
        HashSet<Integer>[] adj = new HashSet[numCourses];
        // 队列存放入度为0的节点，表示当前节点不需要前置课程或者前置课程已经完成
        Queue<Integer> queue = new LinkedList<>();
        // 初始化邻接表
        for (int i = 0; i < numCourses; i++) {
            adj[i] = new HashSet<>();
        }
        // 给入度数组和邻接表赋值
        for (int[] p : prerequisites) {
            inDegree[p[0]]++;
            adj[p[1]].add(p[0]);
        }
        // 将入度为0的节点入队列
        for (int i = 0; i < numCourses; i++) {
            if (inDegree[i] == 0) {
                queue.add(i);
            }
        }
        // 记录符合条件的课程数量
        int count = 0;
        // 开始遍历
        while (!queue.isEmpty()) {
            Integer curNode = queue.poll();
            // 队列里面的都是符合条件的，所以+1
            count++;
            // 遍历当前节点的所有后继节点，这些节点的入度-1，可以看作此前置课程已经完成，所以后续课程也就没有此限定条件了
            for (int successor : adj[curNode]) {
                inDegree[successor]--;
                // 如果有某一个后继节点入度为0，说明当前课程的前置课程已经完成，可以继续后面的课程，所以入队列
                if (inDegree[successor] == 0) {
                    queue.add(successor);
                }
            }
        }
        // 最终如果遍历得到的课程数量和题目所给的课程数量相等，说明所有的课程都符合要求
        return count == numCourses;
    }

}
