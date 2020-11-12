package DFS;

public class p114_FlattenBinaryTreeToLinkedList {

    int val;
    p114_FlattenBinaryTreeToLinkedList left;
    p114_FlattenBinaryTreeToLinkedList right;

    p114_FlattenBinaryTreeToLinkedList() {

    }

    p114_FlattenBinaryTreeToLinkedList(int val) {
        this.val = val;
    }

    p114_FlattenBinaryTreeToLinkedList(int val, p114_FlattenBinaryTreeToLinkedList left, p114_FlattenBinaryTreeToLinkedList right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }

    public static void main(String[] args) {
        p114_FlattenBinaryTreeToLinkedList one = new p114_FlattenBinaryTreeToLinkedList(1);
        p114_FlattenBinaryTreeToLinkedList two = new p114_FlattenBinaryTreeToLinkedList(2);
        p114_FlattenBinaryTreeToLinkedList three = new p114_FlattenBinaryTreeToLinkedList(3);
        p114_FlattenBinaryTreeToLinkedList four = new p114_FlattenBinaryTreeToLinkedList(4);
        p114_FlattenBinaryTreeToLinkedList five = new p114_FlattenBinaryTreeToLinkedList(5);
        p114_FlattenBinaryTreeToLinkedList six = new p114_FlattenBinaryTreeToLinkedList(6);
        one.left = two;
        one.right = five;
        two.left = three;
        two.right = four;
        five.right = six;
        flatten(one);
        while (one != null) {
            if (one.right != null) {
                System.out.print(one.val + "->");
            } else {
                System.out.print(one.val);
            }
            one = one.right;
        }
    }

    public static void flatten(p114_FlattenBinaryTreeToLinkedList root) {
        // 递归跳出条件，找到叶子节点开始操作
        if (root == null) {
            return;
        }
        // 因为右子树还没修改的情况下不能修改根节点指向右子树的指针，所以使用后序遍历（后序遍历：左->右->根，最后修改根节点的指针）
        flatten(root.left);
        flatten(root.right);
        // 首先将当前节点的右子树保存
        p114_FlattenBinaryTreeToLinkedList tempNode = root.right;
        // 再将当前节点的右子树更新为左子树
        root.right = root.left;
        // 然后将当前节点的左子树置空
        root.left = null;
        // 最后将当前节点更新后的右子树与之前保存的右子树拼接
        while (root.right != null) {
            root = root.right;
        }
        root.right = tempNode;
        // 结束当前操作
        return;
    }

}
