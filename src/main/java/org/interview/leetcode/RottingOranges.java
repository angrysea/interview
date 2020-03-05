package org.interview.leetcode;

import java.util.ArrayDeque;
import java.util.Queue;

public class RottingOranges {

    class Node {
        int x, y;

        Node(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
    public int orangesRotting(int[][] grid) {
        Queue<Node> queue = new ArrayDeque<>();
        int m = grid.length;
        int n = grid[0].length;
        int count = 0;
        for(int row = 0; row < m; row++) {
            for(int col = 0; col < n; col++) {
                if (grid[row][col] == 2) {
                    queue.add(new Node(row, col));
                }
                else if (grid[row][col] == 1) {
                    count++;
                }
            }
        }

        int[][] moves = {{-1, 0}, {0, 1}, {1, 0},{0, -1}};
        int res = 0;

        while(!queue.isEmpty()) {
            int size = queue.size();
            boolean update = false;
            while(size > 0) {
                Node node = queue.poll();
                for(int i = 0; i < 4; i++) {
                    int dx = node.x + moves[i][0];
                    int dy = node.y + moves[i][1];
                    if (dx >= 0 && dx < m && dy >= 0 && dy < n && grid[dx][dy] == 1) {
                        queue.add(new Node(dx, dy));
                    }
                }
                if (grid[node.x][node.y] == 1) {
                    grid[node.x][node.y] = 2;
                    update = true;
                    count--;
                }
                size--;
            }
            if (update) {
                res++;
            }
        }
        return (count == 0) ? res : -1;
    }

    public static void main(String[] args) {
        RottingOranges o = new RottingOranges();
        System.out.println(o.orangesRotting(new int[][]{{2},{1},{1},{1},{2},{1},{1}}));
        System.out.println(o.orangesRotting(new int[][]{{2,1,1},{1,1,0},{0,0,1}}));
        System.out.println(o.orangesRotting(new int[][]{{2,1,1},{1,1,0},{0,1,1}}));
    }
}
