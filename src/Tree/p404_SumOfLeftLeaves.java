package Tree;

public class p404_SumOfLeftLeaves {

    int val;
    p404_SumOfLeftLeaves left;
    p404_SumOfLeftLeaves right;

    public p404_SumOfLeftLeaves() {
    }

    public p404_SumOfLeftLeaves(int val) {
        this.val = val;
    }

    public p404_SumOfLeftLeaves(int val, p404_SumOfLeftLeaves left, p404_SumOfLeftLeaves right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }

    public static void main(String[] args) {
        p404_SumOfLeftLeaves root = new p404_SumOfLeftLeaves(3);
        p404_SumOfLeftLeaves left = new p404_SumOfLeftLeaves(9);
        p404_SumOfLeftLeaves right = new p404_SumOfLeftLeaves(20);
        p404_SumOfLeftLeaves right1 = new p404_SumOfLeftLeaves(15);
        p404_SumOfLeftLeaves right2 = new p404_SumOfLeftLeaves(7);
        root.left = left;
        root.right = right;
        right.left = right1;
        right.right = right2;
        int res = sumOfLeftLeaves(root);
        System.out.println("res = " + res);
    }

    public static int sumOfLeftLeaves(p404_SumOfLeftLeaves root) {
        if (root == null) {
            return 0;
        }
        int res = 0;
        if (root.left != null && root.left.left == null && root.left.right == null) {
            res += root.left.val;
        }
        return res + sumOfLeftLeaves(root.left) + sumOfLeftLeaves(root.right);
    }

}
