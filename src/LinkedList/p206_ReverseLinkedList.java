package LinkedList;

public class p206_ReverseLinkedList {

    int val;
    p206_ReverseLinkedList next;

    public p206_ReverseLinkedList() {
    }

    public p206_ReverseLinkedList(int val) {
        this.val = val;
    }

    public p206_ReverseLinkedList(int val, p206_ReverseLinkedList next) {
        this.val = val;
        this.next = next;
    }

    public static void main(String[] args) {
        p206_ReverseLinkedList node1 = new p206_ReverseLinkedList(1);
        p206_ReverseLinkedList node2 = new p206_ReverseLinkedList(2);
        p206_ReverseLinkedList node3 = new p206_ReverseLinkedList(3);
        p206_ReverseLinkedList node4 = new p206_ReverseLinkedList(4);
        p206_ReverseLinkedList node5 = new p206_ReverseLinkedList(5);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        p206_ReverseLinkedList res = reverseList(node1);
        while (res != null) {
            if (res.next != null) {
                System.out.print(res.val + "->");
            } else {
                System.out.print(res.val);
            }
            res = res.next;
        }
    }

    public static p206_ReverseLinkedList reverseList(p206_ReverseLinkedList head) {
        if (head == null) {
            return head;
        }
        p206_ReverseLinkedList p = head;
        p206_ReverseLinkedList q = head.next;
        p206_ReverseLinkedList temp;
        p.next = null;
        while (q != null) {
            temp = q.next;
            q.next = p;
            p = q;
            q = temp;
        }
        return p;
    }

}
