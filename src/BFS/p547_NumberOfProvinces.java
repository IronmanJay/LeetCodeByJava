package BFS;

import java.util.LinkedList;
import java.util.Queue;

public class p547_NumberOfProvinces {

    public static void main(String[] args) {
        int[][] isConnected = {{1, 1, 0}, {1, 1, 0}, {0, 0, 1}};
        int res = findCircleNum(isConnected);
        System.out.println("res = " + res);
    }

    public static int findCircleNum(int[][] isConnected) {
        int n = isConnected.length;
        Queue<Integer> queue = new LinkedList<>();
        boolean[] visited = new boolean[201];
        int res = 0;
        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                queue.offer(i);
                while (queue.size() != 0) {
                    int k = queue.poll();
                    visited[k] = true;
                    for (int j = 0; j < n; j++) {
                        if (isConnected[k][j] == 1 && !visited[j]) {
                            queue.offer(j);
                        }
                    }
                }
                res++;
            }
        }
        return res;
    }

}
