package BFS;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class p429_NAryTreeLevelOrderTraversal {

    public int val;
    public List<p429_NAryTreeLevelOrderTraversal> children;

    public p429_NAryTreeLevelOrderTraversal() {

    }

    public p429_NAryTreeLevelOrderTraversal(int _val) {
        val = _val;
    }

    public p429_NAryTreeLevelOrderTraversal(int _val, List<p429_NAryTreeLevelOrderTraversal> _children) {
        val = _val;
        children = _children;
    }

    public static void main(String[] args) {
        p429_NAryTreeLevelOrderTraversal one = new p429_NAryTreeLevelOrderTraversal(1);
        p429_NAryTreeLevelOrderTraversal two = new p429_NAryTreeLevelOrderTraversal(2);
        p429_NAryTreeLevelOrderTraversal three = new p429_NAryTreeLevelOrderTraversal(3);
        p429_NAryTreeLevelOrderTraversal four = new p429_NAryTreeLevelOrderTraversal(4);
        p429_NAryTreeLevelOrderTraversal five = new p429_NAryTreeLevelOrderTraversal(5);
        p429_NAryTreeLevelOrderTraversal six = new p429_NAryTreeLevelOrderTraversal(6);
        List<p429_NAryTreeLevelOrderTraversal> second = new ArrayList<>();
        second.add(three);
        second.add(two);
        second.add(four);
        List<p429_NAryTreeLevelOrderTraversal> third = new ArrayList<>();
        third.add(five);
        third.add(six);
        three.children = third;
        p429_NAryTreeLevelOrderTraversal root = new p429_NAryTreeLevelOrderTraversal(1, second);
        List<List<Integer>> res = levelOrder(root);
        System.out.println("res = " + res);
    }

    public static List<List<Integer>> levelOrder(p429_NAryTreeLevelOrderTraversal root) {
        // 结果数组
        List<List<Integer>> res = new ArrayList<>();
        // 判空返回
        if (root == null) {
            return res;
        }
        // 存放每一层节点的队列
        Queue<p429_NAryTreeLevelOrderTraversal> queue = new LinkedList<>();
        // 头结点入队列
        queue.add(root);
        // 开始循环
        while (!queue.isEmpty()) {
            // 临时数组存放当前这一层的节点值
            List<Integer> temp = new ArrayList<>();
            // 当前这一层的节点个数
            int size = queue.size();
            // 当前这一层有几个节点就循环几次，循环到每一个节点的同时将将节点值加入到临时数组中，另外将每一个节点的孩子节点入队列，因为只遍历队列中当前层的节点，所以对孩子（下一层）的节点不构成影响
            for (int i = 0; i < size; i++) {
                p429_NAryTreeLevelOrderTraversal node = queue.poll();
                temp.add(node.val);
                if (node.children != null) {
                    if (!node.children.isEmpty()) {
                        for (p429_NAryTreeLevelOrderTraversal n : node.children) {
                            queue.add(n);
                        }
                    }
                }
            }
            // 将这一层的节点值加入到结果数组
            res.add(temp);
        }
        // 返回结果
        return res;
    }

}
