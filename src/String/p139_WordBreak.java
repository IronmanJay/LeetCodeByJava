package String;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class p139_WordBreak {

    public static void main(String[] args) {
        String s = "leetcode";
        List<String> wordDict = Arrays.asList(new String[]{"leet", "code"});
        boolean res = wordBreak(s, wordDict);
        System.out.println("res = " + res);
    }

    public static boolean wordBreak(String s, List<String> wordDict) {
        Set<String> wordDictSet = new HashSet(wordDict);
        int lenS = s.length();
        boolean[] dp = new boolean[lenS + 1];
        dp[0] = true;
        for (int i = 1; i <= lenS; i++) {
            for (int j = 0; j < i; j++) {
                if (dp[j] && wordDictSet.contains(s.substring(j, i))) {
                    dp[i] = true;
                    break;
                }
            }
        }
        return dp[lenS];
    }

}
