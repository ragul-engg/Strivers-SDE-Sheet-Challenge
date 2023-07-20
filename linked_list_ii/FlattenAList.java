package linked_list_ii;

import utils.ListNode;

public class FlattenAList {
    static ListNode merge(ListNode head1, ListNode head2) {
        ListNode dummy = new ListNode(-1);
        ListNode tail = dummy;
        while (head1 != null && head2 != null) {
            if (head1.data <= head2.data) {
                tail.bottom = head1;
                head1 = head1.bottom;
                tail = tail.bottom;
            } else {
                tail.bottom = head2;
                head2 = head2.bottom;
                tail = tail.bottom;
            }
        }
        if (head1 != null) {
            tail.bottom = head1;
        } else {
            tail.bottom = head2;
        }
        return dummy.bottom;
    }

    static ListNode flatten(ListNode root) {
        ListNode prev = null;
        ListNode curr = root;
        while (curr != null) {
            ListNode next = curr.next;
            prev = merge(prev, curr);
            prev.next = null;
            curr.next = null;
            curr = next;
        }
        return prev;
    }

    static void print(ListNode root) {
        ListNode curr = root;
        while (curr != null) {
            System.out.print(curr.data + " ");
            curr = curr.bottom;
        }
    }

    public static void main(String[] args) {
        ListNode root = new ListNode(5);
        root.bottom = new ListNode(7);
        root.bottom.bottom = new ListNode(8);
        root.bottom.bottom.bottom = new ListNode(30);
        root.next = new ListNode(10);
        root.next.next = new ListNode(19);
        root.next.next.bottom = new ListNode(22);
        root.next.next.bottom.bottom = new ListNode(50);
        root.next.next.next = new ListNode(28);
        root = flatten(root);
        print(root);
    }
}