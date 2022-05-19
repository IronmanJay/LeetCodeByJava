package LinkedList;

public class p160_IntersectingLinkedLists {

    int val;
    p160_IntersectingLinkedLists next;

    public p160_IntersectingLinkedLists() {
    }

    public p160_IntersectingLinkedLists(int val) {
        this.val = val;
    }

    public p160_IntersectingLinkedLists(int val, p160_IntersectingLinkedLists next) {
        this.val = val;
        this.next = next;
    }

    public static void main(String[] args) {
        p160_IntersectingLinkedLists nodeA1 = new p160_IntersectingLinkedLists(1);
        p160_IntersectingLinkedLists nodeA2 = new p160_IntersectingLinkedLists(9);
        p160_IntersectingLinkedLists nodeA3 = new p160_IntersectingLinkedLists(1);
        p160_IntersectingLinkedLists nodeC1 = new p160_IntersectingLinkedLists(2);
        p160_IntersectingLinkedLists nodeC2 = new p160_IntersectingLinkedLists(4);
        p160_IntersectingLinkedLists nodeB1 = new p160_IntersectingLinkedLists(3);
        nodeA1.next = nodeA2;
        nodeA2.next = nodeA3;
        nodeA3.next = nodeC1;
        nodeC1.next = nodeC2;
        nodeB1.next = nodeC1;
        p160_IntersectingLinkedLists res = getIntersectionNode(nodeA1, nodeB1);
        System.out.println("Intersected at:" + res.val);
    }

    public static p160_IntersectingLinkedLists getIntersectionNode(p160_IntersectingLinkedLists headA, p160_IntersectingLinkedLists headB) {
        p160_IntersectingLinkedLists p = headA, q = headB;
        int lenA = 0, lenB = 0, sub;
        while (p != null) {
            lenA++;
            p = p.next;
        }
        while (q != null) {
            lenB++;
            q = q.next;
        }
        p = headA;
        q = headB;
        sub = (lenA - lenB) >= 0 ? lenA - lenB : lenB - lenA;
        if (lenA > lenB) {
            while (sub != 0) {
                p = p.next;
                sub--;
            }
        } else {
            while (sub != 0) {
                q = q.next;
                sub--;
            }
        }
        while (p != null && q != null) {
            if (p == q) {
                return p;
            }
            p = p.next;
            q = q.next;
        }
        return null;
    }
}

