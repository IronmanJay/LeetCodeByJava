package Tree;

/**
 * @Author: IronmanJay
 * @Description: 337.打家劫舍 III
 * @CreateTime: 2022-12-16  09:18
 */
public class p337_HouseRobberIII {

    int val;
    p337_HouseRobberIII left;
    p337_HouseRobberIII right;

    public p337_HouseRobberIII(int val) {
        this.val = val;
    }

    public p337_HouseRobberIII(int val, p337_HouseRobberIII left, p337_HouseRobberIII right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }

    public static void main(String[] args) {
        p337_HouseRobberIII root = new p337_HouseRobberIII(3);
        p337_HouseRobberIII left = new p337_HouseRobberIII(2);
        p337_HouseRobberIII right = new p337_HouseRobberIII(3);
        p337_HouseRobberIII left1 = new p337_HouseRobberIII(3);
        p337_HouseRobberIII right1 = new p337_HouseRobberIII(1);
        root.left = left;
        root.right = right;
        left.right = left1;
        right.right = right1;
        int res = rob(root);
        System.out.println("res = " + res);
    }

    public static int rob(p337_HouseRobberIII root) {
        int[] res = getResByDfs(root);
        return Math.max(res[0], res[1]);
    }

    public static int[] getResByDfs(p337_HouseRobberIII root) {
        if (root == null) {
            return new int[]{0, 0};
        }
        int[] left = getResByDfs(root.left);
        int[] right = getResByDfs(root.right);
        int selectVal = root.val + left[1] + right[1];
        int noSelectVal = Math.max(left[0], right[1]) + Math.max(left[1], right[0]);
        return new int[]{selectVal, noSelectVal};
    }

}
