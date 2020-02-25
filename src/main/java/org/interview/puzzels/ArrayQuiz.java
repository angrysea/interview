package org.interview.puzzels;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ArrayQuiz {
    int minimumSwaps(int[] arr) {
        int swaps = 0;
        int size = arr.length;
        boolean[] visited = new boolean[size];

        for(int i = 0; i < size && swaps < size - 1; i++) {
            int j = i, cycle = 0;
            while(!visited[j]) {
                visited[j] = true;
                j = arr[j] - 1;
                cycle++;
            }

            if(cycle!=0) {
                swaps += cycle - 1;
            }
        }
        return swaps;
    }

    static int minimumBribes(int[] q) {
        int count = 0;
        int size = q.length;
        for (int i = size-1; i>=0; --i) {
            if (q[i] > (i + 3)) {
                System.out.println("Too chaotic");
                return -1;
            }

            for (int j = Math.max(0, q[i] - 2); j < i; ++j) {
                if (q[j] > q[i]) {
                    count++;
                }
            }
        }
        return count;
    }

    static void swapLeft(int[]arr, int swaps) {
        int last = arr.length - 1;
        for(int k = 0; k < swaps; k++) {
            int pivot = arr[0];
            for (int i = 0, j = i + 1; i < last; i++, j++) {
                arr[i] = arr[j];
            }
            arr[last] = pivot;
        }
        Arrays.stream(arr).forEach(i -> System.out.printf("%d, ", i));
        System.out.println();
    }

    List<Integer> sumHourGlasses(int[][] arr) {
        List<Integer> results = new ArrayList<>();

        int rows = arr.length;
        int cols = arr[0].length;

        for(int i = 1; i < rows -1; i++) {
            for(int j = 1; j < cols - 1; j++) {
                results.add(arr[i-1][j-1] + arr[i-1][j] + arr[i-1][j+1] + arr[i][j] +
                        arr[i+1][j-1] + arr[i+1][j] + arr[i+1][j+1]);
            }
        }
        //-63, -34, -9, 12, -10, 0, 28, 23, -27, -11, -2, 10, 9, 17, 25, 18
        return results;
    }


    //Difference array solution solved int O(n) instead of O(n*m)
    long addToArray(int n, int[][] queries) {
        long[] zeroes = new long[n];
        int rows = queries.length;
        for(int i=0;i<n;i++) {
            zeroes[i]=0;
        }

        for(int i = 0; i < rows; i++) {
            int start = queries[i][0] - 1;
            int end = queries[i][1];
            int sum = queries[i][2];
            zeroes[start] += sum;
            if(end < n) {
                zeroes[end] -= sum;
            }
        }

        long max=0;
        long temp=0;

        for(int i=0; i<n; i++) {
            temp += zeroes[i];
            if(temp > max) {
                max = temp;
            }
        }

//        for(int i = 0; i < n; i++) {
//            for(int j = 0; j < rows; j++) {
//                if(i >= queries[j][0] - 1 && i < queries[j][1]) {
//                    zeroes[i] += queries[j][2];
//                }
//            }
//        }
//        for(int i = 0; i < rows; i++) {
//            for(int j = queries[i][0] - 1; j < queries[i][1] && j < n; j++) {
//                zeroes[j] += queries[i][2];
//            }
//        }
        // 1,  9, 16, 16, 31, 24, 16, 16, 15,  0

//        long max = Integer.MIN_VALUE;
//        for(int i = 0; i < n; i++) {
//            if(zeros[i] > max) {
//                max = zeros[i];
//            }
//        }
//        return max;
        Arrays.sort(zeroes);
        return zeroes[n-1];
    }

    static public void main(String[] args) {
        ArrayQuiz o = new ArrayQuiz();

        int[][] test = {
                {-9,-9,-9,1,1,1},
                {0,-9,0,4,3,2},
                {-9,-9,-9,1,2,3},
                {0,0,8,6,6,0},
                {0,0,0,-2,0,0},
                {0,0,1,2,4,0}
        };

        int[][] test2 = {
                {2,6,8},
                {3,5,7},
                {1,8,1},
                {5,9,15}
        };

        /*
        0   1   2   3   4   5   6   7   8   9
        0,  0,  0,  0,  0,  0,  0,  0,  0,  0
        1-5 +8
        0,  8,  8,  8,  8,  8,  0,  0,  0,  0
        2-4 +7
        0,  8, 15, 15, 15,  8,  0,  0,  0,  0
        1-8 1
        1,  9, 16, 16, 16,  9,  1,  1,  0,  0
        5-9 15
        1,  9, 16, 16, 31, 24, 16, 16, 15,  0
        */
        System.out.printf("Max value %d \n", o.addToArray(10, test2));
        List<Integer> results = o.sumHourGlasses(test);
        o.swapLeft(new int[]{1,2,3,4,5}, 4);
        System.out.printf("minimumBribes 2,1,5,3,4 %d \n", o.minimumBribes(new int[]{2,1,5,3,4}));
        System.out.printf("minimumBribes 2,5,1,3,4 %d \n", o.minimumBribes(new int[]{2,5,1,3,4}));
        System.out.printf("minimumSwaps 4,3,1,2 %d \n", o.minimumSwaps(new int[]{4,3,1,2}));
        System.out.printf("minimumSwaps 1,2,3,4 %d \n", o.minimumSwaps(new int[]{1,2,3,4}));
    }

}
