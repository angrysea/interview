package org.interview;

import java.util.Arrays;
import java.util.List;

public class MergeSort {
    private List<Integer> arr;

    private MergeSort(Integer [] data)  {
        arr = Arrays.asList(data);
    }

    private void merge(final Integer[] arr, final Integer[] temp, final int leftStart, final int rightEnd) {
        final int leftEnd = (leftStart + rightEnd) / 2;
        final int rightStart = leftEnd + 1;
        final int size = rightEnd - leftStart + 1;

        int left = leftStart;
        int right = rightStart;
        int index = leftStart;

        while(left <= leftEnd && right <= rightEnd) {
            if(arr[left] <= arr[right]) {
                temp[index] = arr[left];
                left++;
            }
            else {
                temp[index] = arr[right];
                right++;
            }
            index++;
        }

        System.arraycopy(arr, left, temp, index, leftEnd - left + 1);
        System.arraycopy(arr, right, temp, index, rightEnd - right + 1);
        System.arraycopy(temp, leftStart, arr, leftStart, rightEnd - leftStart + 1);
    }

    private void mergeSort(final Integer[] arr, final Integer[] temp, int leftStart, int rightEnd) {
        if (leftStart < rightEnd) {
            int middle = (leftStart + rightEnd) / 2;
            mergeSort(arr, temp, leftStart, middle);
            mergeSort(arr, temp, middle + 1, rightEnd);
            merge(arr, temp, leftStart, rightEnd);
        }
    }

    private void sort(final Integer[] arr) {
        mergeSort(arr, new Integer[arr.length], 0, arr.length-1);
    }

    private void print() {
        for (Integer i : arr) {
            System.out.print(i);
            System.out.print(" ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Integer [] ms = { 2, 4, 5, 7, 1, 2, 3, 6 };
        MergeSort test = new MergeSort(ms);
        test.sort(ms);
        test.print();
    }
}
