package Sort;

import java.util.Arrays;

public class p242_ValidAnagram {

    public static void main(String[] args) {
        String s = "anagram";
        String t = "nagaram";
        boolean res = isAnagram(s, t);
        System.out.println("res = " + res);
    }

    public static boolean isAnagram(String s, String t) {
        // 如果长度不相等，说明不是有效的字母异位词，返回false即可
        if (s.length() != t.length()) {
            return false;
        }
        // 将两个字符串转为字符数组
        char[] arrS = s.toCharArray();
        char[] arrT = t.toCharArray();
        // 之后进行排序
        Arrays.sort(arrS);
        Arrays.sort(arrT);
        // 如果排序之后两个字符数组相等，说明是有效的字母异位词，如果排序之后不相等，也就意味着两个字符串包含的字母不相同，说明并不是有效的字母异位词
        return Arrays.equals(arrS, arrT);
    }

}
