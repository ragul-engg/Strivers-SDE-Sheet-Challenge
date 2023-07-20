package linked_list_ii;

import utils.ListNode;

public class IntersectionList {
    public static ListNode findIntersection(ListNode head1, ListNode head2) {
        ListNode node1 = head1;
        ListNode node2 = head2;
        while (node1 != node2) {
            node1 = (node1 == null) ? head2 : node1.next;
            node2 = (node2 == null) ? head1 : node2.next;
        }
        return node1;
    }

    public static void main(String[] args) {
        ListNode head1 = new ListNode(4);
        head1.next = new ListNode(1);
        ListNode head2 = new ListNode(5);
        head2.next = new ListNode(6);
        head2.next.next = new ListNode(1);
        ListNode intersectionNode = new ListNode(8);
        intersectionNode.next = new ListNode(4);
        intersectionNode.next.next = new ListNode(5);
        head1.next = intersectionNode;
        head2.next = intersectionNode;
        System.out.println(findIntersection(head1, head2).data);
    }
}
