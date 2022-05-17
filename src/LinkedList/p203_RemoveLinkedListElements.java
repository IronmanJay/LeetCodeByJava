package LinkedList;

public class p203_RemoveLinkedListElements {

    int val;
    p203_RemoveLinkedListElements next;

    public p203_RemoveLinkedListElements() {
    }

    public p203_RemoveLinkedListElements(int val) {
        this.val = val;
    }

    public p203_RemoveLinkedListElements(int val, p203_RemoveLinkedListElements next) {
        this.val = val;
        this.next = next;
    }

    public static void main(String[] args) {
        p203_RemoveLinkedListElements node1 = new p203_RemoveLinkedListElements(1);
        p203_RemoveLinkedListElements node2 = new p203_RemoveLinkedListElements(2);
        p203_RemoveLinkedListElements node3 = new p203_RemoveLinkedListElements(6);
        p203_RemoveLinkedListElements node4 = new p203_RemoveLinkedListElements(3);
        p203_RemoveLinkedListElements node5 = new p203_RemoveLinkedListElements(4);
        p203_RemoveLinkedListElements node6 = new p203_RemoveLinkedListElements(5);
        p203_RemoveLinkedListElements node7 = new p203_RemoveLinkedListElements(6);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        node5.next = node6;
        node6.next = node7;
        node7.next = null;
        p203_RemoveLinkedListElements res = removeElements(node1, 6);
        while (res != null) {
            if (res.next != null) {
                System.out.print(res.val + "->");
            } else {
                System.out.print(res.val);
            }
            res = res.next;
        }
    }

    public static p203_RemoveLinkedListElements removeElements(p203_RemoveLinkedListElements head, int val) {
        p203_RemoveLinkedListElements fakeNode = new p203_RemoveLinkedListElements(-1);
        fakeNode.next = head;
        p203_RemoveLinkedListElements p = fakeNode;
        while (p.next != null) {
            if (p.next.val == val) {
                p.next = p.next.next;
            } else {
                p = p.next;
            }
        }
        return fakeNode.next;
    }

}
