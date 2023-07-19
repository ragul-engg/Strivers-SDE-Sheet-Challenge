package linked_list;

class Node {
    int data;
    Node next;

    Node(int data) {
        this.data = data;
        this.next = null;
    }
}

public class AddTwoNumbers {
    public static Node addTwoNumbers(Node num1, Node num2) {
        Node dummy = new Node(-1);
        Node tail = dummy;
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
            tail.next = new Node(sum % 10);
            tail = tail.next;
        }
        return dummy.next;
    }

    public static void print(Node head) {
        Node curr = head;
        while (curr != null) {
            System.out.print(curr.data + " ");
            curr = curr.next;
        }
    }

    public static void main(String[] args) {
        Node num1 = new Node(9);
        num1.next = new Node(9);
        num1.next.next = new Node(9);
        num1.next.next.next = new Node(9);
        num1.next.next.next.next = new Node(9);
        Node num2 = new Node(9);
        num2.next = new Node(9);
        num2.next.next = new Node(9);
        num2.next.next.next = new Node(9);
        Node result = addTwoNumbers(num1, num2);
        print(result);
    }
}