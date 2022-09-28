package HashTable;

public class p383_RansomNote {

    public static void main(String[] args) {
        String ransomNote = "a";
        String magazine = "b";
        boolean res = canConstruct(ransomNote, magazine);
        System.out.println("res = " + res);
    }

    public static boolean canConstruct(String ransomNote, String magazine) {
        int lenA = ransomNote.length();
        int lenB = magazine.length();
        int[] map = new int[26];
        for (int i = 0; i < lenA; i++) {
            char temp = ransomNote.charAt(i);
            map[temp - 'a']++;
        }
        for (int i = 0; i < lenB; i++) {
            char temp = magazine.charAt(i);
            map[temp - 'a']--;
        }
        for (int i = 0; i < 26; i++) {
            if (map[i] > 0) {
                return false;
            }
        }
        return true;
    }

}
