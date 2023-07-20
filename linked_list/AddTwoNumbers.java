package linked_list;

import utils.ListNode;

public class AddTwoNumbers {
    public static ListNode addTwoNumbers(ListNode num1, ListNode num2) {
        ListNode dummy = new ListNode(-1);
        ListNode tail = dummy;
        int carry = 0;
        while (num1 != null || num2 != null || carry == 1) {
            int sum = 0;
            if (num1 != null) {
                sum += num1.data;
                num1 = num1.next;
            }
            if (num2 != null) {
                sum += num2.data;
                num2 = num2.next;
            }
            sum += carry;
            carry = sum / 10;
            tail.next = new ListNode(sum % 10);
            tail = tail.next;
        }
        return dummy.next;
    }

    public static void print(ListNode head) {
        ListNode curr = head;
        while (curr != null) {
            System.out.print(curr.data + " ");
            curr = curr.next;
        }
    }

    public static void main(String[] args) {
        ListNode num1 = new ListNode(9);
        num1.next = new ListNode(9);
        num1.next.next = new ListNode(9);
        num1.next.next.next = new ListNode(9);
        num1.next.next.next.next = new ListNode(9);
        ListNode num2 = new ListNode(9);
        num2.next = new ListNode(9);
        num2.next.next = new ListNode(9);
        num2.next.next.next = new ListNode(9);
        ListNode result = addTwoNumbers(num1, num2);
        print(result);
    }
}