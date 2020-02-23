package org.interview.workout;

public class FindMissingNumber {

    static int findMissingNumber(int[] numbers) {
        if (numbers[0] != 0) {
            return 0;
        }
        return findMissingHelper(0, numbers.length - 1, numbers);
    }

    static int findMissingHelper(int start, int end, int [] numbers) {
        if(start >= end) {
            return end + 1;
        }

        int middle = start + ((end - start) / 2);
        if (numbers[middle] == middle) {
           return findMissingHelper(middle + 1, numbers.length - 1, numbers);
        }

        if (numbers[middle - 1] == middle - 1) {
            return middle;
        }
        return findMissingHelper(start, middle - 1, numbers);
    }

    public static void main(String[] args) {
        int[] numbers0 = {1,2,3};
        System.out.printf("The missing number is: %d.\n", findMissingNumber(numbers0));
        int[] numbers = {0,1,2};
        System.out.printf("The missing number is: %d.\n", findMissingNumber(numbers));
        int[] numbers2 = {0,1,3,4};
        System.out.printf("The missing number is: %d.\n", findMissingNumber(numbers2));
        int[] numbers3 = {0,1,2,3,4,6,7,8,9,10};
        System.out.printf("The missing number is: %d.\n", findMissingNumber(numbers3));
    }
}
