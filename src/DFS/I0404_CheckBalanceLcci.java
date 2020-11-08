package DFS;

public class I0404_CheckBalanceLcci {

    int val;
    I0404_CheckBalanceLcci left;
    I0404_CheckBalanceLcci right;

    I0404_CheckBalanceLcci(int x) {
        val = x;
    }

    public static void main(String[] args) {
        I0404_CheckBalanceLcci root = new I0404_CheckBalanceLcci(3);
        I0404_CheckBalanceLcci nine = new I0404_CheckBalanceLcci(9);
        I0404_CheckBalanceLcci twenty = new I0404_CheckBalanceLcci(20);
        I0404_CheckBalanceLcci fifty = new I0404_CheckBalanceLcci(15);
        I0404_CheckBalanceLcci seven = new I0404_CheckBalanceLcci(7);
        root.left = nine;
        root.right = twenty;
        twenty.left = fifty;
        twenty.right = seven;
        boolean res = isBalanced(root);
        System.out.println("res = " + res);
    }

    public static boolean isBalanced(I0404_CheckBalanceLcci root) {
        // 返回结果
        return getHeight(root) >= 0;
    }

    public static int getHeight(I0404_CheckBalanceLcci root) {
        // 判空返回0，循环跳出条件
        if (root == null) {
            return 0;
        }
        // 左子树高度
        int leftHeight = getHeight(root.left);
        // 右子树高度
        int rightHeight = getHeight(root.right);
        // 如果左右子树高度差大于1或者左右子树有一个不满足要求返回-1
        if (leftHeight == -1 || rightHeight == -1 || Math.abs(leftHeight - rightHeight) > 1) {
            return -1;
        }
        // 返回当前子树高度
        else {
            return Math.max(leftHeight, rightHeight) + 1;
        }
    }

}
