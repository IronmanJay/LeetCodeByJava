package DivideAndConquerAlgorithm;

public class o36_BinarySearchTreeAndDoublyLinkedList {

    public int val;
    public o36_BinarySearchTreeAndDoublyLinkedList left;
    public o36_BinarySearchTreeAndDoublyLinkedList right;

    public o36_BinarySearchTreeAndDoublyLinkedList() {

    }

    public o36_BinarySearchTreeAndDoublyLinkedList(int _val) {
        val = _val;
    }

    public o36_BinarySearchTreeAndDoublyLinkedList(int _val, o36_BinarySearchTreeAndDoublyLinkedList _left, o36_BinarySearchTreeAndDoublyLinkedList _right) {
        val = _val;
        left = _left;
        right = _right;
    }

    public static void main(String[] args) {
        o36_BinarySearchTreeAndDoublyLinkedList four = new o36_BinarySearchTreeAndDoublyLinkedList(4);
        o36_BinarySearchTreeAndDoublyLinkedList two = new o36_BinarySearchTreeAndDoublyLinkedList(2);
        o36_BinarySearchTreeAndDoublyLinkedList five = new o36_BinarySearchTreeAndDoublyLinkedList(5);
        o36_BinarySearchTreeAndDoublyLinkedList one = new o36_BinarySearchTreeAndDoublyLinkedList(1);
        o36_BinarySearchTreeAndDoublyLinkedList three = new o36_BinarySearchTreeAndDoublyLinkedList(3);
        four.left = two;
        four.right = five;
        two.left = one;
        two.right = three;
        o36_BinarySearchTreeAndDoublyLinkedList res = treeToDoublyList(four);
        int count = 1;
        while (res != null && count <= 5) {
            System.out.print(res.val + " ");
            res = res.right;
            count++;
        }
    }

    public static o36_BinarySearchTreeAndDoublyLinkedList treeToDoublyList(o36_BinarySearchTreeAndDoublyLinkedList root) {
        // 判空返回
        if (root == null) {
            return null;
        }
        /*整个树的头尾结点*/
        o36_BinarySearchTreeAndDoublyLinkedList[] nodeList = new o36_BinarySearchTreeAndDoublyLinkedList[2];
        nodeList = build(root);
        /*尾结点的后继指针指向头结点*/
        nodeList[1].right = nodeList[0];
        /*头结点的前驱指针指向尾结点*/
        nodeList[0].left = nodeList[1];
        /*返回头结点*/
        return nodeList[0];
    }

    public static o36_BinarySearchTreeAndDoublyLinkedList[] build(o36_BinarySearchTreeAndDoublyLinkedList root) {
        /*保存左子树的头尾结点*/
        o36_BinarySearchTreeAndDoublyLinkedList[] nodeLeft = new o36_BinarySearchTreeAndDoublyLinkedList[2];
        /*保存右子树的头尾结点*/
        o36_BinarySearchTreeAndDoublyLinkedList[] nodeRight = new o36_BinarySearchTreeAndDoublyLinkedList[2];
        /*保存整棵树的头尾结点*/
        o36_BinarySearchTreeAndDoublyLinkedList[] nodeRoot = new o36_BinarySearchTreeAndDoublyLinkedList[2];
        /*如果是叶子节点，自己作为链表直接返回*/
        if (root.left == null && root.right == null) {
            nodeRoot[0] = root;
            nodeRoot[1] = root;
            return nodeRoot;
        }
        /*如果左子树不为空，递归遍历左子树，开始建立树，可以理解为中序遍历，二叉搜索树给我们提供这种便利，也可以理解为分治的开始*/
        if (root.left != null) {
            nodeLeft = build(root.left);
        }
        /*如果左子树为空，那么头结点就是当前状态链表的最大值，所以设置当前链表的头结点就是根节点，并且作为标志，方便后续建立关系*/
        else {
            nodeLeft[0] = root;
        }
        /*如果左子树不为空，递归遍历左子树，继续建立树*/
        if (root.right != null) {
            nodeRight = build(root.right);
        }
        /*如果右子树为空，那么头结点就是当前状态链表的最小值，所以设置当前链表的尾结点就是根节点，并且作为标志，方便后续建立关系*/
        else {
            nodeRight[1] = root;
        }
        /*如果左子树不为空，将根节点前驱指针指向左子树链表的尾部，将左子树链表的尾部的后继结点指向根节点*/
        if (nodeLeft[0] != root) {
            root.left = nodeLeft[1];
            nodeLeft[1].right = root;
        }
        /*如果右子树不为空，将根节点后继指针指向右子树链表的头部，将右子树链表的头部的前驱结点指向根节点*/
        if (nodeRight[1] != root) {
            root.right = nodeRight[0];
            nodeRight[0].left = root;
        }
        /*返回当前状态链表的头尾结点*/
        nodeRoot[0] = nodeLeft[0];
        nodeRoot[1] = nodeRight[1];
        return nodeRoot;
    }

}
