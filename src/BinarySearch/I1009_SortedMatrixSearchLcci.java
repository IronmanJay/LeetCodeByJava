package BinarySearch;

public class I1009_SortedMatrixSearchLcci {

    public static void main(String[] args) {
        int[][] matrix = {
                {1, 4, 7, 11, 15},
                {2, 5, 8, 12, 19},
                {3, 6, 9, 16, 22},
                {10, 13, 14, 17, 24},
                {18, 21, 23, 26, 30},
        };
        int target = 20;
        boolean res = searchMatrix(matrix, target);
        System.out.println("res = " + res);
    }

    public static boolean searchMatrix(int[][] matrix, int target) {
        // 判空返回
        if (matrix == null || matrix.length == 0) {
            return false;
        }
        // 分别获取行数和列数
        int row = matrix.length - 1;
        int col = matrix[0].length - 1;
        // 行的开始位置从第一行
        int rowIndex = 0;
        // 列的开始位置从最后一列
        int colIndex = col;
        // 从右上角开始比较
        while (rowIndex <= row && colIndex >= 0) {
            // 因为二维数组从上到下升序，从左到右升序，所以如果当前值小于目标值，说明目标值需要向下查找，所以行索引+1
            if (matrix[rowIndex][colIndex] < target) {
                rowIndex++;
            }
            // 因为二维数组从上到下升序，从左到右升序，所以如果当前值大于目标值，说明目标值需要向左查找，所以列索引-1
            else if (matrix[rowIndex][colIndex] > target) {
                colIndex--;
            }
            // 如果找到返回true
            else {
                return true;
            }
        }
        // 如果没找到返回false
        return false;
    }

}
