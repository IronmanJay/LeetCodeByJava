package BFS;

public class p117_PopulatingNextRightPointersInEachNodeII {

    int val;
    p117_PopulatingNextRightPointersInEachNodeII left;
    p117_PopulatingNextRightPointersInEachNodeII right;
    p117_PopulatingNextRightPointersInEachNodeII next;

    public p117_PopulatingNextRightPointersInEachNodeII(int val) {
        this.val = val;
    }

    public p117_PopulatingNextRightPointersInEachNodeII(int val, p117_PopulatingNextRightPointersInEachNodeII left, p117_PopulatingNextRightPointersInEachNodeII right, p117_PopulatingNextRightPointersInEachNodeII next) {
        this.val = val;
        this.left = left;
        this.right = right;
        this.next = next;
    }

    public static void main(String[] args) {

    }

    public static p117_PopulatingNextRightPointersInEachNodeII connect(p117_PopulatingNextRightPointersInEachNodeII root) {
        if (root == null) {
            return root;
        }
        p117_PopulatingNextRightPointersInEachNodeII cur = root;
        while (cur != null) {
            p117_PopulatingNextRightPointersInEachNodeII dummy = new p117_PopulatingNextRightPointersInEachNodeII(0);
            p117_PopulatingNextRightPointersInEachNodeII pre = dummy;
            while (cur != null) {
                if (cur.left != null) {
                    pre.next = cur.left;
                    pre = pre.next;
                }
                if (cur.right != null) {
                    pre.next = cur.right;
                    pre = pre.next;
                }
                cur = cur.next;
            }
            cur = dummy.next;
        }
        return root;
    }

}
