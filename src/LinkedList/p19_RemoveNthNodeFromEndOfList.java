package LinkedList;

public class p19_RemoveNthNodeFromEndOfList {

    int val;
    p19_RemoveNthNodeFromEndOfList next;

    p19_RemoveNthNodeFromEndOfList() {

    }

    p19_RemoveNthNodeFromEndOfList(int val) {
        this.val = val;
    }

    p19_RemoveNthNodeFromEndOfList(int val, p19_RemoveNthNodeFromEndOfList next) {
        this.val = val;
        this.next = next;
    }

    public static void main(String[] args) {
        p19_RemoveNthNodeFromEndOfList first = new p19_RemoveNthNodeFromEndOfList(1);
        p19_RemoveNthNodeFromEndOfList second = new p19_RemoveNthNodeFromEndOfList(2);
        p19_RemoveNthNodeFromEndOfList third = new p19_RemoveNthNodeFromEndOfList(3);
        p19_RemoveNthNodeFromEndOfList forth = new p19_RemoveNthNodeFromEndOfList(4);
        p19_RemoveNthNodeFromEndOfList fifth = new p19_RemoveNthNodeFromEndOfList(5);
        first.next = second;
        second.next = third;
        third.next = forth;
        forth.next = fifth;
        int n = 2;
        p19_RemoveNthNodeFromEndOfList res = removeNthFromEnd(first, n);
        while (res != null) {
            if (res.next != null) {
                System.out.print(res.val + "->");
            } else {
                System.out.print(res.val);
            }
            res = res.next;
        }
    }

    public static p19_RemoveNthNodeFromEndOfList removeNthFromEnd(p19_RemoveNthNodeFromEndOfList head, int n) {
        // 头节点前的节点
        p19_RemoveNthNodeFromEndOfList newHead = new p19_RemoveNthNodeFromEndOfList(0, head);
        // 快指针，赋值为头节点，保证一直和慢指针相差n个节点
        p19_RemoveNthNodeFromEndOfList fast = head;
        // 慢指针，赋值为头节点前的节点，目的是当快指针指向尾节点之后的位置时，慢指针指向待删除节点的前一个节点
        p19_RemoveNthNodeFromEndOfList slow = newHead;
        // 找到快指针和慢指针相差n个节点的位置
        for (int i = 0; i < n; i++) {
            fast = fast.next;
        }
        // 当快指针指向尾节点之后的位置时，慢指针指向待删除节点的前一个节点
        while (fast != null) {
            slow = slow.next;
            fast = fast.next;
        }
        // 此时慢指针指向了待删除结点的前一个节点吗，那么删除待删除节点
        slow.next = slow.next.next;
        // 返回结果
        return newHead.next;
    }

}
