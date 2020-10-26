package LinkedList;

public class I0206_PalindromeLinkedListLcci {

    int val;

    I0206_PalindromeLinkedListLcci next;

    I0206_PalindromeLinkedListLcci(int x) {

    }

    public static void main(String[] args) {
        I0206_PalindromeLinkedListLcci first = new I0206_PalindromeLinkedListLcci(1);
        I0206_PalindromeLinkedListLcci second = new I0206_PalindromeLinkedListLcci(2);
        I0206_PalindromeLinkedListLcci third = new I0206_PalindromeLinkedListLcci(2);
        I0206_PalindromeLinkedListLcci forth = new I0206_PalindromeLinkedListLcci(1);
        first.next = second;
        second.next = third;
        third.next = forth;
        boolean res = isPalindrome(first);
        System.out.println("res = " + res);
    }

    public static boolean isPalindrome(I0206_PalindromeLinkedListLcci head) {
        // 判空返回
        if (head == null) {
            return true;
        }
        // 慢指针
        I0206_PalindromeLinkedListLcci slow = head;
        // 快指针
        I0206_PalindromeLinkedListLcci fast = head;
        // 前半段链表指针
        I0206_PalindromeLinkedListLcci preNode = null;
        // 临时节点
        I0206_PalindromeLinkedListLcci newNode = null;
        // 找到中间节点的同时并反转前半段链表
        while (fast != null && fast.next != null) {
            newNode = slow;
            slow = slow.next;
            fast = fast.next.next;
            newNode.next = preNode;
            preNode = newNode;
        }
        // 如果链表长度为奇数，不考虑中间节点，直接从后半段开始
        if (fast != null) {
            slow = slow.next;
        }
        // 比较前半段和后半段，如果有不一样的就返回false
        while (slow != null) {
            if (preNode.val != slow.val) {
                return false;
            }
            preNode = preNode.next;
            slow = slow.next;
        }
        // 如果都一样返回true
        return true;
    }

}
