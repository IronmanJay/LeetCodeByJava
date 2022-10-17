package DFS;

public class p226_InvertBinaryTree {

    int val;
    p226_InvertBinaryTree left;
    p226_InvertBinaryTree right;

    public p226_InvertBinaryTree() {
    }

    public p226_InvertBinaryTree(int val) {
        this.val = val;
    }

    public p226_InvertBinaryTree(int val, p226_InvertBinaryTree left, p226_InvertBinaryTree right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }

    public static void main(String[] args) {
        p226_InvertBinaryTree root = new p226_InvertBinaryTree(2);
        p226_InvertBinaryTree left = new p226_InvertBinaryTree(1);
        p226_InvertBinaryTree right = new p226_InvertBinaryTree(3);
        root.left = left;
        root.right = right;
        p226_InvertBinaryTree newRoot = invertTree(root);
        preOrder(newRoot);
    }

    public static void preOrder(p226_InvertBinaryTree root) {
        if (root != null) {
            System.out.println(root.val);
            preOrder(root.left);
            preOrder(root.right);
        }
    }

    public static p226_InvertBinaryTree invertTree(p226_InvertBinaryTree root) {
        if (root == null) {
            return null;
        }
        p226_InvertBinaryTree temp = root.left;
        root.left = root.right;
        root.right = temp;
        invertTree(root.left);
        invertTree(root.right);
        return root;
    }

}
