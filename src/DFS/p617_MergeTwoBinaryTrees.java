package DFS;

/**
 * @Author: IronmanJay
 * @Description: 617.合并二叉树
 * @CreateTime: 2023-03-12  09:48
 */
public class p617_MergeTwoBinaryTrees {

    int val;
    p617_MergeTwoBinaryTrees left;
    p617_MergeTwoBinaryTrees right;

    public p617_MergeTwoBinaryTrees() {
    }

    public p617_MergeTwoBinaryTrees(int val) {
        this.val = val;
    }

    public p617_MergeTwoBinaryTrees(int val, p617_MergeTwoBinaryTrees left, p617_MergeTwoBinaryTrees right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }

    public static void main(String[] args) {
        // 测试省略
    }

    public static p617_MergeTwoBinaryTrees mergeTrees(p617_MergeTwoBinaryTrees root1, p617_MergeTwoBinaryTrees root2) {
        if (root1 == null) {
            return root2;
        }
        if (root2 == null) {
            return root1;
        }
        root1.val = root1.val + root2.val;
        root1.left = mergeTrees(root1.left, root2.left);
        root1.right = mergeTrees(root1.right, root2.right);
        return root1;
    }

}
