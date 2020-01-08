package org.interview.sorting;

import java.util.Random;

public class QuickSort {

    private final int[] arr;

    private QuickSort(final int[] arr) {
        this.arr = arr;
    }

    private void swap(final int i, final int j) {
        arr[i] = arr[i] ^ arr[j] ^ (arr[j] = arr[i]);
    }

    private void randomBetween(final int left, final int right) {
       swap(new Random().nextInt(right - left + 1) + left, right);
    }

    private void sort(final int left, final int right) {
        if (left < right) {
            final int pi = partition(left, right);
            sort(left, pi - 1);
            sort(pi + 1, right);
        }
    }

    private int partition(int left, int right) {
        randomBetween(left, right);
        final int pivot = arr[right];
        int i = left - 1;
        for(int j = left; j < right; j++) {
            if (arr[j] <= pivot) {
                i++;
                swap(i, j);
            }
        }
        i++;
        swap(i, right);
        return i;
    }

    private int partition2(int left, int right) {
        final int pivot = arr[right]; //
        while (left <= right) {
            while (arr[left] < pivot) {
                left++;
            }

            while (arr[right] > pivot) {
                right--;
            }

            if (left <= right) {
                swap(left, right);
                left++;
                right--;
            }
        }
        return left;
    }

    private void printArray() {
        for (int value : arr) System.out.print(value + " ");
        System.out.println();
    }

    public static void main(String[] args) {
        int[] arr = {2, 8, 7, 1, 3, 5, 6, 4};
        QuickSort qs = new QuickSort(arr);
        qs.sort(0, arr.length - 1);
        qs.printArray();
    }
}