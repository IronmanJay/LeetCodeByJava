package GreedyAlgorithm;

/**
 * @Author: IronmanJay
 * @Description: TODO
 * @CreateTime: 2023-03-06  10:34
 */
public class p1323_Maximum69Number {

    public static void main(String[] args) {
        int num = 9669;
        int res = maximum69Number(num);
        System.out.println("res = " + res);
    }

    public static int maximum69Number(int num) {
        if (num / 1000 == 6) {
            return num + 3000;
        } else if (num % 1000 / 100 == 6) {
            return num + 300;
        } else if (num % 100 / 10 == 6) {
            return num + 30;
        } else if (num % 10 == 6) {
            return num + 3;
        }
        return num;
    }

}
