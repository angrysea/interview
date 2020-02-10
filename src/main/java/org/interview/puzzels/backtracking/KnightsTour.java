package org.interview.puzzels.backtracking;

import java.util.Arrays;

public class KnightsTour {
    static int[][] moves = {{2, 1}, {1, 2}, {-1, 2}, {-2, 1}, {-2, -1}, {-1, -2}, {1, -2}, {2, -1}};

    boolean tourTheBoard(int[][] board, int N) {
        Arrays.stream(board).forEach(cols -> Arrays.fill(cols, -1));
        board[0][0] = 0;
        return tour(board, 0, 0, 1, N);
    }

    boolean tour(final int[][] board, final int row, final int col, final int count, final int N) {
        if(count == (N*N)) {
            return true;
        }

        for (int i = 0; i < 8; i++) {
            int nextRow = row + moves[i][0], nextCol = col + moves[i][1];
            if (nextRow >= 0 && nextRow < N && nextCol >= 0 &&
                    nextCol < N && board[nextRow][nextCol] == -1) {
                board[nextRow][nextCol] = count;
                if (tour(board, nextRow, nextCol, count + 1, N)) {
                    return true;
                } else {
                    board[nextRow][nextCol] = -1;
                }
            }
        }

        return false;
    }

    void printBoard(int[][] board) {
        System.out.println();
        Arrays.stream(board).forEach(cols -> {
            Arrays.stream(cols).forEach(i -> System.out.printf("%d, ", i));
            System.out.println();
        });
    }

    public static void main(String[] args) {
        KnightsTour o = new KnightsTour();
        final int N = 8;
        int[][] board = new int[N][N];

        System.out.printf("%s solvable for %d x %d board!!!!!!!!!!\n",
                o.tourTheBoard(board, N) ? "Is" : "Isn't", N, N);
        o.printBoard(board);
    }
}
