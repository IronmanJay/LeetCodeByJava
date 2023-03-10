package DFS;

/**
 * @Author: IronmanJay
 * @Description: 783.二叉搜索树节点最小距离
 * @CreateTime: 2023-03-10  08:33
 */
public class p783_MinimumDistanceBetweenBstNodes {

    int val;
    p783_MinimumDistanceBetweenBstNodes left;
    p783_MinimumDistanceBetweenBstNodes right;

    public p783_MinimumDistanceBetweenBstNodes() {
    }

    public p783_MinimumDistanceBetweenBstNodes(int val) {
        this.val = val;
    }

    public p783_MinimumDistanceBetweenBstNodes(int val, p783_MinimumDistanceBetweenBstNodes left, p783_MinimumDistanceBetweenBstNodes right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }

    public static void main(String[] args) {
        p783_MinimumDistanceBetweenBstNodes root = new p783_MinimumDistanceBetweenBstNodes(4);
        p783_MinimumDistanceBetweenBstNodes left = new p783_MinimumDistanceBetweenBstNodes(2);
        p783_MinimumDistanceBetweenBstNodes right = new p783_MinimumDistanceBetweenBstNodes(6);
        p783_MinimumDistanceBetweenBstNodes left1 = new p783_MinimumDistanceBetweenBstNodes(1);
        p783_MinimumDistanceBetweenBstNodes left2 = new p783_MinimumDistanceBetweenBstNodes(3);
        root.left = left;
        root.right = right;
        left.left = left1;
        left.right = left2;
        int res = minDiffInBST(root);
        System.out.println("res = " + res);
    }

    private static p783_MinimumDistanceBetweenBstNodes pre = null;
    private static int min = Integer.MAX_VALUE;

    public static int minDiffInBST(p783_MinimumDistanceBetweenBstNodes root) {
        inOrder(root);
        return min;
    }

    public static void inOrder(p783_MinimumDistanceBetweenBstNodes root) {
        if (root != null) {
            inOrder(root.left);
            if (pre != null) {
                min = Math.min(min, Math.abs(pre.val - root.val));
            }
            pre = root;
            inOrder(root.right);
        }
    }

}
