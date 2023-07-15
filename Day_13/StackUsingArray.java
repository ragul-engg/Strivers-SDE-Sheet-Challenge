import java.util.*;
import java.io.*;

class Stack {
    int[] stack;
    int top;
    int capacity;

    Stack(int c) {
        stack = new int[c];
        capacity = c;
        top = -1;
    }

    void push(int num) {
        if (isFull() == 0) {
            stack[++top] = num;
        }
    }

    int pop() {
        if (isEmpty() == 1) {
            return -1;
        }
        return stack[top--];
    }

    int top() {
        if (isEmpty() == 1) {
            return -1;
        }
        return stack[top];
    }

    int isEmpty() {
        return top == -1 ? 1 : 0;
    }

    int isFull() {
        return top == capacity - 1 ? 1 : 0;
    }
}

public class StackUsingArray {
    public static void main(String[] args) {
        Stack stk = new Stack(5);
        stk.push(1);
        stk.push(2);
        stk.push(3);
        stk.pop();
        System.out.println(stk.isEmpty());
        System.out.println(stk.isFull());
        System.out.println(stk.top());
    }
}
