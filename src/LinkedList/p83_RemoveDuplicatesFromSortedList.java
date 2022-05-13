package LinkedList;

public class p83_RemoveDuplicatesFromSortedList {

    int val;
    p83_RemoveDuplicatesFromSortedList next;

    public p83_RemoveDuplicatesFromSortedList() {
    }

    public p83_RemoveDuplicatesFromSortedList(int val) {
        this.val = val;
    }

    public p83_RemoveDuplicatesFromSortedList(int val, p83_RemoveDuplicatesFromSortedList next) {
        this.val = val;
        this.next = next;
    }

    public static void main(String[] args) {
        p83_RemoveDuplicatesFromSortedList node1 = new p83_RemoveDuplicatesFromSortedList();
        p83_RemoveDuplicatesFromSortedList node2 = new p83_RemoveDuplicatesFromSortedList();
        p83_RemoveDuplicatesFromSortedList node3 = new p83_RemoveDuplicatesFromSortedList();
        node1.val = 1;
        node2.val = 1;
        node3.val = 2;
        node1.next = node2;
        node2.next = node3;
        p83_RemoveDuplicatesFromSortedList res = deleteDuplicates(node1);
        while(res != null){
            System.out.println(res.val + " ");
            res = res.next;
        }
    }

    public static p83_RemoveDuplicatesFromSortedList deleteDuplicates(p83_RemoveDuplicatesFromSortedList head) {
        if(head == null)
        {
            return head;
        }
        p83_RemoveDuplicatesFromSortedList p = head;
        while(p.next != null)
        {
            if(p.val == p.next.val)
            {
                p.next = p.next.next;
            }
            else
            {
                p = p.next;
            }
        }
        return head;
    }

}
