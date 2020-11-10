package DFS;

public class p98_ValidateBinarySearchTree {

    int val;
    p98_ValidateBinarySearchTree left;
    p98_ValidateBinarySearchTree right;

    p98_ValidateBinarySearchTree(int x) {
        val = x;
    }

    public static void main(String[] args) {
        p98_ValidateBinarySearchTree five = new p98_ValidateBinarySearchTree(5);
        p98_ValidateBinarySearchTree one = new p98_ValidateBinarySearchTree(1);
        p98_ValidateBinarySearchTree four = new p98_ValidateBinarySearchTree(4);
        p98_ValidateBinarySearchTree three = new p98_ValidateBinarySearchTree(3);
        p98_ValidateBinarySearchTree six = new p98_ValidateBinarySearchTree(6);
        five.left = one;
        five.right = four;
        four.left = three;
        four.right = six;
        boolean res = isValidBST(five);
        System.out.println("res = " + res);
    }

    // 因为测试用例有一个值太恶心了，所以用long类型
    private static long min = Long.MIN_VALUE;

    public static boolean isValidBST(p98_ValidateBinarySearchTree root) {
        // 判空返回，也是递归的终止条件，因为空树也算二叉搜索树，所以返回true
        if (root == null) {
            return true;
        }
        // 递归到最左子树最左一个节点，可以理解为升序数组的第一个数是最小的，我们验证此棵树的数组是否升序即可
        if (isValidBST(root.left)) {
            // 判断当前结点是否为当前状态最小的，因为二叉搜索树保证根节点大于左子节点，同时小于右子结点，我们向左递归，所以应该判断是否小于
            if (min < root.val) {
                // 如果满足上述条件，说明当前左子树合格，更新当前最小值，其实min就是二叉搜索树根节点的前一个结点，也是对应升序数组当前数字的前一个数字，自然更新为当前值为最小
                min = root.val;
                // 开始由此根节点向右递归，步骤如上
                return isValidBST(root.right);
            }
        }
        // 如果不合格返回false
        return false;
    }

}
