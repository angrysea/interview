package org.interview.leetcode;

import java.util.*;

public class SudokuSolver {
    static Character[] characters = {'1','2','3','4','5','6','7','8','9'};
    public void solveSudoku(char[][] board) {
        populateRow(board, 0, 0);
    }

    boolean populateRow(char[][] board, int row, int col) {
        if (row >= board.length) {
            return true;
        }

        if (col >= board[0].length) {
            return populateRow(board, row + 1, 0);
        }

        if (board[row][col] != '.') {
            return populateRow(board, row, col + 1);
        }

        Set<Character> possibleValues = getPossibleValues(board, row, col);
        for(Character c : possibleValues) {
            board[row][col] = c;
            if (populateRow(board, row, col + 1)) {
                return true;
            }
        }
        board[row][col] = '.';
        return false;
    }

    Set<Character> getPossibleValues(char[][] board, int row, int col) {
        Set<Character> available = new HashSet<>(Arrays.asList(characters));
         //Check row.
        for(int i = 0; i < board[row].length; i++){
            if (board[row][i] != '.') {
                available.remove(board[row][i]);
            }
        }

        //Check col.
        for(int i = 0; i < board.length; i++){
            if (board[i][col] != '.') {
                available.remove(board[i][col]);
            }
        }

        //Current 3x3 grid
        int dx = (row / 3) * 3;
        int dy = (col / 3) * 3;
        for(int i = dx; i < dx + 3; i++) {
            for(int j = dy; j < dy + 3; j++) {
                if (board[i][j] != '.') {
                    available.remove(board[i][j]);
                }
            }
        }

        return available;
    }

    public void printBoard(char[][] board) {
        for(int row = 0; row < board.length; row++) {
            for(int col = 0; col < board.length; col++) {
                System.out.printf("%c, ", board[row][col]);
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        SudokuSolver o = new SudokuSolver();
        char[][] board = {
            {'5','3','.','.','7','.','.','.','.'},
            {'6','.','.','1','9','5','.','.','.'},
            {'.','9','8','.','.','.','.','6','.'},
            {'8','.','.','.','6','.','.','.','3'},
            {'4','.','.','8','.','3','.','.','1'},
            {'7','.','.','.','2','.','.','.','6'},
            {'.','6','.','.','.','.','2','8','.'},
            {'.','.','.','4','1','9','.','.','5'},
            {'.','.','.','.','8','.','.','7','9'}
        };

        o.solveSudoku(board);
        o.printBoard(board);
    }
}
