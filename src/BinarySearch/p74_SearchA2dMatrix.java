package BinarySearch;

public class p74_SearchA2dMatrix {

    public static void main(String[] args) {
        int[][] matrix = {
                {1, 3, 5, 7},
                {10, 11, 16, 20},
                {23, 30, 34, 50},
        };
        int target = 3;
        boolean res = searchMatrix(matrix, target);
        System.out.println("res = " + res);
    }

    public static boolean searchMatrix(int[][] matrix, int target) {
        // 判空返回
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return false;
        }
        // 分别获得行数和列数
        int row = matrix.length - 1;
        int col = matrix[0].length - 1;
        // pos通过比较每一行的最后一个元素确定目标值在哪一行
        int pos = 0;
        // 分别遍历每一行最后一个元素，找到目标值在哪一行
        for (int i = 0; i <= row; i++) {
            // 如果当前行的最后一个元素和目标值相等，直接返回true
            if (matrix[i][col] == target) {
                return true;
            }
            // 如果当前行的最后一个元素小于目标值，说明目标值在当前行之后的行
            else if (matrix[i][col] < target) {
                pos = i + 1;
            }
        }
        // 这里是为了防止每一行都没有符合条件的数组越界，说明整个数组都没有符合条件的
        if (pos > row) {
            return false;
        }
        // 既然找到了目标值在哪一行，正常的二分查找即可
        int left = 0;
        int right = col;
        while (left <= right) {
            int mid = ((right - left) >> 1) + left;
            if (matrix[pos][mid] == target) {
                return true;
            } else if (matrix[pos][mid] > target) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        // 如果都没找到，返回false
        return false;
    }

}
