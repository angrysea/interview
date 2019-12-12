package org.interview.puzzels;

public class HappyPancake {

    private void solve(int k, char[] s ) {
        int res = 0;
        System.out.println(s);
        for (int i = 0; i <= s.length - k; i++) {
            if (s[i] == '-') {
                res++;
                for (int j = 0; j < k; j++) {
                    s[i + j] = s[i + j] == '+' ? '-' : '+';
                }
                System.out.println(s);
            }
        }
        for (char c : s) {
            if (c == '-') {
                System.out.println("IMPOSSIBLE");
                return;
            }
        }
        System.out.println("No of flips: " + res);
    }

    public static void main(String[] args) {
        final String a = "------++--+---+-++--";
        final String b = "+++++";
        final String c = "-+-+-";

        HappyPancake hp = new HappyPancake();
        hp.solve(3, a.toCharArray());
        hp.solve(4, b.toCharArray());
        hp.solve(4, c.toCharArray());
    }
}
