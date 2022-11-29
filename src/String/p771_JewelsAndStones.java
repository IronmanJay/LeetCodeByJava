package String;

/**
 * @Author: IronmanJay
 * @Description: 771.宝石与石头
 * @CreateTime: 2022-11-29  09:23
 */
public class p771_JewelsAndStones {

    public static void main(String[] args) {
        String jewels = "aA";
        String stones = "aAAbbbb";
        int res = numJewelsInStones(jewels, stones);
        System.out.println("res = " + res);
    }

    public static int numJewelsInStones(String jewels, String stones) {
        int[] countSmall = new int[27];
        int[] countBig = new int[27];
        for (int i = 0; i < stones.length(); i++) {
            char c = stones.charAt(i);
            if (c >= 'a' && c <= 'z') {
                countSmall[c - 'a']++;
            } else {
                countBig[c - 'A']++;
            }
        }
        int res = 0;
        for (int i = 0; i < jewels.length(); i++) {
            char c = jewels.charAt(i);
            if (c >= 'a' && c <= 'z') {
                res += countSmall[c - 'a'];
            } else {
                res += countBig[c - 'A'];
            }
        }
        return res;
    }

}
