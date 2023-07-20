
import utils.ListNode;

public class RotateAList {
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

    public static ListNode rotate(ListNode head, int k) {
        if (head == null || head.next == null || k == 0) {
            return head;
        }
        ListNode curr = head;
        int len = 1;
        while (curr.next != null) {
            curr = curr.next;
            len++;
        }
        curr.next = head;
        k %= len;
        int end = len - k;
        while (end > 0) {
            curr = curr.next;
            end--;
        }
        ListNode newHead = curr.next;
        curr.next = null;
        return newHead;
    }

    public static void print() {
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
        head = rotate(head, 2);
        print();
    }
}
