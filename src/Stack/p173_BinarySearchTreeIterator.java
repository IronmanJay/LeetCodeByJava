package Stack;

import java.util.Stack;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        this.val = x;
    }
}

public class p173_BinarySearchTreeIterator {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(7);
        TreeNode left = new TreeNode(3);
        TreeNode right = new TreeNode(15);
        TreeNode right1 = new TreeNode(9);
        TreeNode right2 = new TreeNode(20);
        root.left = left;
        root.right = right;
        right.left = right1;
        right.right = right2;
        p173_BinarySearchTreeIterator iterator = new p173_BinarySearchTreeIterator(root);
        System.out.print(iterator.next() + " ");
        System.out.print(iterator.next() + " ");
        System.out.print(iterator.hasNext() + " ");
        System.out.print(iterator.next() + " ");
        System.out.print(iterator.hasNext() + " ");
        System.out.print(iterator.next() + " ");
        System.out.print(iterator.hasNext() + " ");
        System.out.print(iterator.next() + " ");
        System.out.print(iterator.hasNext() + " ");
    }

    // 自定义栈，存放树节点
    Stack<TreeNode> stack = new Stack<>();

    public p173_BinarySearchTreeIterator(TreeNode root) {
        // 初始化的时候调用自定义push方法，先把根节点的所有左子节点入栈，从栈底到栈顶由大到小排列，首先就可以返回这个树的最小值
        push(root);
    }

    // 自定义push方法，把当前节点的所有左子节点加入栈，因为BST左子节点都是小的，保证了从栈底到栈顶由大到小排列，每次都可以返回最小值
    public void push(TreeNode root) {
        // 把当前节点的每一个左子节点都入栈
        while (root != null) {
            // 入栈
            stack.push(root);
            // 继续向下一个左子节点遍历
            root = root.left;
        }
    }

    public int next() {
        // 先出栈，出栈的这个节点肯定是当前树最小的节点
        TreeNode node = stack.pop();
        /*
           先看弹出的这个节点是否有右子节点，如果有就入栈，因为左子节点都已经弹出了，如果有右子节点，说明当前这个节点
           既有左子节点又有右子节点，按照BST的规则，大小顺序是左->中->右，因为前面都已经按顺序弹出，所以将右子节点入栈，
           使用自定义push方法，右子节点有左子节点那么它在栈底，因为左面最小，可以理解为当前的右子节点在自定义push的过程
           中已经变成了当前这个子树的根节点，然后按照自定义规则继续调用
        */
        if (node.right != null) {
            push(node.right);
        }
        // 返回弹出的这个节点的值，是当前最小值
        return node.val;
    }

    public boolean hasNext() {
        // 只要栈不空就说明有下一个，因为调用next()方法的时候，如果有下一个节点就入栈了
        return !stack.isEmpty();
    }

}
