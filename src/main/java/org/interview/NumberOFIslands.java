package org.interview;

import java.util.Objects;

public class NumberOFIslands {
    public int numIslands(char[][] grid) {
        int numIslands = 0;
        Objects.requireNonNull(grid);
        if (grid.length == 0) {
            return 0;
        }

        for(int row = 0; row < grid.length; row++) {
            for(int col = 0; col < grid[row].length; col++) {
               if(grid[row][col] == '1') {
                   numIslands += dfs(grid, row, col);
                }
            }
        }
        return numIslands;
    }

    int dfs(char[][] grid, int row, int col) {

        if (row < 0 || row >= grid.length ||
                col < 0 || col >= grid[row].length || grid[row][col] == '0') {
            return 0;
        }
        grid[row][col] = '0';
        dfs(grid, row, col + 1);
        dfs(grid, row, col - 1);
        dfs(grid, row + 1, col);
        dfs(grid, row - 1, col);

        return 1;
    }

    public static void main(String[] args) {
        int cols = 5; int rows = 4;
        char[][] grid = new char[rows][cols];
        for(int row = 0; row < grid.length; row++) {
            for (int col = 0; col < grid[row].length; col++) {
                grid[row][col] = '0';
            }
        }

        grid[0][0] = '1';
        grid[1][0] = '1';
        grid[2][0] = '1';
        grid[3][0] = '1';

        grid[0][1] = '1';
        grid[1][1] = '1';
        grid[3][1] = '1';

        grid[0][2] = '1';
        grid[1][2] = '1';

        System.out.println(new NumberOFIslands().numIslands(grid));
    }
}
