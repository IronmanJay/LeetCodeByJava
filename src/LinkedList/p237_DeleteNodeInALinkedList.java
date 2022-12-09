package LinkedList;

/**
 * @Author: IronmanJay
 * @Description: 237.删除链表中的节点
 * @CreateTime: 2022-12-09  15:32
 */
public class p237_DeleteNodeInALinkedList {

    int val;
    p237_DeleteNodeInALinkedList next;

    public p237_DeleteNodeInALinkedList(int val) {
        this.val = val;
    }

    public p237_DeleteNodeInALinkedList(int val, p237_DeleteNodeInALinkedList next) {
        this.val = val;
        this.next = next;
    }

    public static void main(String[] args) {
        p237_DeleteNodeInALinkedList node1 = new p237_DeleteNodeInALinkedList(4);
        p237_DeleteNodeInALinkedList node2 = new p237_DeleteNodeInALinkedList(5);
        p237_DeleteNodeInALinkedList node3 = new p237_DeleteNodeInALinkedList(1);
        p237_DeleteNodeInALinkedList node4 = new p237_DeleteNodeInALinkedList(9);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        deleteNode(node2);
        p237_DeleteNodeInALinkedList p = node1;
        while (p != null) {
            if (p.next == null) {
                System.out.print(p.val);
            } else {
                System.out.print(p.val + "->");
            }
            p = p.next;
        }
    }

    public static void deleteNode(p237_DeleteNodeInALinkedList node) {
        node.val = node.next.val;
        node.next = node.next.next;
    }

}
