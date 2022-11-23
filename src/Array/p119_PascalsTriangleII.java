package Array;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: IronmanJay
 * @Description: 119.杨辉三角 II
 * @CreateTime: 2022-11-23  09:01
 */
public class p119_PascalsTriangleII {

    public static void main(String[] args) {
        List<Integer> res = getRow(3);
        System.out.println("res = " + res);
    }

    public static List<Integer> getRow(int rowIndex) {
        List<Integer> res = new ArrayList<Integer>();
        res.add(1);
        for (int i = 1; i <= rowIndex; i++) {
            res.add(0);
            for (int j = i; j > 0; j--) {
                res.set(j, res.get(j) + res.get(j - 1));
            }
        }
        return res;
    }

}
