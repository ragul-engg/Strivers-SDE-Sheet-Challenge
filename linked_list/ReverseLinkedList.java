package linked_list;

import utils.ListNode;

public class ReverseLinkedList {
    ListNode head;

    ReverseLinkedList() {
        this.head = null;
    }

    public void insert(int data) {
        if (this.head == null) {
            head = new ListNode(data);
        } else {
            ListNode curr = head;
            while (curr.next != null) {
                curr = curr.next;
            }
            curr.next = new ListNode(data);
        }
    }

    public void reverse() {
        ListNode prev = null;
        ListNode curr = head;
        ListNode next = null;
        while (curr != null) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        head = prev;
    }

    public void print() {
        ListNode curr = head;
        while (curr != null) {
            System.out.print(curr.data + " ");
            curr = curr.next;
        }
    }

    public static void main(String[] args) {
        ReverseLinkedList obj = new ReverseLinkedList();
        obj.insert(1);
        obj.insert(2);
        obj.insert(3);
        obj.insert(4);
        System.out.println("Linked list elements are: ");
        obj.print();
        obj.reverse();
        System.out.println("\nReversedLinked list elements are: ");
        obj.print();
    }
}
