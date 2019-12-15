package org.interview.sorting;

import java.util.Arrays;
import java.util.List;

public class MergeSort {
    private int[] arr;
    private int[] temp;

    private MergeSort(int[] data)  {
        this.arr = data;
        this.temp = new int[arr.length];
    }

    private void merge(final int low, final int middle, final int high) {
        int i = low;
        while(!(i > high)) {
            temp[i] = arr[i++];
        }

        i = low;
        int j = middle + 1;
        int k = low;

        while(i <= middle && j <= high) {
            if(temp[i] <= temp[j]) {
                arr[k++] = temp[i++];
            }
            else {
                arr[k++] = temp[j++];
            }
        }

        while(i <= middle) {
            arr[k++] = temp[i++];
        }
    }

    private void mergeSort(int low, int high) {
        if (low < high) {
            int middle = low + (high - low) / 2;
            mergeSort(low, middle);
            mergeSort(middle + 1, high);
            merge(low, middle, high);
        }
    }

    private void sort() {
        mergeSort(0, arr.length-1);
    }

    private void print() {
        for (Integer i : arr) {
            System.out.print(i);
            System.out.print(" ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int[] ms = { 2, 4, 5, 7, 1, 2, 3, 6 };
        MergeSort test = new MergeSort(ms);
        test.sort();
        test.print();
    }
}
