package DFS;

import java.util.LinkedList;

public class p1028_RecoverATreeFromPreorderTraversal {

    int val;
    p1028_RecoverATreeFromPreorderTraversal left;
    p1028_RecoverATreeFromPreorderTraversal right;

    p1028_RecoverATreeFromPreorderTraversal(int x) {
        val = x;
    }

    public static void main(String[] args) {
        String S = "1-2--3--4-5--6--7";
        p1028_RecoverATreeFromPreorderTraversal res = recoverFromPreorder(S);
        List(res);
    }

    // 二叉树层序遍历
    public static void List(p1028_RecoverATreeFromPreorderTraversal root) {
        // 将根节点赋给临时结点
        p1028_RecoverATreeFromPreorderTraversal node = root;
        // 使用队列
        LinkedList<p1028_RecoverATreeFromPreorderTraversal> list = new LinkedList<>();
        // 将根节点加入队列
        list.add(node);
        // 当队列不空的时候，取出队列第一个元素，并打印
        while (!list.isEmpty()) {
            node = list.poll();
            System.out.print(node.val + " ");
            // 如果当前节点的左子节点不空，将当前节点的左子节点加入队列，下一次循环第一个出来
            if (node.left != null) {
                list.offer(node.left);
            }
            // 如果当前节点的右子节点不空，将当前节点的右子节点加入队列，下一次循环第二个出来
            if (node.right != null) {
                list.offer(node.right);
            }
        }
    }

    // 全局变量，index总是指向当前节点在数组中的下一个位置
    private static int index = 0;

    public static p1028_RecoverATreeFromPreorderTraversal recoverFromPreorder(String S) {
        // 从深度为0开始遍历
        return getTree(S, 0);
    }

    public static p1028_RecoverATreeFromPreorderTraversal getTree(String S, int depth) {
        // level表示树的深度
        int level = 0;
        // 获取当前节点的深度，这里要从index+level开始，表示从上一个节点的下一个位置开始找
        while (index + level < S.length() && S.charAt(index + level) == '-') {
            level++;
        }
        // 如果得到的深度和传入的深度不同，直接返回，这种情况就是到某一个叶子节点了
        if (level != depth) {
            return null;
        }
        // 获取当前节点在数组中的位置，就是上一个节点在数组中的下一个位置+遍历到的当前节点的深度
        int nextNode = index + level;
        // 这里因为下一步需要切割，所以需要获取到当前节点的下一个位置
        while (nextNode < S.length() && S.charAt(nextNode) != '-') {
            nextNode++;
        }
        // 从当前节点的位置切割到当前节点的下一个位置，也就把当前节点的值切割下来了
        int curValue = Integer.parseInt(S.substring(index + level, nextNode));
        // 更新index的值为当前节点在数组中的下一个位置，方便下次遍历
        index = nextNode;
        // 创建新节点
        p1028_RecoverATreeFromPreorderTraversal root = new p1028_RecoverATreeFromPreorderTraversal(curValue);
        // 因为题目要求尽量生成左子节点，所以先递归左子节点，同时深度+1
        root.left = getTree(S, depth + 1);
        // 如果左子节点为空，那么右子节点也肯定为空，说明到了叶子节点
        if (root.left == null) {
            root.right = null;
        }
        // 如果左子节点不为空，那么继续递归右子节点，同时深度+1
        else {
            root.right = getTree(S, depth + 1);
        }
        // 返回根节点即可
        return root;
    }
}
