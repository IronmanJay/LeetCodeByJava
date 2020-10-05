package BFS;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class p559_MaximumdepthOfNAryTree {

    public int val;
    public List<p559_MaximumdepthOfNAryTree> children;

    public p559_MaximumdepthOfNAryTree() {

    }

    public p559_MaximumdepthOfNAryTree(int _val) {
        val = _val;
    }

    public p559_MaximumdepthOfNAryTree(int _val, List<p559_MaximumdepthOfNAryTree> _children) {
        val = _val;
        children = _children;
    }

    public static void main(String[] args) {
        p559_MaximumdepthOfNAryTree one = new p559_MaximumdepthOfNAryTree(1);
        p559_MaximumdepthOfNAryTree two = new p559_MaximumdepthOfNAryTree(2);
        p559_MaximumdepthOfNAryTree three = new p559_MaximumdepthOfNAryTree(3);
        p559_MaximumdepthOfNAryTree four = new p559_MaximumdepthOfNAryTree(4);
        p559_MaximumdepthOfNAryTree five = new p559_MaximumdepthOfNAryTree(5);
        p559_MaximumdepthOfNAryTree six = new p559_MaximumdepthOfNAryTree(6);
        List<p559_MaximumdepthOfNAryTree> second = new ArrayList<>();
        second.add(three);
        second.add(two);
        second.add(four);
        List<p559_MaximumdepthOfNAryTree> third = new ArrayList<>();
        third.add(five);
        third.add(six);
        three.children = third;
        p559_MaximumdepthOfNAryTree root = new p559_MaximumdepthOfNAryTree(1, second);
        int res = maxDepth(root);
        System.out.println("res = " + res);
    }

    public static int maxDepth(p559_MaximumdepthOfNAryTree root) {
        // 判空返回
        if (root == null) {
            return 0;
        }
        // 树的深度（结果值）
        int depth = 0;
        // 存放每一层节点值的队列
        Queue<p559_MaximumdepthOfNAryTree> queue = new LinkedList<>();
        // 首先将根节点入队列
        queue.add(root);
        // 开始遍历
        while (!queue.isEmpty()) {
            // 当前层的节点个数
            int size = queue.size();
            // 当前层有几个节点就遍历几次
            for (int i = 0; i < size; i++) {
                // 依次取出（弹出）这一层的每一个节点
                p559_MaximumdepthOfNAryTree node = queue.poll();
                // 将下一层的所有节点入队列，因为此次遍历只会循环当前层的个数，所以对下一层没有影响，等待对下一层的遍历
                if (node.children != null) {
                    for (p559_MaximumdepthOfNAryTree n : node.children) {
                        queue.add(n);
                    }
                }
            }
            // 当前层遍历完之后树的层数+1
            depth++;
        }
        // 返回结果
        return depth;
    }

}
