package org.interview.leetcode;

public class LargestSurrounded {
    int [][] m = new int[][] {{0, 1}, {0,-1}, {1,0}, {-1,0}};
    int maxAreaOfIsland(int[][] grid) {
        if (grid == null) {
            return 0;
        }
        int max = 0;
        for(int row = 0; row < grid.length; row++) {
            for(int col = 0; col < grid[row].length; col++) {
                if (grid[row][col] == 1) {
                    max = Math.max(max, dfs(grid, row, col, 0));
                }
            }
        }
        return max;
    }

    int dfs(int[][] grid, int row, int col, int max) {
        if(row < 0 || col < 0 || row >= grid.length || col >= grid[0].length || grid[row][col] != 1) {
            return max;
        }

        max++;
        grid[row][col] = 0;

        if (row == 1 && col > 6) {
            System.out.println();
        }
        for(int i = 0; i < m.length; i++) {
            max = dfs(grid,row + m[i][0], col + m[i][1], max);
        }
        return max;
    }

    public static void main(String[] args) {
        int[][] matrix = {
                {0,0,1,0,0,0,0,1,0,0,0,0,0},
                {0,0,0,0,0,0,0,1,1,1,0,0,0},
                {0,1,1,0,1,0,0,0,0,0,0,0,0},
                {0,1,0,0,1,1,0,0,1,0,1,0,0},
                {0,1,0,0,1,1,0,0,1,1,1,0,0},
                {0,0,0,0,0,0,0,0,0,0,1,0,0},
                {0,0,0,0,0,0,0,1,1,1,0,0,0},
                {0,0,0,0,0,0,0,1,1,0,0,0,0}
        };

        LargestSurrounded o = new LargestSurrounded();
        System.out.println(o.maxAreaOfIsland(matrix));
    }
}
