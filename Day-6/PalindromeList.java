class Node {
    int data;
    Node next;

    Node(int data) {
        this.data = data;
        next = null;
    }
}

public class PalindromeList {
    public static Node getMiddle(Node head) {
        Node slow = head;
        Node fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    public static Node reverse(Node head) {
        Node prev = null;
        Node curr = head;
        Node next = null;
        while (curr != null) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev;
    }

    public static boolean isEqual(Node head, Node tail) {
        while (tail != null) {
            if (tail.data != head.data) {
                return false;
            }
            head = head.next;
            tail = tail.next;
        }
        return true;
    }

    public void print(Node head) {
        Node curr = head;
        while (curr != null) {
            System.out.print(curr.data + " ");
            curr = curr.next;
        }
    }

    public static boolean isPalindrome(Node head) {
        Node middle = getMiddle(head);
        middle = reverse(middle);
        return isEqual(head, middle);
    }

    public static void main(String[] args) {
        Node root = new Node(1);
        root.next = new Node(2);
        root.next.next = new Node(2);
        root.next.next.next = new Node(1);
        System.out.println("Is List Palindrome " + isPalindrome(root));
    }
}
