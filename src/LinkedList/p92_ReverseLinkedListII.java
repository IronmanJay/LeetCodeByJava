package LinkedList;

public class p92_ReverseLinkedListII {

    int val;
    p92_ReverseLinkedListII next;

    p92_ReverseLinkedListII(int x) {
        val = x;
    }

    public static void main(String[] args) {
        int m = 2;
        int n = 4;
        p92_ReverseLinkedListII first = new p92_ReverseLinkedListII(1);
        p92_ReverseLinkedListII second = new p92_ReverseLinkedListII(2);
        p92_ReverseLinkedListII third = new p92_ReverseLinkedListII(3);
        p92_ReverseLinkedListII forth = new p92_ReverseLinkedListII(4);
        p92_ReverseLinkedListII fifth = new p92_ReverseLinkedListII(5);
        first.next = second;
        second.next = third;
        third.next = forth;
        forth.next = fifth;
        p92_ReverseLinkedListII res = reverseBetween(first, m, n);
        while (res != null) {
            if (res.next == null) {
                System.out.print(res.val);
            } else {
                System.out.print(res.val + "->");
            }
            res = res.next;
        }
    }

    public static p92_ReverseLinkedListII reverseBetween(p92_ReverseLinkedListII head, int m, int n) {
        // 指向头结点的节点
        p92_ReverseLinkedListII newHeah = new p92_ReverseLinkedListII(0);
        newHeah.next = head;
        // 待反转部分首位的前驱节点，一直指向待反转的部分的首位
        p92_ReverseLinkedListII pre = newHeah;
        // 找到待反转部分首位的前驱位置
        for (int i = 1; i < m; i++) {
            pre = pre.next;
        }
        // 待反转部分的起始节点，也是待反转部分的指针，一直向后移动
        p92_ReverseLinkedListII start = pre.next;
        // 遍历待反转部分
        for (int i = m; i < n; i++) {
            // 每次遍历都找到start的下一个节点，也就是要插入到前面（头部）的节点
            p92_ReverseLinkedListII curNext = start.next;
            // 重新指向start的下一个节点为要插入到前面（头部）的节点的下一个节点，此时要插入到前面（头部）的节点已经分离
            start.next = curNext.next;
            // 开始插入到前面（头部）
            curNext.next = pre.next;
            // 待反转部分首位的前驱节点一直指向待反转的部分的首位
            pre.next = curNext;
        }
        // 返回整个链表的头结点
        return newHeah.next;
    }

}
