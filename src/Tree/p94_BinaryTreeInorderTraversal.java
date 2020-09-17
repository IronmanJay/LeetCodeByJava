package Tree;

import java.util.*;

public class p94_BinaryTreeInorderTraversal {

    int val;
    p94_BinaryTreeInorderTraversal left;
    p94_BinaryTreeInorderTraversal right;

    p94_BinaryTreeInorderTraversal() {

    }

    p94_BinaryTreeInorderTraversal(int val) {
        this.val = val;
    }

    p94_BinaryTreeInorderTraversal(int val, p94_BinaryTreeInorderTraversal left, p94_BinaryTreeInorderTraversal right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }

    public static void main(String[] args) {
        p94_BinaryTreeInorderTraversal root = new p94_BinaryTreeInorderTraversal(1);
        p94_BinaryTreeInorderTraversal right = new p94_BinaryTreeInorderTraversal(2);
        p94_BinaryTreeInorderTraversal right1 = new p94_BinaryTreeInorderTraversal(3);
        root.left = null;
        root.right = right;
        right.left = right1;
        List<Integer> res = inorderTraversal(root);
        System.out.println("res = " + res);
    }

    public static List<Integer> inorderTraversal(p94_BinaryTreeInorderTraversal root) {
        // 结果数组
        List<Integer> res = new ArrayList<>();
        // 栈存放结点
        Deque<p94_BinaryTreeInorderTraversal> stack = new LinkedList<>();
        // 第一个判断条件是为了将头结点入栈而且还判断每次更新root为右子结点为空时遍历中间结点，第二个判断条件是为了遍历整个树
        while (root != null || !stack.isEmpty()) {
            // 将某个结点的全部左子树的左节点全部入栈，因为中序遍历是左->中->右
            while (root != null) {
                stack.push(root);
                root = root.left;
            }
            // 此时开始弹出，弹出的就是此时这个子树的左子结点
            root = stack.pop();
            // 将值加入到结果数组
            res.add(root.val);
            // 然后更新root为右子结点，因为中间结点已经在栈中了，所以最后放入右子结点，形成了左->中->右的顺序，更新后的右子结点同样按照先将右子结点的全部左子树的左节点全部入栈
            root = root.right;
        }
        // 返回结果
        return res;
    }

}
