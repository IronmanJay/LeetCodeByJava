package Graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class p133_CloneGraph {

    public int val;
    public List<p133_CloneGraph> neighbors;

    public p133_CloneGraph() {
        val = 0;
        neighbors = new ArrayList<p133_CloneGraph>();
    }

    public p133_CloneGraph(int _val) {
        val = _val;
        neighbors = new ArrayList<p133_CloneGraph>();
    }

    public p133_CloneGraph(int _val, ArrayList<p133_CloneGraph> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }

    public static void main(String[] args) {
        p133_CloneGraph node1 = new p133_CloneGraph(1);
        p133_CloneGraph node2 = new p133_CloneGraph(2);
        p133_CloneGraph node3 = new p133_CloneGraph(3);
        p133_CloneGraph node4 = new p133_CloneGraph(4);
        ArrayList<p133_CloneGraph> node1List = new ArrayList<>();
        node1List.add(node2);
        node1List.add(node4);
        node1.neighbors = node1List;
        ArrayList<p133_CloneGraph> node2List = new ArrayList<>();
        node2List.add(node1);
        node2List.add(node3);
        node2.neighbors = node2List;
        ArrayList<p133_CloneGraph> node3List = new ArrayList<>();
        node3List.add(node2);
        node3List.add(node4);
        node3.neighbors = node3List;
        ArrayList<p133_CloneGraph> node4List = new ArrayList<>();
        node4List.add(node1);
        node4List.add(node3);
        node4.neighbors = node4List;
        p133_CloneGraph res = cloneGraph(node1);
        System.out.println("res = " + res);
    }

    public static p133_CloneGraph cloneGraph(p133_CloneGraph node) {
        // 判空返回
        if (node == null) {
            return node;
        }
        // 哈希表存储原结点的对应结点，判断是否访问过
        HashMap<p133_CloneGraph, p133_CloneGraph> visited = new HashMap<>();
        // 开始深度优先搜索
        p133_CloneGraph newGraph = DFS(node, visited);
        // 返回克隆图
        return newGraph;
    }

    public static p133_CloneGraph DFS(p133_CloneGraph node, HashMap<p133_CloneGraph, p133_CloneGraph> visited) {
        // 因为图是简单无向图，如果原结点存在对应结点，说明此结点已经访问过，这就是跳出递归的条件，避免死循环，说明在这次递归中将图遍历了一遍
        if (visited.containsKey(node)) {
            return visited.get(node);
        }
        // 因为是深拷贝，所以邻居需要挨个添加，而不是直接复制
        p133_CloneGraph newNode = new p133_CloneGraph(node.val, new ArrayList<>());
        // 此节点克隆之后置为已经访问过
        visited.put(node, newNode);
        // 加入当前结点的全部邻居结点
        for (p133_CloneGraph neighbor : node.neighbors) {
            newNode.neighbors.add(DFS(neighbor, visited));
        }
        // 返回此次递归的结果
        return newNode;
    }

}
