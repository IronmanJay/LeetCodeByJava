package Array;

import java.util.Arrays;

public class p73_SetMatrixZeroes {

    public static void main(String[] args) {
        int[][] matrix = {
                {1, 1, 1},
                {1, 0, 1},
                {1, 1, 1},
        };
        setZeroes(matrix);
        System.out.println("res = " + Arrays.deepToString(matrix));
    }

    public static void setZeroes(int[][] matrix) {
        // 获取行数
        int row = matrix.length;
        // 获取列数
        int col = matrix[0].length;
        // 判断第一行（列）是否有0的标志位，留在最后看是否需要置为0
        boolean rowFlag = false;
        boolean colFlag = false;
        // 扫描第一行（列）是否有0
        for (int i = 0; i < col; i++) {
            if (matrix[0][i] == 0) {
                rowFlag = true;
                break;
            }
        }
        for (int i = 0; i < row; i++) {
            if (matrix[i][0] == 0) {
                colFlag = true;
                break;
            }
        }
        // 从下标[1,1]开始扫描，如果有0，将所在行的第一个元素和所在列的第一个元素置为0
        for (int i = 1; i < row; i++) {
            for (int j = 1; j < col; j++) {
                if (matrix[i][j] == 0) {
                    matrix[i][0] = 0;
                    matrix[0][j] = 0;
                }
            }
        }
        /*
          扫描第一行（列），如果有0，说明有可能是本来这行（列）就有0，所以需要把这一行（列）置为0
          另外一种情况就是，这一行（列）里面有0，所以也需要将这一行（列）置为0
          所以不管是本来就有0还是里面有0，都需要将这一行（列）置为0
        */
        for (int i = 1; i < col; i++) {
            if (matrix[0][i] == 0) {
                for (int j = 0; j < row; j++) {
                    matrix[j][i] = 0;
                }
            }
        }
        for (int i = 1; i < row; i++) {
            if (matrix[i][0] == 0) {
                for (int j = 0; j < col; j++) {
                    matrix[i][j] = 0;
                }
            }
        }
        // 最后根据一开始的标志位判断是否将第一行（列）置为0
        if (rowFlag) {
            for (int i = 0; i < col; i++) {
                matrix[0][i] = 0;
            }
        }
        if (colFlag) {
            for (int i = 0; i < row; i++) {
                matrix[i][0] = 0;
            }
        }
    }

}
