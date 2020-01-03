package org.interview.puzzels.backtracking;

public class PlaceNumberOfQueens {

    boolean placeNQueens(int[][] board, int N) {
        if(N == 0) {
            return false;
        }
        return solveNQueens(board, 0, N);
    }

    boolean solveNQueens(int[][] board, int col, int N) {
        if (col >= N) {
            return true;
        }

        for(int i = 0; i < N; i++) {
            if(isSafe(board, i, col, N)) {
                board[i][col] = 1;
                System.out.printf("Moving foward col: %d N: %d queens.\n", col, N);
                printSolution(board, N);
                if(solveNQueens(board, col + 1, N)) {
                    return true;
                }
                board[i][col] = 0;
                System.out.printf("Backtracking col: %d N: %d queens.\n", col, N);
                printSolution(board, N);
            }
        }
        return false;
    }

    boolean solveNQueensOpt(int[][] board, int col, int N) {
        if (col >= N) {
            return true;
        }

        int []ld = new int[30];
        int []rd = new int[30];
        int []cl = new int[30];

        for(int i = 0; i < N; i++) {
            if ((ld[i - col + N - 1] != 1 && rd[i + col] != 1) && cl[i] != 1) {
                board[i][col] = 1;
                ld[i - col + N - 1] = rd[i + col] = cl[i] = 1;
                System.out.printf("Moving foward col: %d N: %d queens.\n", col, N);
                printSolution(board, N);
                if(solveNQueens(board, col + 1, N)) {
                    return true;
                }
                board[i][col] = 0;
                ld[i - col + N - 1] = rd[i + col] = cl[i] = 0;
                System.out.printf("Backtracking col: %d N: %d queens.\n", col, N);
                printSolution(board, N);
            }
        }
        return false;
    }

    boolean isSafe(int[][]board, int row, int col, int N) {
        //Fist check to see if there is a queen in this row
        for(int i = 0; i < col; i++) {
            if(board[row][i] == 1) {
                return false;
            }
        }

        for(int i = row, j = col; i >= 0 && j >= 0; i--, j--) {
            if(board[i][j] == 1) {
                return false;
            }
        }

        for(int i = row, j = col; i < N && j >= 0; i++, j--) {
            if(board[i][j] == 1) {
                return false;
            }
        }

        return true;
    }

    void printSolution(int board[][], int N) {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                System.out.printf(" %d, ", board[i][j]);
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        PlaceNumberOfQueens o = new PlaceNumberOfQueens();
        final int N = 4;
        int[][] board = new int[N][N];
        System.out.printf("%s solvable for %d queens!!!!!!!!!!\n",
                    o.placeNQueens(board, N) ? "Is" : "Isn't", N);
    }
}
