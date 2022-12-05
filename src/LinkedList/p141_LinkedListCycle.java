package LinkedList;

/**
 * @Author: IronmanJay
 * @Description: 141.环形链表
 * @CreateTime: 2022-12-05  15:39
 */
public class p141_LinkedListCycle {

    int val;
    p141_LinkedListCycle next;

    public p141_LinkedListCycle(int val) {
        this.val = val;
    }

    public p141_LinkedListCycle(int val, p141_LinkedListCycle next) {
        this.val = val;
        this.next = next;
    }

    public static void main(String[] args) {
        p141_LinkedListCycle node1 = new p141_LinkedListCycle(3);
        p141_LinkedListCycle node2 = new p141_LinkedListCycle(2);
        p141_LinkedListCycle node3 = new p141_LinkedListCycle(0);
        p141_LinkedListCycle node4 = new p141_LinkedListCycle(-4);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node2;
        boolean res = hasCycle(node1);
        System.out.println("res = " + res);
    }

    public static boolean hasCycle(p141_LinkedListCycle head) {
        p141_LinkedListCycle slow = head;
        p141_LinkedListCycle fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {
                return true;
            }
        }
        return false;
    }

}
