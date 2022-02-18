package baekjoon.p12919;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static String S;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        S = br.readLine();
        String T = br.readLine();

        solve(new StringBuilder(T));
        System.out.println(0);
    }

    private static void solve(StringBuilder t) {
        if (t.toString().equals(S)) {
            System.out.println(1);
            System.exit(0);
        }
        t = new StringBuilder(t);
        if(t.length()<S.length()) return;

        if (t.charAt(t.length() - 1) == 'A') {
            t.deleteCharAt(t.length() - 1);
            solve(t);
            t.append('A');
        }

        if (t.charAt(0) == 'B') {
            t.deleteCharAt(0);
            t.reverse();
            solve(t);
        }

    }


}
