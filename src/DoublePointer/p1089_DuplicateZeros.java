package DoublePointer;

import java.util.Arrays;

/**
 * @Author: IronmanJay
 * @Description: 1089.复写零
 * @CreateTime: 2023-03-17  08:49
 */
public class p1089_DuplicateZeros {

    public static void main(String[] args) {
        int[] arr = {1, 0, 2, 3, 0, 4, 5, 0};
        duplicateZeros(arr);
        System.out.println("arr = " + Arrays.toString(arr));
    }

    public static void duplicateZeros(int[] arr) {
        int len = arr.length;
        int top = 0;
        int i = -1;
        while (top < len) {
            i++;
            if (arr[i] != 0) {
                top++;
            } else {
                top += 2;
            }
        }
        int j = len - 1;
        if (top == len + 1) {
            arr[j] = 0;
            i--;
            j--;
        }
        while (j >= 0) {
            arr[j] = arr[i];
            j--;
            if (arr[i] == 0) {
                arr[j] = arr[i];
                j--;
            }
            i--;
        }
    }

}
