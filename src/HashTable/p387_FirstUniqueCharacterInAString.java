package HashTable;

public class p387_FirstUniqueCharacterInAString {

    public static void main(String[] args) {
        String s = "leetcode";
        int res = firstUniqChar(s);
        System.out.println("res = " + res);
    }

    public static int firstUniqChar(String s) {
        int[] map = new int[26];
        char[] chars = s.toCharArray();
        for (char ch : chars) {
            map[ch - 'a']++;
        }
        for (int i = 0; i < chars.length; i++) {
            if (map[chars[i] - 'a'] == 1) {
                return i;
            }
        }
        return -1;
    }

}
