package org.interview;

import java.util.Collections;
import java.util.stream.IntStream;

public class HeapSort {
    final int[] arr;
    final int length;

    private HeapSort(final int[] arr) {
        this.arr = arr;
        this.length = this.arr.length;
    }

    private void swap(final int i, final int j) {
        arr[i] = arr[i] ^ arr[j] ^ (arr[j] = arr[i]);
    }

    private void sort() {
        IntStream.range(0, length / 2)
                .boxed()
                .sorted(Collections.reverseOrder())
                .forEach(i -> heapify(length, i));

        IntStream.range(1, length)
                .boxed()
                .sorted(Collections.reverseOrder())
                .forEach( i -> {
                    swap(0, i);
                    heapify(i, 0);
                });
    }

    private void heapify(int end, int root) {
        int largest = root; // Initialize largest as root
        int left = 2 * root + 1;
        int right = 2 * root + 2;

        // If left child is larger than root
        if (left < end && arr[left] > arr[largest]) {
            largest = left;
        }

        // If right child is larger than largest so far
        if (right < end && arr[right] > arr[largest]) {
            largest = right;
        }

        // If largest is not root
        if (largest != root) {
            swap(root, largest);
            // Recursively heapify the affected sub-tree
            heapify(end, largest);
        }
    }

    private void printArray() {
        for (int value : arr) System.out.print(value + " ");
        System.out.println();
    }

    public static void main(String[] args) {
        HeapSort hs = new HeapSort(new int[]{12, 11, 13, 5, 6, 7});
        hs.sort();
        System.out.println("Sorted array is");
        hs.printArray();
    }
}
