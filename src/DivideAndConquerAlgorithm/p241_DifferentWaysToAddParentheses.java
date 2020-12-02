package DivideAndConquerAlgorithm;

import java.util.ArrayList;
import java.util.List;

public class p241_DifferentWaysToAddParentheses {

    public static void main(String[] args) {
        String input = "2-1-1";
        List<Integer> res = diffWaysToCompute(input);
        System.out.println("res = " + res);
    }

    public static List<Integer> diffWaysToCompute(String input) {
        // 结果数组
        List<Integer> res = new ArrayList<>();
        // 遍历每个元素，其实就是找运算符，相当于树的根节点
        for (int i = 0; i < input.length(); i++) {
            // 找运算符
            int operator = input.charAt(i);
            // 找到了一个运算符
            if (operator == '+' || operator == '-' || operator == '*') {
                // 从这里开始分治，运算符相当于根节点，使用分治的思想递归遍历求左子树的值和右子树的值，注意：substring()这个方法包括起始索引，不包括结束索引
                List<Integer> leftList = diffWaysToCompute(input.substring(0, i));
                List<Integer> rightList = diffWaysToCompute(input.substring(i + 1, input.length()));
                // 看似是一个数组，其实每次递归这里面只有左子树和右子树的值
                for (int leftRes : leftList) {
                    for (int rightRes : rightList) {
                        // 根据运算符进行运算，加入到结果数组
                        if (operator == '+') {
                            res.add(leftRes + rightRes);
                        } else if (operator == '-') {
                            res.add(leftRes - rightRes);
                        } else {
                            res.add(leftRes * rightRes);
                        }
                    }
                }
            }
        }
        // 如果没有运算符，说明全是数字，将数字加入到结果数组即可，其实递归遍历到这里就好比到了叶子节点，只有一个数加入返回即可，准备回溯进行运算，层层回溯最终得到整个结果
        if (res.size() == 0) {
            res.add(Integer.parseInt(input));
        }
        // 返回结果
        return res;
    }

}
