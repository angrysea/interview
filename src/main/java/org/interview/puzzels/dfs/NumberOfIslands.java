package org.interview.puzzels.dfs;

import java.util.Objects;

public class NumberOfIslands {
    int [][] m = new int[][] {{0, 1}, {0,-1}, {1,0}, {-1,0}};

    public int numIslands(int[][] grid) {
        int numIslands = 0;
        Objects.requireNonNull(grid);
        if (grid.length == 0) {
            return 0;
        }

        for(int row = 0; row < grid.length; row++) {
            for(int col = 0; col < grid[row].length; col++) {
               if(grid[row][col] == 1) {
                   numIslands += dfs(grid, row, col);
                }
            }
        }
        return numIslands;
    }

    int dfs(int[][] grid, int row, int col) {

        if (row < 0 || row >= grid.length || col < 0 || col >= grid[row].length || grid[row][col] == 0) {
            return 0;
        }

        grid[row][col] = 0;

        for(int i = 0; i < m.length; i++) {
            dfs(grid, row + m[i][0], col + + m[i][1]);
        }
        return 1;
    }

    public static void main(String[] args) {
        int[][] grid = {
                {1, 1, 0, 0, 0},
                {0, 1, 0, 0, 1},
                {1, 0, 0, 1, 1},
                {0, 0, 0, 0, 0},
                {1, 0, 1, 0, 1}
        };
        System.out.println(new NumberOfIslands().numIslands(grid));
    }
}
