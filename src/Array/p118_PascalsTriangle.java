package Array;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: IronmanJay
 * @Description: 118.杨辉三角
 * @CreateTime: 2022-11-22  09:03
 */
public class p118_PascalsTriangle {

    public static void main(String[] args) {
        List<List<Integer>> res = generate(5);
        for (List r : res) {
            for (int i = 0; i < r.size(); i++) {
                System.out.print(r.get(i) + " ");
            }
            System.out.println();
        }
    }

    public static List<List<Integer>> generate(int numRows) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        for (int i = 0; i < numRows; i++) {
            List<Integer> temp = new ArrayList<Integer>();
            for (int j = 0; j <= i; j++) {
                if (j == 0 || j == i) {
                    temp.add(1);
                } else {
                    int x = res.get(i - 1).get(j - 1);
                    int y = res.get(i - 1).get(j);
                    temp.add(x + y);
                }
            }
            res.add(temp);
        }
        return res;
    }

}
