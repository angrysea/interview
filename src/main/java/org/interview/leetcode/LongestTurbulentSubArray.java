package org.interview.leetcode;

public class LongestTurbulentSubArray {
    static public int maxTurbulenceSize(int[] A) {
        if(A.length < 2) {
            return A.length;
        }
/*       1  -1 -1  1 -1  1 -1 -1 -1
        2  0  2  4  2  5  0  1  2  3
         -1  0 1  -1 1  -1  0 1  0
        0  1  1  0  1  0  1  1  0  0
         -1   -1   -1    1    -1    1    -1   1     -1
        0   8   45    88   48    68    28   55   17   24
 */
        int max = 0, count = 1;
        int last = 0;
        for(int i = 1; i < A.length; i++) {
            int current = Integer.compare(A[i-1], A[i]);
            if(current == 0) {
                max = Math.max(max, count);
                count = 1;
            }
            else if(last != current) {
                count++;
            }
            else {
                max = Math.max(max, count);
                count = 2;
            }
            last = current;
        }
        max = Math.max(max, count);
        return max;
    }

    public static void main(String[] args) {
        System.out.println(maxTurbulenceSize( new int[] {0,8,45,88,48,68,28,55,17,24}));//8
        System.out.println(maxTurbulenceSize( new int[] {0,1,1,0,1,0,1,1,0,0}));//5
        System.out.println(maxTurbulenceSize( new int[] {2,0,2,4,2,5,0,1,2,3}));//6
        System.out.println(maxTurbulenceSize( new int[] {9,4,2,10,7,8,8,1,9}));//5
        System.out.println(maxTurbulenceSize( new int[] {4,8,12,16}));
    }
}
