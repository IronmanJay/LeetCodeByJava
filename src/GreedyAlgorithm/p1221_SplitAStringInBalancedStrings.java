package GreedyAlgorithm;

public class p1221_SplitAStringInBalancedStrings {

    public static void main(String[] args) {
        String s = "RLRRLLRLRL";
        int res = balancedStringSplit(s);
        System.out.println("res = " + res);
    }

    public static int balancedStringSplit(String s) {
        // 结果
        int res = 0;
        // 定义平衡因子，如果为零，说明当前平衡，res++，假设一开始是平衡的，所以为0
        int balance = 0;
        // 开始遍历
        for (int i = 0; i < s.length(); i++) {
            // 遇到'L'，balance--
            if (s.charAt(i) == 'L') {
                balance--;
            }
            // 遇到'R'，balance++
            if (s.charAt(i) == 'R') {
                balance++;
            }
            // 如果到这里balance为0，说明遇到一个平衡子平衡字符串，结果+1
            if (balance == 0) {
                res++;
            }
        }
        // 返回结果
        return res;
    }

}
