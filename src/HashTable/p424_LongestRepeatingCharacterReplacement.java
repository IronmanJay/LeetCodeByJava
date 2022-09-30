package HashTable;

public class p424_LongestRepeatingCharacterReplacement {

    public static void main(String[] args) {
        String s = "ABAB";
        int k = 2;
        int res = characterReplacement(s, k);
        System.out.println("res = " + res);
    }

    public static int characterReplacement(String s, int k) {
        int len = s.length();
        int[] map = new int[26];
        int left = 0;
        int right = 0;
        int maxSame = 0;
        while (right < len) {
            int index = s.charAt(right) - 'A';
            map[index]++;
            maxSame = Math.max(maxSame, map[index]);
            int windowsLen = right - left + 1;
            if (windowsLen - maxSame > k) {
                map[s.charAt(left) - 'A']--;
                left++;
            }
            right++;
        }
        return right - left;
    }

}
