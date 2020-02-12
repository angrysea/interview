package org.interview.leetcode;

public class RemoveAdjacentDuplicatesII {
    static public String removeDuplicates(String s, int k) {

        StringBuilder sb = new StringBuilder(s);
        int deleted = 1;

        while(deleted != 0) {
            char last = ' ';
            int repeated = 1;
            deleted = 0;
            for (int i = 0; i < sb.length(); i++) {
                if (last == sb.charAt(i - deleted)) {
                    repeated++;
                    if (repeated == k) {
                        int start = i + 1 - k - deleted;
                        sb.delete(start, start + k);
                        deleted += k;
                        repeated = 1;
                    }
                }
                else {
                    repeated = 1;
                }
                if(i >= deleted) {
                    last = sb.charAt(i - deleted);
                }
            }
            sb = new StringBuilder(sb.toString());

        }
        return sb.toString();
    }

    public static void main(String[] args) {
        String s = "deeedbbcccbdaa";
        int k = 3;
        System.out.println(removeDuplicates(s, k));
    }
}
