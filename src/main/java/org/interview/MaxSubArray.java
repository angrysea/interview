package org.interview;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MaxSubArray {

    static class Triple<E> extends ArrayList<E> {
        static final private int LOW = 0;
        static final private int HIGH = 1;
        static final private int SUM = 2;

        Triple(E low, E high, E sum) {
            super(3);
            this.add(LOW, low);
            this.add(HIGH, high);
            this.add(SUM, sum);
        }

        E getLow() {
            return this.get(LOW);
        }

        E getHigh() {
            return this.get(HIGH);
        }

        E getSum() {
            return this.get(SUM);
        }
    }

    private List<Integer> array;

    public MaxSubArray(Integer[] data) {
        array = Arrays.asList(data);
    }

    private void findMax() {
        Triple<Integer> result = findMaxSubArray(0, array.size());
        print(result.getLow(), result.getHigh(), result.getSum());
    }

    private Triple<Integer> findMaxCrossingSubarray(int low, int mid, int high) {
        int sum = 0;
        int leftSum = Integer.MAX_VALUE;
        int maxLeft = 0;
        for (int i = mid; i >= low; --i) {
            sum += array.get(i);
            if (sum > leftSum) {
                leftSum = sum;
                maxLeft = i;
            }
        }

        sum = 0;
        int rightSum = Integer.MIN_VALUE;
        int maxRight = 0;

        for (int i = low; i < high; ++i) {
            sum += array.get(i);
            if (sum > rightSum) {
                rightSum = sum;
                maxRight = i;
            }
        }
        return new Triple<>(maxLeft, maxRight, leftSum + rightSum);
    }

    private Triple<Integer> findMaxSubArray(int low, int high) {
        if (low == high) {
            return new Triple<>(low, high, array.get(low));
        } else {
            int mid = (low + high) / 2;
            Triple<Integer> left = findMaxSubArray(low, mid);
            Triple<Integer> right = findMaxSubArray(mid + 1, high);
            Triple<Integer> cross = findMaxCrossingSubarray(low, mid, high);

            if (left.getSum() >= right.getSum() && left.getSum() >= cross.getSum()) {
                return left;
            } else if (right.getSum() >= left.getSum() && right.getSum() >= cross.getSum()) {
                return right;
            } else {
                return cross;
            }
        }
    }

    private void print(int low, int high, int sum) {
        System.out.println(String.format("Sum: %d", sum));
        for (int i = low; i <= high; ++i) {
            System.out.print(String.format(" %d", array.get(i)));
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Integer [] array = new Integer[]{1, 2, -6, -5, 7, -2, 4, 4};
        MaxSubArray max = new MaxSubArray(array);
        max.findMax();

        Integer [] array2 = new Integer[]{4, -1, 6, -100, 5};
        MaxSubArray max2 = new MaxSubArray(array2);
        max2.findMax();
    }
}
