package LinkedList;

public class p234_PalindromicLinkedList {

    int val;
    p234_PalindromicLinkedList next;

    public p234_PalindromicLinkedList() {
    }

    public p234_PalindromicLinkedList(int val) {
        this.val = val;
    }

    public p234_PalindromicLinkedList(int val, p234_PalindromicLinkedList next) {
        this.val = val;
        this.next = next;
    }

    public static void main(String[] args) {
        p234_PalindromicLinkedList node1 = new p234_PalindromicLinkedList(1);
        p234_PalindromicLinkedList node2 = new p234_PalindromicLinkedList(2);
        p234_PalindromicLinkedList node3 = new p234_PalindromicLinkedList(2);
        p234_PalindromicLinkedList node4 = new p234_PalindromicLinkedList(1);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        boolean res = isPalindrome(node1);
        System.out.println(res);
    }

    public static boolean isPalindrome(p234_PalindromicLinkedList head) {
        p234_PalindromicLinkedList slow = head, fast = head, pre = null, temp = null;
        while (fast != null) {
            slow = slow.next;
            fast = fast.next != null ? fast.next.next : fast.next;
        }
        while (slow != null) {
            temp = slow.next;
            slow.next = pre;
            pre = slow;
            slow = temp;
        }
        while (head != null && pre != null) {
            if (head.val != pre.val) {
                return false;
            }
            head = head.next;
            pre = pre.next;
        }
        return true;
    }

}
