package String;

public class p58_LengthOfLastWord {

    public static void main(String[] args) {
        String s = "Hello World";
        int res = lengthOfLastWord(s);
        System.out.println("res = " + res);
    }

    public static int lengthOfLastWord(String s) {
        int res = 0;
        int index = s.length() - 1;
        while (index >= 0 && s.charAt(index) == ' ') {
            index--;
        }
        while (index >= 0 && s.charAt(index) != ' ') {
            res++;
            index--;
        }
        return res;
    }

}
