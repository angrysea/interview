package org.interview.leetcode;

public class MedianOfTwoSortedArrays {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int[] merged = new int[nums1.length + nums2.length];
        int i = 0, j = 0, k = 0;
        while (j < nums1.length && k < nums2.length) {
            if (nums1[j] < nums2[k]) {
                merged[i++] = nums1[j++];
            } else {
                merged[i++] = nums2[k++];
            }
        }
        while (j < nums1.length) {
            merged[i++] = nums1[j++];
        }

        while (k < nums2.length) {
            merged[i++] = nums2[k++];
        }

        double median = 0.0d;
        int x = merged.length / 2;
        if(merged.length % 2 == 0) {
            median = (merged[x - 1] + merged[x]) / 2.0d;
        }
        else {
            median = merged[x];
        }
        return median;
    }

    static public void main(String[] args) {
        int[] nums1 = {1, 3};
        int[] nums2 = {2};
        System.out.println(new MedianOfTwoSortedArrays().findMedianSortedArrays(nums1, nums2));
    }
}
