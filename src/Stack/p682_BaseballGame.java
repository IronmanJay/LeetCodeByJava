package Stack;

public class p682_BaseballGame {

    public static void main(String[] args) {
        String[] ops = {"5", "2", "C", "D", "+"};
        int res = calPoints(ops);
        System.out.println("res = " + res);
    }

    public static int calPoints(String[] ops) {
        int[] stack = new int[ops.length];
        int top = 0;
        int res = 0;
        for (String op : ops) {
            switch (op.charAt(0)) {
                case '+':
                    int temp1 = stack[top - 1];
                    int temp2 = stack[top - 2];
                    stack[top++] = temp1 + temp2;
                    break;
                case 'D':
                    int temp = stack[top - 1] * 2;
                    stack[top++] = temp;
                    break;
                case 'C':
                    top--;
                    break;
                default:
                    stack[top++] = Integer.parseInt(op);
                    break;
            }
        }
        for (int i = 0; i < top; i++) {
            res += stack[i];
        }
        return res;
    }

}
