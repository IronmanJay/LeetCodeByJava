package Math;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: IronmanJay
 * @Description: 89.格雷编码
 * @CreateTime: 2023-01-06  10:52
 */
public class p89_GrayCode {

    public static void main(String[] args) {
        int n = 2;
        List<Integer> res = grayCode(n);
        System.out.println("res = " + res);
    }

    public static List<Integer> grayCode(int n) {
        List<Integer> res = new ArrayList<>();
        res.add(0);
        int head = 1;
        for (int i = 1; i <= n; i++) {
            for (int j = res.size() - 1; j >= 0; j--) {
                res.add(head + res.get(j));
            }
            head <<= 1;
        }
        return res;
    }

}
