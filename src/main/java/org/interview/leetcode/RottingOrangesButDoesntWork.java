package org.interview.leetcode;

public class RottingOrangesButDoesntWork {
    public int orangesRotting(int[][] grid) {
        boolean[][] visited = new boolean[grid.length][grid[0].length];
        boolean foundIsolated = false;
        for(int row = 0; row < grid.length; row++) {
            for(int col = 0; col < grid[row].length; col++) {
                if (grid[row][col] == 1) {
                    foundIsolated = notRottenFromHere(grid, row, col,visited);
                    if(foundIsolated) {
                        break;
                    }
                }
            }
        }

        if(foundIsolated) {
            return -1;
        }

        int max = 0;
        for(int row = 0; row < grid.length; row++) {
            for(int col = 0; col < grid[row].length; col++) {
                if (grid[row][col] == 2) {
                    max = Math.max(max, rottenFromHere(grid, row, col,visited));
                }
            }
        }
        return max;
    }

    int[][] moves = {{-1, 0}, {0, 1}, {1, 0},{0, -1}};

    boolean notRottenFromHere(int[][] grid, int row, int col, boolean[][] visited) {
        for(int i = 0; i < moves.length; i++) {
            if (foundRotten(grid,row + moves[i][0], col + moves[i][1], visited))
                return false;
        }
        return true;
    }


    int rottenFromHere(int[][] grid, int row, int col, boolean[][] visited) {
        int max = 0;
        for(int i = 0; i < moves.length; i++) {
            max = Math.max(max, bfs(grid,
                    row + moves[i][0], col + moves[i][1], 0, visited));
        }
        return max;
    }

    boolean foundRotten(int[][] grid, int row, int col, boolean[][] visited) {
        if (row < 0 || row >= grid.length || col < 0 || col >= grid[row].length
                || visited[row][col] ||grid[row][col] == 0) {
            return false;
        }

        if (grid[row][col] == 2) {
            return true;
        }

        visited[row][col] = true;

        for(int i = 0; i < moves.length; i++) {
            if (foundRotten(grid, row + moves[i][0], col + moves[i][1], visited)) {
                visited[row][col] = false;
                return true;
            }
        }
        visited[row][col] = false;
        return false;
    }


    int bfs(int[][] grid, int row, int col, int max, boolean[][] visited) {
        if (row < 0 || row >= grid.length || col < 0 || col >= grid[row].length
                || grid[row][col] != 1 || visited[row][col]) {
            return max;
        }

        visited[row][col] = true;

        int newMax = max;
        for(int i = 0; i < moves.length; i++) {
            newMax = Math.max(newMax, bfs(grid,
                    row + moves[i][0], col + moves[i][1], max + 1, visited));
        }
        visited[row][col] = false;
        return newMax;
    }

    public static void main(String[] args) {
        RottingOrangesButDoesntWork o = new RottingOrangesButDoesntWork();
        System.out.println(o.orangesRotting(new int[][]{{2},{1},{1},{1},{2},{1},{1}}));
        System.out.println(o.orangesRotting(new int[][]{{2,1,1},{1,1,0},{0,0,1}}));
        System.out.println(o.orangesRotting(new int[][]{{2,1,1},{1,1,0},{0,1,1}}));
    }
}
