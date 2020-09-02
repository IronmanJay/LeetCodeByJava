package Sort;

public class o45_ArrangeTheArrayIntoTheSmallestNumber {

    public static void main(String[] args) {
        int[] nums = {3, 30, 34, 5, 9};
        String s = minNumber(nums);
        System.out.println("s = " + s);
    }

    public static String minNumber(int[] nums) {
        // 新建一个字符数组存放原数组
        String[] strs = new String[nums.length];
        for (int i = 0; i < nums.length; i++) {
            strs[i] = String.valueOf(nums[i]);
        }
        // 进行自定义快速排序
        quickSort(strs, 0, strs.length - 1);
        // 使用StringBuilder将排序好的字符数组拼接
        StringBuilder res = new StringBuilder();
        for (String str : strs) {
            res.append(str);
        }
        return res.toString();
    }

    public static void quickSort(String[] arr, int low, int high) {
        if (low >= high) {
            return;
        }
        int left = low;
        int right = high;
        // 记得要和这个关键值拼接比较
        String key = arr[low];
        while (left < right) {
            // 这里就是和普通快速排序不同的地方，若拼接字符串的右 + key >= key + 右值，说明符合要求
            while (left < right && (arr[right] + key).compareTo(key + arr[right]) >= 0) {
                right--;
            }
            // 若拼接字符串的右 + key < key + 右值，说明现在的排列是较大的值，需要交换，变为右 + key > key + 右
            arr[left] = arr[right];
            // 若拼接字符串的左 + key <= key + 左值，说明符合要求
            while (left < right && (arr[left] + key).compareTo(key + arr[left]) <= 0) {
                left++;
            }
            // 若拼接字符串的左 + key > key + 左值，说明现在的排列是较大的值，需要交换，变为左 + key < key + 左
            arr[right] = arr[left];
        }
        arr[left] = key;
        quickSort(arr, low, left - 1);
        quickSort(arr, left + 1, high);
    }

}
