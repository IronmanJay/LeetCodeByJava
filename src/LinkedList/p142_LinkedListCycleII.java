package LinkedList;

/**
 * @Author: IronmanJay
 * @Description: 142.环形链表 II
 * @CreateTime: 2022-12-09  14:21
 */
public class p142_LinkedListCycleII {

    int val;
    p142_LinkedListCycleII next;

    public p142_LinkedListCycleII(int val) {
        this.val = val;
    }

    public p142_LinkedListCycleII(int val, p142_LinkedListCycleII next) {
        this.val = val;
        this.next = next;
    }

    public static void main(String[] args) {
        p142_LinkedListCycleII node1 = new p142_LinkedListCycleII(3);
        p142_LinkedListCycleII node2 = new p142_LinkedListCycleII(2);
        p142_LinkedListCycleII node3 = new p142_LinkedListCycleII(0);
        p142_LinkedListCycleII node4 = new p142_LinkedListCycleII(-4);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node2;
        p142_LinkedListCycleII res = detectCycle(node1);
        System.out.println("res = " + res.val);
    }

    public static p142_LinkedListCycleII detectCycle(p142_LinkedListCycleII head) {
        p142_LinkedListCycleII slow = head;
        p142_LinkedListCycleII fast = head;
        while (true) {
            if (fast == null || fast.next == null) {
                return null;
            }
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {
                break;
            }
        }
        fast = head;
        while (fast != slow) {
            slow = slow.next;
            fast = fast.next;
        }
        return fast;
    }

}
