package Stack;

public class p316_RemoveDuplicateLetters {

    public static void main(String[] args) {
        String s = "bcabc";
        String res = removeDuplicateLetters(s);
        System.out.println("res = " + res);
    }

    public static String removeDuplicateLetters(String s) {
        StringBuffer res = new StringBuffer();
        boolean[] visited = new boolean[26];
        int[] hash = new int[26];
        for (int i = 0; i < s.length(); i++) {
            hash[s.charAt(i) - 'a']++;
        }
        for (int i = 0; i < s.length(); i++) {
            if (!visited[s.charAt(i) - 'a']) {
                while ((res.length() > 0) && (res.charAt(res.length() - 1) > s.charAt(i)) && (hash[res.charAt(res.length() - 1) - 'a']) >= 1) {
                    visited[res.charAt(res.length() - 1) - 'a'] = false;
                    res.deleteCharAt(res.length() - 1);
                }
                visited[s.charAt(i) - 'a'] = true;
                res.append(s.charAt(i));
            }
            hash[s.charAt(i) - 'a']--;
        }
        return res.toString();
    }

}
