package org.interview.puzzels;

public class ContainerWithMostWater {

    int findMaxArea(int[] height) {
        int i = 0;
        int len = height.length;
        int j = len - 1;
        int maxArea = Integer.MIN_VALUE;

        while(i < j) {
            int h = Math.min(height[i], height[j]);
            maxArea = Math.max(maxArea, h * (j - i));
            if(height[i] < height[j]) {
                i++;
            }
            else {
                j--;
            }
        }
        return maxArea;
    }

    int findMaxAreaN2(int[] heights) {
        int len = heights.length;
        int maxArea = 0;

        for(int i = 0; i < len; i++) {
            for(int j = i + 1; j < len; j++) {
                int height = Math.min(heights[i], heights[j]);
                int area = height * (j - i);
                maxArea = Math.max(maxArea, area);
            }
        }
        return maxArea;
    }

    public static void main(String[] args) {

        int[] levels = {1, 8, 6, 2, 5, 4, 8, 3, 7};
        ContainerWithMostWater containerWithMostWater = new ContainerWithMostWater();
        System.out.println(containerWithMostWater.findMaxArea(levels));
    }
}
