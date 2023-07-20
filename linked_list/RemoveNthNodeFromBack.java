package linked_list;

import utils.ListNode;

public class RemoveNthNodeFromBack {
    static ListNode head;

    public static void insert(int data) {
        if (head == null) {
            head = new ListNode(data);
        } else {
            ListNode curr = head;
            while (curr.next != null) {
                curr = curr.next;
            }
            curr.next = new ListNode(data);
        }
    }

    public static ListNode removeKthNode(ListNode head, int K) {
        ListNode fast = head;
        ListNode slow = head;
        for (int i = 0; i < K; i++) {
            fast = fast.next;
        }
        if (fast == null) {
            head = head.next;
            return head;
        }
        while (fast.next != null) {
            fast = fast.next;
            slow = slow.next;
        }
        slow.next = slow.next.next;
        return head;
    }

    public static void print(ListNode head) {
        ListNode curr = head;
        while (curr != null) {
            System.out.print(curr.data + " ");
            curr = curr.next;
        }
    }

    public static void main(String[] args) {
        insert(1);
        insert(2);
        insert(3);
        insert(4);
        insert(5);
        removeKthNode(head, 2);
        print(head);
    }
}
