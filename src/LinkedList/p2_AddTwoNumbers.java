package LinkedList;

public class p2_AddTwoNumbers {

    int val;
    p2_AddTwoNumbers next;

    public p2_AddTwoNumbers() {
    }

    public p2_AddTwoNumbers(int val) {
        this.val = val;
    }

    public p2_AddTwoNumbers(int val, p2_AddTwoNumbers next) {
        this.val = val;
        this.next = next;
    }

    public static void main(String[] args) {
        p2_AddTwoNumbers node1_1 = new p2_AddTwoNumbers(2);
        p2_AddTwoNumbers node1_2 = new p2_AddTwoNumbers(4);
        p2_AddTwoNumbers node1_3 = new p2_AddTwoNumbers(3);
        p2_AddTwoNumbers node2_1 = new p2_AddTwoNumbers(5);
        p2_AddTwoNumbers node2_2 = new p2_AddTwoNumbers(6);
        p2_AddTwoNumbers node2_3 = new p2_AddTwoNumbers(4);
        node1_1.next = node1_2;
        node1_2.next = node1_3;
        node2_1.next = node2_2;
        node2_2.next = node2_3;
        p2_AddTwoNumbers res = addTwoNumbers(node1_1, node2_1);
        while (res != null) {
            if (res.next != null) {
                System.out.print(res.val + "->");
            } else {
                System.out.print(res.val);
            }
            res = res.next;
        }
    }

    public static p2_AddTwoNumbers addTwoNumbers(p2_AddTwoNumbers l1, p2_AddTwoNumbers l2) {
        p2_AddTwoNumbers fakeNode = new p2_AddTwoNumbers(-1);
        p2_AddTwoNumbers curNode = fakeNode;
        int carry = 0;
        while (l1 != null || l2 != null) {
            int x = (l1 == null) ? 0 : l1.val;
            int y = (l2 == null) ? 0 : l2.val;
            int sum = x + y + carry;
            carry = sum / 10;
            sum %= 10;
            curNode.next = new p2_AddTwoNumbers(sum);
            curNode = curNode.next;
            if (l1 != null) {
                l1 = l1.next;
            }
            if (l2 != null) {
                l2 = l2.next;
            }
        }
        if (carry > 0) {
            curNode.next = new p2_AddTwoNumbers(carry);
            curNode = curNode.next;
        }
        return fakeNode.next;
    }

}
