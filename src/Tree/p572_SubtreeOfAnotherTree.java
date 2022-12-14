package Tree;

/**
 * @Author: IronmanJay
 * @Description: 572.另一棵树的子树
 * @CreateTime: 2022-12-14  10:51
 */
public class p572_SubtreeOfAnotherTree {

    int val;
    p572_SubtreeOfAnotherTree left;
    p572_SubtreeOfAnotherTree right;

    public p572_SubtreeOfAnotherTree(int val) {
        this.val = val;
    }

    public p572_SubtreeOfAnotherTree(int val, p572_SubtreeOfAnotherTree left, p572_SubtreeOfAnotherTree right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }

    public static void main(String[] args) {
        p572_SubtreeOfAnotherTree root = new p572_SubtreeOfAnotherTree(3);
        p572_SubtreeOfAnotherTree left = new p572_SubtreeOfAnotherTree(4);
        p572_SubtreeOfAnotherTree right = new p572_SubtreeOfAnotherTree(5);
        p572_SubtreeOfAnotherTree left1 = new p572_SubtreeOfAnotherTree(1);
        p572_SubtreeOfAnotherTree left2 = new p572_SubtreeOfAnotherTree(2);
        root.left = left;
        root.right = right;
        left.left = left1;
        left.right = left2;
        p572_SubtreeOfAnotherTree subRoot = new p572_SubtreeOfAnotherTree(4);
        p572_SubtreeOfAnotherTree subRootLeft = new p572_SubtreeOfAnotherTree(1);
        p572_SubtreeOfAnotherTree subRootRight = new p572_SubtreeOfAnotherTree(2);
        subRoot.left = subRootLeft;
        subRoot.right = subRootRight;
        boolean res = isSubtree(root, subRoot);
        System.out.println("res = " + res);
    }

    public static boolean isSubtree(p572_SubtreeOfAnotherTree root, p572_SubtreeOfAnotherTree subRoot) {
        if (judge(root, subRoot) || subRoot == null) {
            return true;
        }
        if (root == null) {
            return false;
        }
        return isSubtree(root.left, subRoot) || isSubtree(root.right, subRoot);
    }

    public static boolean judge(p572_SubtreeOfAnotherTree p, p572_SubtreeOfAnotherTree q) {
        if (p == null && q == null) {
            return true;
        } else if (p == null || q == null) {
            return false;
        } else if (p.val != q.val) {
            return false;
        }
        return judge(p.left, q.left) && judge(p.right, q.right);
    }

}
