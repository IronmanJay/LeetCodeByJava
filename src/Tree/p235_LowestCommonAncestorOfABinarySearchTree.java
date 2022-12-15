package Tree;

/**
 * @Author: IronmanJay
 * @Description: 235.二叉搜索树的最近公共祖先
 * @CreateTime: 2022-12-15  11:48
 */
public class p235_LowestCommonAncestorOfABinarySearchTree {

    int val;
    p235_LowestCommonAncestorOfABinarySearchTree left;
    p235_LowestCommonAncestorOfABinarySearchTree right;

    public p235_LowestCommonAncestorOfABinarySearchTree(int val) {
        this.val = val;
    }

    public p235_LowestCommonAncestorOfABinarySearchTree(int val, p235_LowestCommonAncestorOfABinarySearchTree left, p235_LowestCommonAncestorOfABinarySearchTree right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }

    public static void main(String[] args) {
        p235_LowestCommonAncestorOfABinarySearchTree root = new p235_LowestCommonAncestorOfABinarySearchTree(6);
        p235_LowestCommonAncestorOfABinarySearchTree left = new p235_LowestCommonAncestorOfABinarySearchTree(2);
        p235_LowestCommonAncestorOfABinarySearchTree right = new p235_LowestCommonAncestorOfABinarySearchTree(8);
        p235_LowestCommonAncestorOfABinarySearchTree left1 = new p235_LowestCommonAncestorOfABinarySearchTree(0);
        p235_LowestCommonAncestorOfABinarySearchTree left2 = new p235_LowestCommonAncestorOfABinarySearchTree(4);
        p235_LowestCommonAncestorOfABinarySearchTree right1 = new p235_LowestCommonAncestorOfABinarySearchTree(7);
        p235_LowestCommonAncestorOfABinarySearchTree right2 = new p235_LowestCommonAncestorOfABinarySearchTree(9);
        p235_LowestCommonAncestorOfABinarySearchTree left4 = new p235_LowestCommonAncestorOfABinarySearchTree(3);
        p235_LowestCommonAncestorOfABinarySearchTree left5 = new p235_LowestCommonAncestorOfABinarySearchTree(5);
        root.left = left;
        root.right = right;
        left.left = left1;
        left.right = left2;
        left2.left = left4;
        left2.left = left5;
        right.left = right1;
        right.right = right2;
        p235_LowestCommonAncestorOfABinarySearchTree res = lowestCommonAncestor(root, left, right);
        System.out.println("res = " + res.val);
    }

    public static p235_LowestCommonAncestorOfABinarySearchTree lowestCommonAncestor(p235_LowestCommonAncestorOfABinarySearchTree root, p235_LowestCommonAncestorOfABinarySearchTree p, p235_LowestCommonAncestorOfABinarySearchTree q) {
        p235_LowestCommonAncestorOfABinarySearchTree dad = root;
        while (true) {
            if (dad.val > p.val && dad.val > q.val) {
                dad = dad.left;
            } else if (dad.val < p.val && dad.val < q.val) {
                dad = dad.right;
            } else {
                break;
            }
        }
        return dad;
    }

}
