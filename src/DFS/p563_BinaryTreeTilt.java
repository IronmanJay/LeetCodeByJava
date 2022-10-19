package DFS;

public class p563_BinaryTreeTilt {

    int val;
    p563_BinaryTreeTilt left;
    p563_BinaryTreeTilt right;

    public p563_BinaryTreeTilt(int val) {
        this.val = val;
    }

    public p563_BinaryTreeTilt(int val, p563_BinaryTreeTilt left, p563_BinaryTreeTilt right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }

    public p563_BinaryTreeTilt() {
    }

    public static void main(String[] args) {
        p563_BinaryTreeTilt root = new p563_BinaryTreeTilt(1);
        p563_BinaryTreeTilt left = new p563_BinaryTreeTilt(2);
        p563_BinaryTreeTilt right = new p563_BinaryTreeTilt(3);
        root.left = left;
        root.right = right;
        int res = findTilt(root);
        System.out.println("res = " + res);
    }

    private static int sum;

    public static int findTilt(p563_BinaryTreeTilt root) {
        sum = 0;
        getTilt(root);
        return sum;
    }

    public static int getTilt(p563_BinaryTreeTilt root) {
        if (root == null) {
            return 0;
        }
        int leftVal = getTilt(root.left);
        int rightVal = getTilt(root.right);
        sum += Math.abs(leftVal - rightVal);
        return root.val + leftVal + rightVal;
    }

}
