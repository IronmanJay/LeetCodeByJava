package HashTable;

import java.util.HashSet;
import java.util.Set;

public class p202_HappyNumber {

    public static void main(String[] args) {
        int num = 19;
        boolean res = isHappy(num);
        System.out.println("res = " + res);
    }

    public static boolean isHappy(int n) {
        // 利用HashSet的不可重复性来存放每一次的结果
        Set<Integer> set = new HashSet<>();
        // 首先将这个数字加入
        set.add(n);
        // 开始无限循环，当有结果时返回
        while (true) {
            // 调用函数
            n = getHappyNum(n);
            // 如果是快乐数返回True
            if (n == 1) {
                return true;
            }
            // 如果出现循环，返回False
            if (set.contains(n)) {
                return false;
            }
            // 如果既不是快乐数也没出现循环，将这个数加入HashSet中
            set.add(n);
        }
    }

    public static int getHappyNum(int n) {
        // 存放每一次的值
        int sum = 0;
        // 当数字不为0时继续遍历
        while (n != 0) {
            // 从个位开始向左位取每一位的平方和
            sum += (n % 10) * (n % 10);
            // 从个位向左，遍历下一个位数的值
            n /= 10;
        }
        // 返回这次的结果
        return sum;
    }

}
