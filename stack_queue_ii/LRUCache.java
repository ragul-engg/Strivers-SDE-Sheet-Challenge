package stack_queue_ii;

import java.util.Map;
import java.util.HashMap;

class Node {
    int key;
    int value;
    Node next, prev;

    Node(int k, int v) {
        key = k;
        value = v;
        next = prev = null;
    }

    @Override
    public String toString() {
        return String.format("(%d, %d)", key, value);
    }
}

public class LRUCache {
    int capacity;
    Map<Integer, Node> cache;
    Node head, tail;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        this.head = new Node(0, 0);
        this.tail = new Node(0, 0);
        head.prev = null;
        tail.next = null;
        head.next = tail;
        tail.prev = head;
        cache = new HashMap<>();
    }

    public int get(int key) {
        if (cache.containsKey(key)) {
            Node node = removeNode(cache.get(key));
            insertNode(node);
            return node.value;
        }
        return -1;
    }

    public void put(int key, int value) {
        Node newNode = new Node(key, value);
        if (cache.containsKey(key)) {
            removeNode(cache.get(key));
            cache.remove(key);
        }
        if (cache.size() == capacity) {
            Node miss = removeNode(tail.prev);
            cache.remove(miss.key);
            miss = null;
        }
        cache.put(key, newNode);
        insertNode(newNode);
    }

    public void insertNode(Node newNode) {
        Node nextNode = head.next;
        newNode.next = nextNode;
        newNode.prev = head;
        head.next = newNode;
        nextNode.prev = newNode;
    }

    public Node removeNode(Node node) {
        Node prev = node.prev;
        Node next = node.next;
        prev.next = next;
        next.prev = prev;
        return node;
    }

    public static void main(String[] args) {

    }
}