package linked_list_ii;

import utils.ListNode;

public class PalindromeList {
    public static ListNode getMiddle(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    public static ListNode reverse(ListNode head) {
        ListNode prev = null;
        ListNode curr = head;
        ListNode next = null;
        while (curr != null) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev;
    }

    public static boolean isEqual(ListNode head, ListNode tail) {
        while (tail != null) {
            if (tail.data != head.data) {
                return false;
            }
            head = head.next;
            tail = tail.next;
        }
        return true;
    }

    public void print(ListNode head) {
        ListNode curr = head;
        while (curr != null) {
            System.out.print(curr.data + " ");
            curr = curr.next;
        }
    }

    public static boolean isPalindrome(ListNode head) {
        ListNode middle = getMiddle(head);
        middle = reverse(middle);
        return isEqual(head, middle);
    }

    public static void main(String[] args) {
        ListNode root = new ListNode(1);
        root.next = new ListNode(2);
        root.next.next = new ListNode(2);
        root.next.next.next = new ListNode(1);
        System.out.println("Is List Palindrome " + isPalindrome(root));
    }
}
