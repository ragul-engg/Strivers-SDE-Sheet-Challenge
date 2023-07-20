package linked_list;

import utils.ListNode;

public class DeleteAGivenNode {
    public static void deleteNode(ListNode ListNode) {
        ListNode.data = ListNode.next.data;
        ListNode.next = ListNode.next.next;
    }

    public static void print(ListNode head) {
        ListNode curr = head;
        while (curr != null) {
            System.out.print(curr.data + " ");
            curr = curr.next;
        }
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);
        deleteNode(head.next.next.next);
        print(head);
    }
}
