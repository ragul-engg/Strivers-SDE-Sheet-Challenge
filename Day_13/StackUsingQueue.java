import java.util.*;

public class StackUsingQueue {
    Deque<Integer> stack;

    public StackUsingQueue() {
        stack = new ArrayDeque<>();
    }

    public int getSize() {
        return stack.size();
    }

    public boolean isEmpty() {
        return stack.isEmpty();
    }

    public void push(int element) {
        int size = stack.size();
        stack.add(element);
        for (int i = 0; i < size; i++) {
            stack.add(stack.poll());
        }
    }

    public int pop() {
        if (isEmpty()) {
            return -1;
        }
        return stack.poll();
    }

    public int top() {
        if (isEmpty()) {
            return -1;
        }
        return stack.peekFirst();
    }

    public static void main(String[] args) {

    }
}
