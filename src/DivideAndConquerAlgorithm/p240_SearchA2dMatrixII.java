package DivideAndConquerAlgorithm;

public class p240_SearchA2dMatrixII {

    public static void main(String[] args) {
        int[][] matrix = {
                {1, 4, 7, 11, 15},
                {2, 5, 8, 12, 19},
                {3, 6, 9, 16, 22},
                {10, 13, 14, 17, 24},
                {18, 21, 23, 26, 30}
        };
        int target = 5;
        boolean res = searchMatrix(matrix, target);
        System.out.println("res = " + res);
    }

    public static boolean searchMatrix(int[][] matrix, int target) {
        // 判空返回false
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return false;
        }
        // 获取行数
        int row = matrix.length;
        // 获取列数
        int col = matrix.length;
        // 行索引，从最后一行开始
        int rowIndex = row - 1;
        // 列索引，从第一列开始
        int colIndex = 0;
        // 扫描数组
        while (rowIndex >= 0 && colIndex < col) {
            // 如果左下角元素等于目标值返回true
            if (target == matrix[rowIndex][colIndex]) {
                return true;
            }
            // 如果目标值小于左下角元素，说明目标值比这一行所有元素都小，因为左下角元素是这一行最小的元素
            else if (target < matrix[rowIndex][colIndex]) {
                // 那么目标值肯定不在这一行，开始扫描上一行
                rowIndex--;
            }
            // 如果目标值大于左下角元素，说明目标值比这一列所有元素都大，因为左下角元素是这一列最大的元素
            else {
                // 那么目标值肯定不在这一列，开始扫描下一列
                colIndex++;
            }
        }
        // 如果没找到返回false
        return false;
    }

}
