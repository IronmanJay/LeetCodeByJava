package LinkedList;

/**
 * @Author: IronmanJay
 * @Description: 23.合并K个升序链表
 * @CreateTime: 2022-12-10  10:22
 */
public class p23_MergeKSortedLists {

    int val;
    p23_MergeKSortedLists next;

    public p23_MergeKSortedLists(int val) {
        this.val = val;
    }

    public p23_MergeKSortedLists(int val, p23_MergeKSortedLists next) {
        this.val = val;
        this.next = next;
    }

    public static void main(String[] args) {

    }

    public static p23_MergeKSortedLists mergeKLists(p23_MergeKSortedLists[] lists) {
        p23_MergeKSortedLists res = null;
        for (int i = 0; i < lists.length; i++) {
            res = mergeTwo(res, lists[i]);
        }
        return res;
    }

    public static p23_MergeKSortedLists mergeTwo(p23_MergeKSortedLists p, p23_MergeKSortedLists q) {
        p23_MergeKSortedLists dummy = new p23_MergeKSortedLists(0);
        p23_MergeKSortedLists temp = dummy;
        while (p != null && q != null) {
            if (p.val < q.val) {
                temp.next = p;
                p = p.next;
            } else {
                temp.next = q;
                q = q.next;
            }
            temp = temp.next;
        }
        if (p != null) {
            temp.next = p;
        }
        if (q != null) {
            temp.next = q;
        }
        return dummy.next;
    }

}
