package org.interview.leetcode;

public class SimplifyPath {
    String simplify(String path) {
        String[] parts = path.split("/");
        int size = parts.length;
        int j = 0;
        for(int i = 0; i < size; i++) {
            if("..".equals(parts[i])) {
                if(j > 0) {
                    j--;
                }
            }
            else if(!".".equals(parts[i]) && parts[i].length()>0){
                parts[j++] = parts[i];
            }
        }
        j--;

        StringBuilder sb = new StringBuilder("/");
        for(int i = 0; i <= j; i++) {
            sb.append(parts[i]);
            if(i < j) {
                sb.append("/");
            }
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        SimplifyPath o = new SimplifyPath();
        String s1 = "/home/";
        System.out.printf("%s simplified %s\n", s1, o.simplify(s1));
        String s2 = "/../";
        System.out.printf("%s simplified %s\n", s2, o.simplify(s2));
        String s3 = "/a/./b/../../c/";
        System.out.printf("%s simplified %s\n", s3, o.simplify(s3));
        String s4 = "/a//b////c/d//././/..";
        System.out.printf("%s simplified %s\n", s4, o.simplify(s4));
        String s5 = "/a/../../b/../c//.//";
        System.out.printf("%s simplified %s\n", s5, o.simplify(s5));
    }
}
