import java.util.PriorityQueue;

public class MedianOfStream {
    static PriorityQueue<Integer> maxHeap = new PriorityQueue<>((a, b) -> b - a);
    static PriorityQueue<Integer> minHeap = new PriorityQueue<>((a, b) -> a - b);

    public static void insert(int val) {
        if (maxHeap.isEmpty() || val <= maxHeap.peek()) {
            maxHeap.add(val);
        } else {
            minHeap.add(val);
        }
        balanceHeaps();
    }

    public static void balanceHeaps() {
        if (maxHeap.size() > minHeap.size() + 1) {
            minHeap.add(maxHeap.poll());
        } else if (maxHeap.size() < minHeap.size()) {
            maxHeap.add(minHeap.poll());
        }
    }

    public static int getMedian() {
        if (minHeap.size() == maxHeap.size()) {
            return (minHeap.peek() + maxHeap.peek()) / 2;
        }
        return maxHeap.peek();
    }

    public static int[] findMedian(int[] arr, int n) {
        int[] median = new int[n];
        for (int i = 0; i < n; i++) {
            insert(arr[i]);
            median[i] = getMedian();
        }
        maxHeap.clear();
        minHeap.clear();
        return median;
    }

    public static void main(String[] args) {
        int[] arr = { 1, 2, 3, 4, 5 };
        int[] median = findMedian(arr, arr.length);
        for (int val : median) {
            System.out.print(val + " ");
        }
    }
}
