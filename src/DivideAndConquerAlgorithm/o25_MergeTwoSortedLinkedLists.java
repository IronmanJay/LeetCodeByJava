package DivideAndConquerAlgorithm;

public class o25_MergeTwoSortedLinkedLists {

    int val;
    o25_MergeTwoSortedLinkedLists next;

    o25_MergeTwoSortedLinkedLists(int x) {
        val = x;
    }

    public static void main(String[] args) {
        o25_MergeTwoSortedLinkedLists list1Root = new o25_MergeTwoSortedLinkedLists(1);
        o25_MergeTwoSortedLinkedLists list1Node1 = new o25_MergeTwoSortedLinkedLists(2);
        o25_MergeTwoSortedLinkedLists list1Node2 = new o25_MergeTwoSortedLinkedLists(4);
        list1Root.next = list1Node1;
        list1Node1.next = list1Node2;
        o25_MergeTwoSortedLinkedLists list2Root = new o25_MergeTwoSortedLinkedLists(1);
        o25_MergeTwoSortedLinkedLists list2Node1 = new o25_MergeTwoSortedLinkedLists(3);
        o25_MergeTwoSortedLinkedLists list2Node2 = new o25_MergeTwoSortedLinkedLists(4);
        list2Root.next = list2Node1;
        list2Node1.next = list2Node2;
        o25_MergeTwoSortedLinkedLists res = mergeTwoLists(list1Root, list2Root);
        while (res != null) {
            if (res.next != null) {
                System.out.print(res.val + "->");
            } else {
                System.out.print(res.val);
            }
            res = res.next;
        }
    }

    public static o25_MergeTwoSortedLinkedLists mergeTwoLists(o25_MergeTwoSortedLinkedLists l1, o25_MergeTwoSortedLinkedLists l2) {
        // 因为有序，把有结点剩余的全部返回，这是递归结束条件
        if (l1 == null || l2 == null) {
            return l1 == null ? l2 : l1;
        }
        // 开始递归，谁小谁做头结点，第一次if判断的时候进入哪个哪个就是最终返回的头结点
        if (l1.val <= l2.val) {
            l1.next = mergeTwoLists(l1.next, l2);
            return l1;
        } else {
            l2.next = mergeTwoLists(l1, l2.next);
            return l2;
        }
    }

}
