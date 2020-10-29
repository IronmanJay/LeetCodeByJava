package LinkedList;

public class p86_PartitionList {

    int val;
    p86_PartitionList next;

    p86_PartitionList(int x) {
        val = x;
    }

    public static void main(String[] args) {
        p86_PartitionList first = new p86_PartitionList(1);
        p86_PartitionList second = new p86_PartitionList(4);
        p86_PartitionList third = new p86_PartitionList(3);
        p86_PartitionList forth = new p86_PartitionList(2);
        p86_PartitionList fifth = new p86_PartitionList(5);
        p86_PartitionList sixth = new p86_PartitionList(2);
        first.next = second;
        second.next = third;
        third.next = forth;
        forth.next = fifth;
        fifth.next = sixth;
        int x = 3;
        p86_PartitionList res = partition(first, x);
        while (res != null) {
            if (res.next != null) {
                System.out.print(res.val + "->");
            } else {
                System.out.print(res.val);
            }
            res = res.next;
        }
    }

    public static p86_PartitionList partition(p86_PartitionList head, int x) {
        // 存储比x的值小的链表
        p86_PartitionList newHead1 = new p86_PartitionList(0);
        // 存储比x的值小的链表的指针
        p86_PartitionList curNode1 = newHead1;
        // 存储比x的值大或者相等的链表
        p86_PartitionList newHead2 = new p86_PartitionList(0);
        // 存储比x的值大或者相等的链表的指针
        p86_PartitionList curNode2 = newHead2;
        // 开始遍历
        while (head != null) {
            // 如果当前值比x的值小，使用newHead1存储这些比x的值小的节点
            if (head.val < x) {
                curNode1.next = head;
                // 注意这里要先将原链表指针向下移动，否则新的链表指针将原链表断开，遍历失败
                head = head.next;
                curNode1 = curNode1.next;
                curNode1.next = null;
            }
            // 如果当前值比x的值小，使用newHead2存储这些比x的值大或者相等的节点
            else {
                curNode2.next = head;
                // 注意这里要先将原链表指针向下移动，否则新的链表指针将原链表断开，遍历失败
                head = head.next;
                curNode2 = curNode2.next;
                curNode2.next = null;
            }
        }
        // 将存储比x的值小的链表连接到存储比x的值大或者相等的链表
        curNode1.next = newHead2.next;
        // 返回结果
        return newHead1.next;
    }

}
