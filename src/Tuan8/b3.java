package Tuan8;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class MinHeap {
    private List<Integer> heap;

    private void heapify(int i) {
        int smallest = i;
        int left = 2 * i + 1;
        int right = 2 * i + 2;

        if (left < heap.size() && heap.get(left) < heap.get(smallest)) {
            smallest = left;
        }

        if (right < heap.size() && heap.get(right) < heap.get(smallest)) {
            smallest = right;
        }

        if (smallest != i) {
            int temp = heap.get(i);
            heap.set(i, heap.get(smallest));
            heap.set(smallest, temp);
            heapify(smallest);
        }
    }

    public MinHeap() {
        heap = new ArrayList<>();
    }

    public void insert(int value) {
        heap.add(value);
        int i = heap.size() - 1;

        while (i > 0 && heap.get(i) < heap.get((i - 1) / 2)) {
            int temp = heap.get(i);
            heap.set(i, heap.get((i - 1) / 2));
            heap.set((i - 1) / 2, temp);
            i = (i - 1) / 2;
        }
    }

    public int getMin() {
        if (heap.isEmpty()) {
            return -1;
        }
        return heap.get(0);
    }

    public boolean delete(int value) {
        for (int i = 0; i < heap.size(); i++) {
            if (heap.get(i) == value) {
                heap.set(i, heap.get(heap.size() - 1));
                heap.remove(heap.size() - 1);
                heapify(i);
                return true;
            }
        }
        return false;
    }
}

public class b3 {
    public static void main(String[] args) {
        MinHeap minHeap = new MinHeap();
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int k = scanner.nextInt();

        for (int i = 0; i < n; i++) {
            int x = scanner.nextInt();
            minHeap.insert(x);
        }

        int cnt = 0;
        while (minHeap.getMin() <= k && n > 1) {
            int smallVal1 = minHeap.getMin();
            minHeap.delete(minHeap.getMin());
            int smallVal2 = minHeap.getMin();
            minHeap.delete(minHeap.getMin());
            int newVal = smallVal1 + 2 * smallVal2;
            minHeap.insert(newVal);
            cnt++;
            n--;
        }

        if (n == 1 && minHeap.getMin() < k) {
            System.out.println("-1");
            return;
        }

        System.out.println(cnt);
    }
}