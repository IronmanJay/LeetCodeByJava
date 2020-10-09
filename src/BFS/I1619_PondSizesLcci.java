package BFS;

import java.util.*;

public class I1619_PondSizesLcci {

    public static void main(String[] args) {
        int[][] land = {
                {0, 2, 1, 0},
                {0, 1, 0, 1},
                {1, 1, 0, 1},
                {0, 1, 0, 1},
        };
        int[] res = pondSizes(land);
        System.out.println("res = " + Arrays.toString(res));
    }

    public static int[] pondSizes(int[][] land) {
        // 结果数组
        List<Integer> res = new ArrayList<>();
        // 行数
        int row = land.length;
        // 列数
        int col = land[0].length;
        // 八个方向
        int[][] directions = new int[][]{
                {-1, 0}, {0, 1}, {1, 0}, {0, -1}, {-1, 1}, {1, 1}, {1, -1}, {-1, -1},
        };
        // 开始遍历
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                // 如果是水域的话开始BFS
                if (land[i][j] == 0) {
                    // 存放和当前水域连接的其他水域
                    Queue<Map.Entry<Integer, Integer>> queue = new LinkedList<>();
                    // 将当前水域入队列
                    queue.add(new AbstractMap.SimpleEntry<>(i, j));
                    // 将当前水域置为陆地，防止二次遍历
                    land[i][j] = 1;
                    // 当前水域数
                    int num = 1;
                    // 开始遍历当前水域的其他连接水域，就是BFS
                    while (!queue.isEmpty()) {
                        // 出队列
                        Map.Entry<Integer, Integer> area = queue.poll();
                        // 向八个方向走，如果坐标在地图中，并且是水域，就将此水域置为陆地，防止二次遍历，并且入队列，找下一个连接的水域，并且当前水域数+1
                        for (int[] direction : directions) {
                            int newX = area.getKey() + direction[0];
                            int newY = area.getValue() + direction[1];
                            if (inArea(newX, newY, land) && land[newX][newY] == 0) {
                                land[newX][newY] = 1;
                                num++;
                                queue.add(new AbstractMap.SimpleEntry<>(newX, newY));
                            }
                        }
                    }
                    // 当队列遍历完毕，说明当前没有连接的水域了，加入结果数组，准备下一次遍历
                    res.add(num);
                }
            }
        }
        // 最终的结果数组，取出List中的结果，放入数组
        int[] result = new int[res.size()];
        for (int i = 0; i < result.length; i++) {
            result[i] = res.get(i);
        }
        // 从小到大排序
        Arrays.sort(result);
        // 返回结果
        return result;
    }

    // 判断坐标是否在地图中
    public static boolean inArea(int x, int y, int[][] land) {
        return x >= 0 && y >= 0 && x < land.length && y < land[0].length;
    }

}
