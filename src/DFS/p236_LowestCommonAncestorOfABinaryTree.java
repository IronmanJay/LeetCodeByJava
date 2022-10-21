package DFS;

public class p236_LowestCommonAncestorOfABinaryTree {

    int val;
    p236_LowestCommonAncestorOfABinaryTree left;
    p236_LowestCommonAncestorOfABinaryTree right;

    public p236_LowestCommonAncestorOfABinaryTree(int val) {
        this.val = val;
    }

    public p236_LowestCommonAncestorOfABinaryTree(int val, p236_LowestCommonAncestorOfABinaryTree left, p236_LowestCommonAncestorOfABinaryTree right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }

    public static void main(String[] args) {
        p236_LowestCommonAncestorOfABinaryTree root = new p236_LowestCommonAncestorOfABinaryTree(3);
        p236_LowestCommonAncestorOfABinaryTree left = new p236_LowestCommonAncestorOfABinaryTree(5);
        p236_LowestCommonAncestorOfABinaryTree right = new p236_LowestCommonAncestorOfABinaryTree(1);
        p236_LowestCommonAncestorOfABinaryTree left1 = new p236_LowestCommonAncestorOfABinaryTree(6);
        p236_LowestCommonAncestorOfABinaryTree left2 = new p236_LowestCommonAncestorOfABinaryTree(2);
        p236_LowestCommonAncestorOfABinaryTree right1 = new p236_LowestCommonAncestorOfABinaryTree(0);
        p236_LowestCommonAncestorOfABinaryTree right2 = new p236_LowestCommonAncestorOfABinaryTree(8);
        p236_LowestCommonAncestorOfABinaryTree left3 = new p236_LowestCommonAncestorOfABinaryTree(7);
        p236_LowestCommonAncestorOfABinaryTree left4 = new p236_LowestCommonAncestorOfABinaryTree(4);
        root.left = left;
        root.right = right;
        left.left = left1;
        left.right = left2;
        left2.left = left3;
        left2.right = left4;
        right.left = right1;
        right.right = right2;
        p236_LowestCommonAncestorOfABinaryTree ree = lowestCommonAncestor(root, left, right);
        System.out.println("ree = " + ree.val);
    }

    public static p236_LowestCommonAncestorOfABinaryTree lowestCommonAncestor(p236_LowestCommonAncestorOfABinaryTree root, p236_LowestCommonAncestorOfABinaryTree p, p236_LowestCommonAncestorOfABinaryTree q) {
        if (root == null) {
            return root;
        }
        if (root == p || root == q) {
            return root;
        }
        p236_LowestCommonAncestorOfABinaryTree left = lowestCommonAncestor(root.left, p, q);
        p236_LowestCommonAncestorOfABinaryTree right = lowestCommonAncestor(root.right, p, q);
        if (left != null && right != null) {
            return root;
        } else if (left != null) {
            return left;
        } else if (right != null) {
            return right;
        }
        return null;
    }

}
