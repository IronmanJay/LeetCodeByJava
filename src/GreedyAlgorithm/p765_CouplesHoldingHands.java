package GreedyAlgorithm;

public class p765_CouplesHoldingHands {

    public static void main(String[] args) {
        int[] row = {0, 2, 1, 3};
        int res = minSwapsCouples(row);
        System.out.println("res = " + res);
    }

    public static int minSwapsCouples(int[] row) {
        // 定义结果
        int res = 0;
        // 开始遍历，每次得到一对情侣，所以i+=2
        for (int i = 0; i < row.length; i += 2) {
            // 这里用异或，实际就是如果当前是偶数，那么对应的情侣肯定是对应的(+1)奇数，反之如果当前数是奇数，那么对应的情侣肯定是对应的(-1)偶数
            if (row[i + 1] == (row[i] ^ 1)) {
                // 如果符合要求，直接跳出当前这次循环就可以
                continue;
            }
            // 否则开始交换，找到对应的情侣，结果相应+1
            res++;
            for (int j = i + 1; j < row.length; j++) {
                if (row[j] == (row[i] ^ 1)) {
                    row[j] = row[i + 1];
                    row[i + 1] = row[i] ^ 1;
                    break;
                }
            }
        }
        // 返回结果
        return res;
    }

}
