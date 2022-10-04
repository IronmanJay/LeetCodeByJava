package String;

public class p392_JudgeSubsequence {

    public static void main(String[] args) {
        String s = "abc";
        String t = "ahbgdc";
        boolean res = isSubsequence(s, t);
        System.out.println("res = " + res);
    }

    public static boolean isSubsequence(String s, String t) {
        int lenT = t.length();
        int lenS = s.length();
        if ((lenS == 0 && lenT != 0) || (lenS == 0 && lenT == 0)) {
            return true;
        }
        int indexS = 0;
        for (int i = 0; i < lenT; i++) {
            if (t.charAt(i) == s.charAt(indexS)) {
                indexS++;
                if (indexS == lenS) {
                    return true;
                }
            }
        }
        return false;
    }

}
