package stack_queue;

import java.util.*;

public class QueueUsingStack {

    Deque<Integer> stack1;
    Deque<Integer> stack2;

    QueueUsingStack() {
        stack1 = new ArrayDeque<>();
        stack2 = new ArrayDeque<>();
    }

    void enQueue(int val) {
        stack1.add(val);
    }

    int deQueue() {
        if (isEmpty()) {
            return -1;
        }
        if (stack2.isEmpty()) {
            while (!stack1.isEmpty()) {
                stack2.add(stack1.pollLast());
            }
        }
        return stack2.pollLast();
    }

    int peek() {
        if (isEmpty()) {
            return -1;
        }
        if (stack2.isEmpty()) {
            while (!stack1.isEmpty()) {
                stack2.add(stack1.pollLast());
            }
        }
        return stack2.peekLast();
    }

    boolean isEmpty() {
        return stack1.isEmpty() && stack2.isEmpty();
    }

    public static void main(String[] args) {

    }
}
