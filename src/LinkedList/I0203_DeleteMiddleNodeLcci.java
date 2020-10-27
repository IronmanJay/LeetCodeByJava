package LinkedList;

public class I0203_DeleteMiddleNodeLcci {

    int val;
    I0203_DeleteMiddleNodeLcci next;

    I0203_DeleteMiddleNodeLcci(int x) {
        val = x;
    }

    public static void main(String[] args) {
        I0203_DeleteMiddleNodeLcci first = new I0203_DeleteMiddleNodeLcci(4);
        I0203_DeleteMiddleNodeLcci second = new I0203_DeleteMiddleNodeLcci(5);
        I0203_DeleteMiddleNodeLcci third = new I0203_DeleteMiddleNodeLcci(1);
        I0203_DeleteMiddleNodeLcci forth = new I0203_DeleteMiddleNodeLcci(9);
        first.next = second;
        second.next = third;
        third.next = forth;
        deleteNode(second);
        while (first != null) {
            if (first.next == null) {
                System.out.print(first.val);
            } else {
                System.out.print(first.val + "->");
            }
            first = first.next;
        }
    }

    public static void deleteNode(I0203_DeleteMiddleNodeLcci node) {
        // 将当前待删除节点的值变为下一个节点的值
        node.val = node.next.val;
        // 将当前待删除节点的下一个指向指向为下一个的下一个，总结就是自己变成了别人，就有了两个一样的，去重即可
        node.next = node.next.next;
    }

}
