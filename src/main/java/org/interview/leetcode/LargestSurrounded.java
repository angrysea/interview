package org.interview.leetcode;

public class LargestSurrounded {
    int [][] m = new int[][] {{0, 1}, {0,-1}, {1,0}, {-1,0}};
    int findLargestSurrounded(char[][] matrix) {
        boolean[][] visited = new boolean[matrix.length][matrix[0].length];
        return dfs(matrix, visited, 0, 0);
    }

    int dfs(char[][] matrix, boolean[][] visited, int row, int col) {
        if(row < 0 || col < 0 || row >= matrix.length || col >= matrix[0].length
        || visited[row][col] == true) {
            return 0;
        }

        visited[row][col] = true;
        for(int i = 0; i < m.length; i++) {
            dfs(matrix, visited, row + m[i][0], col + m[i][1]);
        }
        return 0;
    }

    public static void main(String[] args) {
        char[][] matrix = new char[][] {
                {'X', 'O', 'X', 'X', 'X', 'X'},
                {'X', 'O', 'X', 'X', 'O', 'X'},
                {'X', 'X', 'X', 'O', 'O', 'X'},
                {'O', 'X', 'X', 'X', 'X', 'X'},
                {'X', 'X', 'X', 'O', 'X', 'O'},
                {'O', 'O', 'X', 'O', 'O', 'O'}
        };

        LargestSurrounded o = new LargestSurrounded();
        System.out.println(o.findLargestSurrounded(matrix));
    }
}
