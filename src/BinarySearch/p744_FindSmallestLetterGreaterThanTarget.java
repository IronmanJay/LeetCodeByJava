package BinarySearch;

/**
 * @Author: IronmanJay
 * @Description: 744.寻找比目标字母大的最小字母
 * @CreateTime: 2022-12-27  10:01
 */
public class p744_FindSmallestLetterGreaterThanTarget {

    public static void main(String[] args) {
        char[] letters = {'c', 'f', 'j'};
        char target = 'a';
        char res = nextGreatestLetter(letters, target);
        System.out.println("res = " + res);
    }

    public static char nextGreatestLetter(char[] letters, char target) {
        int left = 0;
        int right = letters.length - 1;
        if (letters[right] <= target) {
            return letters[0];
        }
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (letters[mid] <= target) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return letters[left];
    }

}
