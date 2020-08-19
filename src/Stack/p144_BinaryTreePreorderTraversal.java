package Stack;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class p144_BinaryTreePreorderTraversal {

    int val;
    p144_BinaryTreePreorderTraversal left;
    p144_BinaryTreePreorderTraversal right;

    p144_BinaryTreePreorderTraversal(int x) {
        val = x;
    }

    public static void main(String[] args) {
        p144_BinaryTreePreorderTraversal root = new p144_BinaryTreePreorderTraversal(1);
        p144_BinaryTreePreorderTraversal right = new p144_BinaryTreePreorderTraversal(2);
        p144_BinaryTreePreorderTraversal right1 = new p144_BinaryTreePreorderTraversal(3);
        root.right = right;
        right.left = right1;
        List<Integer> res = preorderTraversal(root);
        System.out.println("res = " + res);
    }

    public static List<Integer> preorderTraversal(p144_BinaryTreePreorderTraversal root) {
        // 新建结果数组
        List<Integer> res = new ArrayList<>();
        // 判空返回
        if (root == null) {
            return res;
        }
        // 新建节点栈
        Stack<p144_BinaryTreePreorderTraversal> stack = new Stack<>();
        // 将头节点入栈，方便后续遍历
        stack.push(root);
        // 开始遍历
        while (!stack.isEmpty()) {
            // 取出栈首元素，每次遍历的新节点都相当于root节点，就相当于前序遍历的“根”
            p144_BinaryTreePreorderTraversal node = stack.pop();
            // 将栈首元素值加入结果数组，注意要转为Integer类型
            res.add(Integer.valueOf(node.val));
            // 说明：这里虽然加入顺序是“右”->“左”，但弹出遍历是“左”->“右”，符合“根”->“左”->“右”的前序遍历
            // 先加入右节点，在栈尾，所以每次后遍历这个节点值，就相当于前序遍历的“右”
            if (node.right != null) {
                stack.push(node.right);
            }
            // 后加入左节点，在栈顶，所以每次先遍历这个节点值，就相当于前序遍历的“左”
            if (node.left != null) {
                stack.push(node.left);
            }
        }
        // 直接返回结果数组
        return res;
    }

}
