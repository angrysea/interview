package org.interview.leetcode;

import java.util.Arrays;
/*
    Given a m x n matrix, if an element is 0, set its entire row and column to 0. Do it in-place.
 */

public class SetZeroes {
    public void setZeroes(int[][] matrix) {
        Arrays.stream(matrix).forEach(row -> {
            Arrays.stream(row).forEach(i -> System.out.printf("%d, ", i));
            System.out.println();
        });
        System.out.println();

        boolean[] rows = new boolean[matrix.length];
        boolean[] cols = new boolean[matrix[0].length];

        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[0].length; col++) {
                if (matrix[row][col] == 0) {
                    rows[row] = true;
                    cols[col] = true;
                }
            }
        }

        zeroRow(matrix, rows);
        zeroColumn(matrix, cols);

        Arrays.stream(matrix).forEach(row -> {
            Arrays.stream(row).forEach(i -> System.out.printf("%d, ", i));
            System.out.println();
        });
        System.out.println();
    }

    void zeroRow(int[][] matrix, boolean[] rows) {
        for (int row = 0; row < matrix.length; row++) {
            if (rows[row]) {
                for (int col = 0; col < matrix[row].length; col++) {
                    matrix[row][col] = 0;
                }
            }
        }
    }

    void zeroColumn(int[][] matrix, boolean[] cols) {
        for (int col = 0; col < cols.length; col++) {
            if(cols[col]) {
                for (int row = 0; row < matrix.length; row++) {
                    matrix[row][col] = 0;
                }
            }
        }
    }

    public static void main(String[] args) {
        SetZeroes o = new SetZeroes();
        int [][] matrix = new int[][]{{1,1,1},{1,0,1},{1,1,1}};
        o.setZeroes(matrix);

        matrix = new int[][]{{0,1,2,0},{3,4,5,2},{1,3,1,5}};
        o.setZeroes(matrix);

        matrix = new int[][]{{-1},{2},{3}};
        o.setZeroes(matrix);
    }
}
