package org.interview.trees;

import java.util.stream.IntStream;

public class MaxHeapTest {

    private void swap(final int[]arr, final int i, final int j) {
        arr[i] = arr[i] ^ arr[j] ^ (arr[j] = arr[i]);
    }

    private int[] sort(final int[] arr) {
        final int length = arr.length;
        IntStream.iterate((length / 2) - 1, e -> e >= 0, e -> e - 1)
                .forEach(i -> heapify(arr, length, i));

        IntStream.iterate(length - 1, e -> e > 0, e -> e - 1)
                .forEach(i -> {
                    swap(arr, 0, i);
                    heapify(arr, i, 0);
                });

        return arr;
    }

    private void heapify(final int[] arr, int n, int root) {
        int left = (root * 2) + 1;
        int right = (root * 2) + 2;
        int largest = root;

        if(left < n && arr[left] > arr[largest]) {
            swap(arr, left, largest);
        }

        if(right < n && arr[right] > arr[largest]) {
            swap(arr, right, largest);
        }

        if(largest != root) {
            swap(arr, root, largest);
            heapify(arr, n, largest);
        }
    }

    private void printArray(final int[] arr) {
        for (int value : arr) System.out.print(value + " ");
        System.out.println();
    }

    public static void main(String[] args) {
        MaxHeapTest hs = new MaxHeapTest();
        System.out.println("Sorted array is");
        hs.printArray(hs.sort(new int[]{12, 11, 13, 5, 6, 7}));
    }
}
