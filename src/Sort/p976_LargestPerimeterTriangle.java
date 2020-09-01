package Sort;

public class p976_LargestPerimeterTriangle {

    public static void main(String[] args) {
        int[] A = {3, 2, 3, 4};
        int i = largestPerimeter(A);
        System.out.println("i = " + i);
    }

    public static int largestPerimeter(int[] A) {
        // 判空返回
        if (A == null || A.length == 0) {
            return 0;
        }
        // 对数组进行排序
        quickSort(A, 0, A.length - 1);
        // 从后向前比较，如果发现两边之和大于第三边即可，因为从后向前找，所以只要有满足的就是最大的
        for (int i = A.length - 1; i >= 2; i--) {
            if (A[i] < A[i - 1] + A[i - 2]) {
                return A[i] + A[i - 1] + A[i - 2];
            }
        }
        return 0;
    }

    // 快速排序
    public static void quickSort(int[] arr, int low, int high) {
        if (low >= high) {
            return;
        }
        int left = low;
        int right = high;
        int key = arr[left];
        while (left < right) {
            while (left < right && arr[right] >= key) {
                right--;
            }
            arr[left] = arr[right];
            while (left < right && arr[left] <= key) {
                left++;
            }
            arr[right] = arr[left];
        }
        arr[left] = key;
        quickSort(arr, low, left - 1);
        quickSort(arr, left + 1, high);
    }

}
