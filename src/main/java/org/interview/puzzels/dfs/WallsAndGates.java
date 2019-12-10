package org.interview.puzzels.dfs;

public class WallsAndGates {
    void calculate(int[][] rooms) {
        if(rooms == null || rooms.length == 0 || rooms[0].length == 0) {
            return;
        }
        int rows = rooms.length;
        int cols = rooms[0].length;

        for(int row = 0; row < rows; row++) {
            for(int col = 0; col < cols; col++) {
                if(rooms[row][col] == 0) {
                    fillDFS(rooms, row, col, 0);
                }
            }
        }
    }

    void fillDFS(int[][] rooms, int row, int col, int distance) {
        if(row<0 || row>=rooms.length || col<0 || col >= rooms[row].length ||
                rooms[row][col] < distance)
            return;

        rooms[row][col] = distance;

        fillDFS(rooms, row-1, col, distance + 1);
        fillDFS(rooms, row, col+1, distance + 1);
        fillDFS(rooms, row+1, col, distance + 1);
        fillDFS(rooms, row, col-1, distance + 1);
    }

    public static void main(String[] args) {
        int[][] rooms = {{Integer.MAX_VALUE, -1, 0, Integer.MAX_VALUE},
                        {Integer.MAX_VALUE, Integer.MAX_VALUE, Integer.MAX_VALUE, -1},
                        {Integer.MAX_VALUE, -1, Integer.MAX_VALUE, -1},
                        {0, -1, Integer.MAX_VALUE, Integer.MAX_VALUE}};

        new WallsAndGates().calculate(rooms);

        int rows = rooms.length;
        int cols = rooms[0].length;
        for(int i = 0; i < rows; i++) {
            for(int j = 0; j < cols; j++) {
                System.out.print(rooms[i][j] + ", ");
            }
            System.out.println();
        }
    }
}
