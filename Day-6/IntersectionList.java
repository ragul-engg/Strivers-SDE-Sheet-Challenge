class Node {
    int data;
    Node next;

    Node(int data) {
        this.data = data;
        next = null;
    }
}

public class IntersectionList {
    public static Node findIntersection(Node head1, Node head2) {
        Node node1 = head1;
        Node node2 = head2;
        while (node1 != node2) {
            node1 = (node1 == null) ? head2 : node1.next;
            node2 = (node2 == null) ? head1 : node2.next;
        }
        return node1;
    }

    public static void main(String[] args) {
        Node head1 = new Node(4);
        head1.next = new Node(1);
        Node head2 = new Node(5);
        head2.next = new Node(6);
        head2.next.next = new Node(1);
        Node intersectionNode = new Node(8);
        intersectionNode.next = new Node(4);
        intersectionNode.next.next = new Node(5);
        head1.next = intersectionNode;
        head2.next = intersectionNode;
        System.out.println(findIntersection(head1, head2).data);
    }
}
