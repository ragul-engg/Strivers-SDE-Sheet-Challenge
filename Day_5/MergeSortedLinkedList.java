class Node {
    int data;
    Node next;

    Node() {
    }

    Node(int data) {
        this.data = data;
        this.next = null;
    }
}

public class MergeSortedLinkedList {

    public static void print(Node head) {
        Node curr = head;
        while (curr != null) {
            System.out.print(curr.data + " ");
            curr = curr.next;
        }
    }

    public static Node mergeTwoLists(Node list1, Node list2) {
        Node dummy = new Node(-1);
        Node tail = dummy;
        while (list1 != null && list2 != null) {
            if (list1.data <= list2.data) {
                tail.next = list1;
                list1 = list1.next;
            } else {
                tail.next = list2;
                list2 = list2.next;
            }
            tail = tail.next;
        }
        if (list1 != null) {
            tail.next = list1;
        }
        if (list2 != null) {
            tail.next = list2;
        }
        return dummy.next;
    }
}
