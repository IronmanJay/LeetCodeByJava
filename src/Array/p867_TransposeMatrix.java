package Array;

import java.util.Arrays;

public class p867_TransposeMatrix {

    public static void main(String[] args) {
        int[][] A = {
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9},
        };
        int[][] res = transpose(A);
        System.out.println("res = " + Arrays.deepToString(res));
    }

    public static int[][] transpose(int[][] A) {
        // 矩阵转置之后的行就是原来的列，矩阵转置之后的列就是原来的行
        int[][] res = new int[A[0].length][A.length];
        // 按照a[i][j] = a[j][i]矩阵转置定义遍历赋值即可
        for (int i = 0; i < A[0].length; i++) {
            for (int j = 0; j < A.length; j++) {
                res[i][j] = A[j][i];
            }
        }
        // 返回结果
        return res;
    }

}
