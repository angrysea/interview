package org.interview;

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
         IntStream.iterate(((length - 1) / 2) -1, e -> e >= 0, e -> e - 1).forEach(i -> heapify(length, i));

        IntStream.iterate(length - 1, e -> e > 0, e -> e - 1)
                .forEach( i -> { swap(0, i); heapify(i, 0); });
    }

    private void heapify(int end, int parent) {
        int largest = parent; // Initialize largest as root
        int left = 2 * parent + 1;
        int right = 2 * parent + 2;

        // If left child is larger than root
        if (left < end && arr[left] > arr[largest]) {
            largest = left;
        }

        // If right child is larger than largest so far
        if (right < end && arr[right] > arr[largest]) {
            largest = right;
        }

        // If largest is not root
        if (largest != parent) {
            swap(parent, largest);
            // Recursively heapify the affected sub-tree
            heapify(end, largest);
        }
    }

    private void printArray() {
        for (int value : arr) System.out.print(value + " ");
        System.out.println();
    }

    public static void main(String[] args) {
        HeapSort hs = new HeapSort(new int[]{12, 11, 13, 5, 6, 7, 3});
        hs.sort();
        System.out.println("Sorted array is");
        hs.printArray();
    }
}
