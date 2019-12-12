package org.interview.sorting;

import java.util.Arrays;
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
        IntStream.iterate(((length - 1) / 2) - 1, e -> e >= 0, e -> e - 1)
                .forEach(i -> heapify(length, i));
        IntStream.iterate(length - 1, e -> e > 0, e -> e - 1)
                .forEach( i -> { swap(0, i); heapify(i, 0); });
    }

    private void heapify(final int end, final int parent) {
        int largest = parent;
        int left = 2 * parent + 1;
        int right = 2 * parent + 2;

        if (left < end && arr[left] > arr[largest]) {
            largest = left;
        }

        if (right < end && arr[right] > arr[largest]) {
            largest = right;
        }

        if (largest != parent) {
            swap(parent, largest);
            heapify(end, largest);
        }
    }

    private void printArray() {
        Arrays.stream(arr).forEach(i -> System.out.printf("%d ", i));
        System.out.println();
    }

    public static void main(String[] args) {
        HeapSort hs = new HeapSort(new int[]{12, 11, 13, 5, 6, 7, 3});
        hs.sort();
        System.out.println("Sorted array is: ");
        hs.printArray();
    }
}