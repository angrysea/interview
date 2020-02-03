package org.interview.bits;

public class FindIntegerInArray {

    int findInteger(int[] arr) {
        int value = 0;
        for (int item : arr) {
            value ^= item;
        }
        return value;
    }

    static public void main(String[] args) {
        FindIntegerInArray o = new FindIntegerInArray();
        int[] arr = new int[] {1,12,9,5,9,12,1};
        System.out.println(o.findInteger(arr));
    }
}
