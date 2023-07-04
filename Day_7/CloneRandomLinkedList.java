class LinkedListNode<T> {
    T data;
    LinkedListNode<T> next;
    LinkedListNode<T> random;

    public LinkedListNode(T data) {
        this.data = data;
    }
}

public class CloneRandomLinkedList {
    public static LinkedListNode<Integer> cloneRandomList(LinkedListNode<Integer> head) {
        LinkedListNode<Integer> curr = head;
        LinkedListNode<Integer> next = null;
        while (curr != null) {
            LinkedListNode<Integer> newNode = new LinkedListNode<>(curr.data);
            next = curr.next;
            curr.next = newNode;
            newNode.next = next;
            curr = next;
        }
        curr = head;
        while (curr != null) {
            if (curr.random != null) {
                curr.next.random = curr.random.next;
            }
            curr = curr.next.next;
        }
        LinkedListNode<Integer> dummy = new LinkedListNode<>(-1);
        curr = head;
        LinkedListNode<Integer> tail = dummy;
        while (curr != null) {
            tail.next = curr.next;
            tail = tail.next;
            curr.next = curr.next.next;
            curr = curr.next;
        }
        return dummy.next;
    }

    private static void print(LinkedListNode<Integer> head) {
        LinkedListNode<Integer> curr = head;
        while (curr != null) {
            System.out.print(curr.data + " ");
            curr = curr.next;
        }
    }

    public static void main(String[] args) {
        LinkedListNode<Integer> head = new LinkedListNode<>(1);
        head.next = new LinkedListNode<>(2);
        head.next.next = new LinkedListNode<>(3);
        head.next.next.next = new LinkedListNode<>(4);
        head.next.next.next.next = new LinkedListNode<>(5);
        LinkedListNode<Integer> copyHead = cloneRandomList(head);

        print(copyHead);
    }
}
