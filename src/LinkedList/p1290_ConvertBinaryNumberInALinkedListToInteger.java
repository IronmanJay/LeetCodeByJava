package LinkedList;

/**
 * @Author: IronmanJay
 * @Description: 1290.二进制链表转整数
 * @CreateTime: 2022-12-06  13:10
 */
public class p1290_ConvertBinaryNumberInALinkedListToInteger {

    int val;
    p1290_ConvertBinaryNumberInALinkedListToInteger next;

    public p1290_ConvertBinaryNumberInALinkedListToInteger(int val) {
        this.val = val;
    }

    public p1290_ConvertBinaryNumberInALinkedListToInteger(int val, p1290_ConvertBinaryNumberInALinkedListToInteger next) {
        this.val = val;
        this.next = next;
    }

    public static void main(String[] args) {
        p1290_ConvertBinaryNumberInALinkedListToInteger node1 = new p1290_ConvertBinaryNumberInALinkedListToInteger(1);
        p1290_ConvertBinaryNumberInALinkedListToInteger node2 = new p1290_ConvertBinaryNumberInALinkedListToInteger(0);
        p1290_ConvertBinaryNumberInALinkedListToInteger node3 = new p1290_ConvertBinaryNumberInALinkedListToInteger(1);
        node1.next = node2;
        node2.next = node3;
        int res = getDecimalValue(node1);
        System.out.println("res = " + res);
    }

    public static int getDecimalValue(p1290_ConvertBinaryNumberInALinkedListToInteger head) {
        p1290_ConvertBinaryNumberInALinkedListToInteger p = head;
        int res = 0;
        while (p != null) {
            res = res * 2 + p.val;
            p = p.next;
        }
        return res;
    }

}
