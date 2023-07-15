class Queue {
    int[] arr;
    int front, rear;

    Queue() {
        arr = new int[5000];
        front = rear = 0;
    }

    boolean isEmpty() {
        return rear == 0;
    }

    void enqueue(int data) {
        arr[rear++] = data;
    }

    int dequeue() {
        if (rear == 0) {
            return -1;
        }
        int top = arr[front];
        front++;
        if (front >= rear) {
            front = rear = 0;
        }
        return top;
    }

    int front() {
        if (rear == 0) {
            return -1;
        }
        return arr[front];
    }
}

public class QueueUsingArray {
    public static void main(String[] args) {
        Queue queue = new Queue();
        queue.enqueue(2);
        queue.enqueue(29);
        queue.enqueue(26);
        queue.dequeue();
        queue.enqueue(34);
        queue.enqueue(6);
        System.out.println(queue.front());
    }
}