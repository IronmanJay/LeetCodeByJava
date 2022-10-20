package DFS;

public class p99_RecoverBinarySearchTree {

    int val;
    p99_RecoverBinarySearchTree left;
    p99_RecoverBinarySearchTree right;

    public p99_RecoverBinarySearchTree() {
    }

    public p99_RecoverBinarySearchTree(int val, p99_RecoverBinarySearchTree left, p99_RecoverBinarySearchTree right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }

    public p99_RecoverBinarySearchTree(int val) {
        this.val = val;
    }

    public static void main(String[] args) {
        p99_RecoverBinarySearchTree root = new p99_RecoverBinarySearchTree(1);
        p99_RecoverBinarySearchTree left1 = new p99_RecoverBinarySearchTree(3);
        p99_RecoverBinarySearchTree left2 = new p99_RecoverBinarySearchTree(2);
        root.left = left1;
        left1.right = left2;
        recoverTree(root);
        preOrder(root);
    }

    private static void preOrder(p99_RecoverBinarySearchTree root) {
        if (root != null) {
            System.out.print(root.val + " ");
            preOrder(root.left);
            preOrder(root.right);
        }
    }

    private static p99_RecoverBinarySearchTree t1, t2, pre;

    public static void recoverTree(p99_RecoverBinarySearchTree root) {
        t1 = null;
        t2 = null;
        pre = null;
        inOrder(root);
        int temp = t1.val;
        t1.val = t2.val;
        t2.val = temp;
    }

    public static void inOrder(p99_RecoverBinarySearchTree root) {
        if (root != null) {
            inOrder(root.left);
            if (pre != null && pre.val > root.val) {
                if (t1 == null) {
                    t1 = pre;
                }
                t2 = root;
            }
            pre = root;
            inOrder(root.right);
        }
    }

}
