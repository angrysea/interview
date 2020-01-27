package org.interview.leetcode;

public class Search2DMatrix {
    public boolean searchMatrix(int[][] matrix, int target) {
        if(matrix.length == 0 || matrix[0].length == 0) {
            return false;
        }

        int row = 0;
        for (; row < matrix.length; row++) {
            if(matrix[row][0] > target) {
                if(row == 0 ) {
                    return false;
                }
                row--;
                break;
            }
            else if(row == matrix.length - 1) {
                break;
            }
        }

        for(int col = 0; col < matrix[row].length; col++){
            if(matrix[row][col] == target) {
                return true;
            }
            if(matrix[row][col] > target) {
                break;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        Search2DMatrix o = new Search2DMatrix();
        int[][] matrix = new int[][]{{1,3,5,7},{10,11,16,20},{23,30,34,50}};
        int target = 3;
        System.out.printf("target %s is in matrix %b.\n", target, o.searchMatrix(matrix, target));
        matrix = new int[][]{{1}};
        target = 1;
        System.out.printf("target %s is in matrix %b.\n", target, o.searchMatrix(matrix, target));
    }
}
