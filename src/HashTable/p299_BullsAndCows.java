package HashTable;

public class p299_BullsAndCows {

    public static void main(String[] args) {
        String secret = "1807";
        String guess = "7810";
        String res = getHint(secret, guess);
        System.out.println("res = " + res);
    }

    public static String getHint(String secret, String guess) {
        int[] s = new int[10];
        int[] g = new int[10];
        int A = 0;
        int B = 0;
        for (int i = 0; i < guess.length(); i++) {
            if (secret.charAt(i) == guess.charAt(i)) {
                A++;
            } else {
                s[secret.charAt(i) - '0']++;
                g[guess.charAt(i) - '0']++;
            }
        }
        for (int i = 0; i < 10; i++) {
            B += Math.min(s[i], g[i]);
        }
        return A + "A" + B + "B";
    }

}
