package org.interview.trees;

import java.util.Arrays;

public class MinHeap {
    private int capacity = 10;
    private int size = 0;

    private int[] heap = new int[capacity];

    private int getLeftChildIndex(final int parentIndex) {
        return 2 * parentIndex + 1;
    }

    private int getRightChildIndex(final int parentIndex) {
        return 2 * parentIndex + 2;
    }

    private int getParentIndex(final int childIndex) {
        return (childIndex - 1) / 2;
    }

    private boolean hasLeftChild(final int parentIndex) {
        return getLeftChildIndex(parentIndex) < size;
    }

    private boolean hasRightChild(final int parentIndex) {
        return getRightChildIndex(parentIndex) < size;
    }

    private boolean hasParent(final int index) {
        return getParentIndex(index) >= 0;
    }

    private int leftChild(final int parentIndex) {
        return heap[getLeftChildIndex(parentIndex)];
    }

    private int rightChild(final int parentIndex) {
        return heap[getRightChildIndex(parentIndex)];
    }

    private int parent(final int index) {
        return heap[getParentIndex(index)];
    }

    private void swap(final int i, final int j) {
        heap[i] = heap[i] ^ heap[j] ^ (heap[j] = heap[i]);
    }

    private void ensureExtraCapacity() {
        if (size == capacity) {
            heap = Arrays.copyOf(heap, size + capacity);
            size = size + capacity;
        }
    }

    private void heapifyUp() {
        int index = size - 1;
        while(hasParent(index) && parent(index) > heap[index]) {
            swap(getParentIndex(index), index);
            index = getParentIndex(index);
        }
    }

    private void heapifyDown() {
        int index = 0;
        while(hasLeftChild(index)) {
            int smallerChildIndex = getLeftChildIndex(index);
            if (hasRightChild(index) && rightChild(index) < leftChild(index)) {
                smallerChildIndex = getRightChildIndex(index);
            }
            if (heap[index] < heap[smallerChildIndex]) {
                break;
            }
            else {
                swap(index, smallerChildIndex);
            }
            index = smallerChildIndex;
        }
    }

    int peek() {
        if (size == 0) {
            throw new IllegalStateException("Heap is empty");
        }
        return heap[0];
    }

    boolean isEmpty() {
        return size ==0;
    }

    public int poll() {
        if (size == 0) {
            throw new IllegalStateException("Heap is empty");
        }
        int value = heap[0];
        heap[0] = heap[size - 1];
        size--;
        heapifyDown();
        return value;
    }

    private void add(int item) {
        ensureExtraCapacity();
        heap[size] = item;
        size++;
        heapifyUp();
    }

    public static void main(String[] args) {
        final int[] array = new int[]{10,15,20,17,23};
        MinHeap minHeap = new MinHeap();

        Arrays.stream(array).forEach(minHeap::add);
        while(!minHeap.isEmpty()) {
            System.out.println(minHeap.poll());
        }
    }
}
