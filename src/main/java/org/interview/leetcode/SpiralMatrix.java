package org.interview.leetcode;

import java.util.ArrayList;
import java.util.List;

public class SpiralMatrix {
    public List<Integer> spiralOrder(int[][] matrix) {

        List<Integer> output = new ArrayList<>();
        int rows = matrix.length;
        if(rows == 0) {
            return output;
        }

        int columns = matrix[0].length;
        if(columns == 0) {
            return output;
        }

        int size = rows * columns;

        int firstRow = 0, firstCol = 0, count = 0;
        int lastRow = rows - 1, lastCol = columns - 1;

        while(count < size) {
            for(int i = firstCol; i <= lastCol; i++) {
                output.add(matrix[firstRow][i]);
                count++;
            }
            firstRow++;
            for(int i = firstRow; i <= lastRow; i++) {
                output.add(matrix[i][lastCol]);
                count++;
            }
            lastCol--;
            for(int i = lastCol; i >= firstCol; i--) {
                output.add(matrix[lastRow][i]);
                count++;
            }
            lastRow--;
            for(int i = lastRow; i >= firstRow; i--) {
                output.add(matrix[i][firstCol]);
                count++;
            }
            firstCol++;
        }

        return output;
    }

    public static void main(String[] args) {
//        int[][] matrix = {{1, 2, 3, 4}, {5, 6, 7, 8}, {9,10,11,12}};
        int[][] matrix = {
                {1, 2,  3,  4},
                {5, 6,  7,  8},
                {9, 10, 11, 12},
                {13, 14, 15, 16}};
        SpiralMatrix o = new SpiralMatrix();
        o.spiralOrder(matrix).stream().forEach(i -> System.out.printf("%d, ", i));
    }
}
