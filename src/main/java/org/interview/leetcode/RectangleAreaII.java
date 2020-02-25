package org.interview.leetcode;

public class RectangleAreaII {
    static long findTheArea(int[][] rectangles) {

        long result = 0L;

        for(int i = 0; i < rectangles.length; i++) {
            result += area(rectangles[i]);
        }

        for(int i = 0; i < rectangles.length - 1; i++) {
            for (int j = i + 1; j < rectangles.length; j++) {
                result -= areaOfOverlap(rectangles[i], rectangles[j]);
            }
        }
        return result;
    }

    static long area(int[] rect) {
        return Math.abs(rect[0] - rect[2]) *
                Math.abs(rect[1] - rect[3]);

    }
    static long areaOfOverlap(int[] rectA, int [] rectB) {
        return (Math.min(rectA[2], rectB[2]) - Math.max(rectA[0], rectB[0])) *
                (Math.min(rectA[3], rectB[3]) - Math.max(rectA[1], rectB[1]));

    }
    
    public static void main(String[] args) {
        int[][] rectagles = {{0,0,2,2},{1,0,2,3},{1,0,3,1}};
        System.out.println(findTheArea(rectagles));
    }
}
