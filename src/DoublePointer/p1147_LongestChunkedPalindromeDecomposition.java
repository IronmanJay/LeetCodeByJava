package DoublePointer;

public class p1147_LongestChunkedPalindromeDecomposition {

    public static void main(String[] args) {
        String text = "ghiabcdefhelloadamhelloabcdefghi";
        int res = longestDecomposition(text);
        System.out.println("res = " + res);
    }

    public static int longestDecomposition(String text) {
        int len = text.length();
        int k = 0;
        int subLen = 1;
        for (int i = 0; i < len; i += subLen) {
            subLen = 1;
            for (int j = len - 1 - i; j >= 0; j--) {
                if ((text.charAt(i) == text.charAt(j)) && (compareStr(text, i, j, subLen) == 0)) {
                    k++;
                    break;
                }
                subLen++;
            }
        }
        return k;
    }

    public static int compareStr(String text, int i, int j, int len) {
        if ((j + len) > text.length()) {
            return -1;
        }
        int flag = 0;
        while (len-- != 0) {
            if (text.charAt(i) == text.charAt(j)) {
                i++;
                j++;
            } else {
                flag = -1;
            }
        }
        return flag;
    }

}
