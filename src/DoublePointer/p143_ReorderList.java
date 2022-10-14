package DoublePointer;

public class p143_ReorderList {

    int val;
    p143_ReorderList next;

    p143_ReorderList() {
    }

    p143_ReorderList(int val) {
        this.val = val;
    }

    p143_ReorderList(int val, p143_ReorderList next) {
        this.val = val;
        this.next = next;
    }

    public static void main(String[] args) {
        p143_ReorderList l1 = new p143_ReorderList(1);
        p143_ReorderList l2 = new p143_ReorderList(2);
        p143_ReorderList l3 = new p143_ReorderList(3);
        p143_ReorderList l4 = new p143_ReorderList(4);
        l1.next = l2;
        l2.next = l3;
        l3.next = l4;
        l4.next = null;
        reorderList(l1);
        p143_ReorderList cur = l1;
        while (cur != null) {
            System.out.print(cur.val + " ");
            cur = cur.next;
        }
    }

    public static void reorderList(p143_ReorderList head) {
        p143_ReorderList slow = head;
        p143_ReorderList fast = head;
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        p143_ReorderList l1 = head;
        p143_ReorderList l2 = slow.next;
        slow.next = null;
        l2 = reverse(l2);
        merge(l1, l2);
    }

    public static p143_ReorderList reverse(p143_ReorderList head) {
        p143_ReorderList pre = null;
        p143_ReorderList cur = head;
        while (cur != null) {
            p143_ReorderList temp = cur.next;
            cur.next = pre;
            pre = cur;
            cur = temp;
        }
        return pre;
    }

    public static void merge(p143_ReorderList l1, p143_ReorderList l2) {
        p143_ReorderList temp1;
        p143_ReorderList temp2;
        while (l1 != null && l2 != null) {
            temp1 = l1.next;
            temp2 = l2.next;
            l1.next = l2;
            l1 = temp1;
            l2.next = l1;
            l2 = temp2;
        }
    }

}
