package String;

public class p3_LongestSubstringWithoutRepeatingCharacters {

    public static void main(String[] args) {
        String s = "pwwkew";
        int res = lengthOfLongestSubstring(s);
        System.out.println("res = " + res);
    }

    public static int lengthOfLongestSubstring(String s) {
        // 双指针，分别指向开始和结尾
        int start = 0;
        int end = 0;
        // 临时的无重复字符的子串长度
        int len = 0;
        // 结果
        int res = 0;
        // 在不越界的情况下遍历字符串
        while (end < s.length()) {
            // 首先看当前字符是否在之前的子串中出现过，如果出现过，start位置向左调整，把重复出现的剔除掉
            for (int index = start; index < end; index++) {
                if (s.charAt(index) == s.charAt(end)) {
                    start = index + 1;
                    len = end - start;
                    break;
                }
            }
            // 如果当前字符没有在之前的子串中出现过，结尾指针继续后移，开始指针不用动，长度相应增加，res返回较大的
            end++;
            len++;
            res = Math.max(res, len);
        }
        return res;
    }

}
