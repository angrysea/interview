package org.interview.leetcode;

import java.util.ArrayList;
import java.util.List;

public class NQueens {
    boolean isSafe(boolean[][] board, int row, int col, int n) {

        // check if there is a queen in this col
        for(int i = 0; i < n; i++) {
            if(board[row][i]) {
                return false;
            }
        }

        // Check north east diagonal
        for(int i = row, j = col; i >= 0 && j < col; i++, j++) {
            if(board[i][j]) {
                return false;
            }
        }

        // Check north west diagonal
        for(int i = row, j = col; i >= 0 && j >= 0; i--, j--) {
            if(board[i][j]) {
                return false;
            }
        }

        // Check south west diagonal
        for(int i = row, j = col; i < n && j >= 0; i++, j--) {
            if(board[i][j]) {
                return false;
            }
        }
        return true;
    }

    void computeOutput(boolean[][] dp, List<List<String>> output, int n) {
        List<String> results = new ArrayList<>();
        int count = 0;
        for (int j = 0; j < n; j++) {
            StringBuilder queens = new StringBuilder();
            for (int k = 0; k < n; k++) {
                if (dp[j][k]) {
                    queens.append('Q');
                    count++;
                } else {
                    queens.append('.');
                }
            }
            results.add(queens.toString());
        }
        if (count >= n) {
            output.add(results);
        }
    }

    boolean solveTheBoard(boolean[][] board, int col, List<List<String>> output, int n) {
        if (col >= n) {
            return true;
        }

        for (int i = 0; i < n; i++) {
            if (isSafe(board, i, col, n)) {
                board[i][col] = true;
                if (solveTheBoard(board,col + 1, output, n)) {
                    computeOutput(board, output, n);
                }
                board[i][col] = false;
            }
        }
        return false;
    }

    public List<List<String>> solveNQueens(int n) {
        List<List<String>> output = new ArrayList<>();
        boolean[][] board = new boolean[n][n];
        if (solveTheBoard(board, 0, output, n)) {
            computeOutput(board, output, n);
        }
        return output;
    }

    public static void main(String[] args) {
        NQueens o = new NQueens();
        List<List<String>> output = o.solveNQueens(5);
        for(List<String> list : output) {
            for (String row : list) {
                System.out.println(row);
            }
            System.out.println("======================================================");
        }
    }
}
