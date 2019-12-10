package org.interview.leetcode;

public class MagicSquares {

    int solve(int[][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;
        int totalGridsFound = 0;
        for(int i = 1; i < rows - 1; i++) {
            for(int j = 1; j < cols - 1; j++) {
                if(isMagic(
                        grid[i-1][j-1], grid[i-1][j], grid[i-1][j+1],
                        grid[i][j-1], grid[i][j], grid[i][j+1],
                        grid[i+1][j-1], grid[i+1][j], grid[i+1][j+1])) {
                    totalGridsFound++;
                }
            }
        }
        return totalGridsFound;
    }

    boolean isMagic(int ... arr) {
        int[] count = new int[9];
        for(int v : arr) {
            if (v < 10) {
                count[v-1]++;
            }
        }

        for(int v = 0; v < 9; ++v) {
            if(count[v] != 1) {
                return false;
            }
        }

        int sum = arr[0] + arr[1] + arr[2];
        return (arr[3] + arr[4] + arr[5] == sum &&
                arr[6] + arr[7] + arr[8] == sum &&
                arr[0] + arr[3] + arr[6] == sum &&
                arr[1] + arr[4] + arr[7] == sum &&
                arr[2] + arr[5] + arr[8] == sum &&
                arr[0] + arr[4] + arr[8] == sum &&
                arr[2] + arr[4] + arr[6] == sum);
    }

    static public void main(String[] args) {
        int[][] input = {
                {4, 3, 8, 4},
                {9, 5, 1, 9},
                {2, 7, 6, 2}
        };
        System.out.printf("Number of magic squares %d.\n", new MagicSquares().solve(input));
    }
}
