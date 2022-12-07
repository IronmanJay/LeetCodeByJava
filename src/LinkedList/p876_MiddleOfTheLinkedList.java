package LinkedList;

/**
 * @Author: IronmanJay
 * @Description: 876.链表的中间结点
 * @CreateTime: 2022-12-07  10:03
 */
public class p876_MiddleOfTheLinkedList {

    int val;
    p876_MiddleOfTheLinkedList next;

    public p876_MiddleOfTheLinkedList(int val) {
        this.val = val;
    }

    public p876_MiddleOfTheLinkedList(int val, p876_MiddleOfTheLinkedList next) {
        this.val = val;
        this.next = next;
    }

    public static void main(String[] args) {
        p876_MiddleOfTheLinkedList node1 = new p876_MiddleOfTheLinkedList(1);
        p876_MiddleOfTheLinkedList node2 = new p876_MiddleOfTheLinkedList(2);
        p876_MiddleOfTheLinkedList node3 = new p876_MiddleOfTheLinkedList(3);
        p876_MiddleOfTheLinkedList node4 = new p876_MiddleOfTheLinkedList(4);
        p876_MiddleOfTheLinkedList node5 = new p876_MiddleOfTheLinkedList(5);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        p876_MiddleOfTheLinkedList res = middleNode(node1);
        System.out.println("res = " + res.val);
    }

    public static p876_MiddleOfTheLinkedList middleNode(p876_MiddleOfTheLinkedList head) {
        p876_MiddleOfTheLinkedList slow = head;
        p876_MiddleOfTheLinkedList fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

}


