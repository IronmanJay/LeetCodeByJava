package Stack;

import java.util.ArrayDeque;
import java.util.Deque;

public class p445_AddingTwoNumbersII {

    int val;
    p445_AddingTwoNumbersII next;

    public p445_AddingTwoNumbersII(int val) {
        this.val = val;
    }

    public p445_AddingTwoNumbersII(int val, p445_AddingTwoNumbersII next) {
        this.val = val;
        this.next = next;
    }

    public static void main(String[] args) {
        p445_AddingTwoNumbersII l11 = new p445_AddingTwoNumbersII(7);
        p445_AddingTwoNumbersII l12 = new p445_AddingTwoNumbersII(2);
        p445_AddingTwoNumbersII l13 = new p445_AddingTwoNumbersII(4);
        p445_AddingTwoNumbersII l14 = new p445_AddingTwoNumbersII(3);
        p445_AddingTwoNumbersII l21 = new p445_AddingTwoNumbersII(5);
        p445_AddingTwoNumbersII l22 = new p445_AddingTwoNumbersII(6);
        p445_AddingTwoNumbersII l23 = new p445_AddingTwoNumbersII(4);
        l11.next = l12;
        l12.next = l13;
        l13.next = l14;
        l21.next = l22;
        l22.next = l23;
        p445_AddingTwoNumbersII res = addTwoNumbers(l11, l21);
        while (res != null) {
            if (res.next != null) {
                System.out.print(res.val + "->");
            } else {
                System.out.print(res.val);
            }
            res = res.next;
        }
    }

    public static p445_AddingTwoNumbersII addTwoNumbers(p445_AddingTwoNumbersII l1, p445_AddingTwoNumbersII l2) {
        Deque<Integer> stack1 = new ArrayDeque<Integer>();
        Deque<Integer> stack2 = new ArrayDeque<Integer>();
        int carry = 0;
        p445_AddingTwoNumbersII head = null;
        while (l1 != null) {
            stack1.push(l1.val);
            l1 = l1.next;
        }
        while (l2 != null) {
            stack2.push(l2.val);
            l2 = l2.next;
        }
        while (!stack1.isEmpty() || !stack2.isEmpty() || carry != 0) {
            int x = stack1.isEmpty() ? 0 : stack1.pop();
            int y = stack2.isEmpty() ? 0 : stack2.pop();
            int sum = x + y + carry;
            carry = sum / 10;
            p445_AddingTwoNumbersII temp = new p445_AddingTwoNumbersII(sum % 10);
            temp.next = head;
            head = temp;
        }
        return head;
    }

}
