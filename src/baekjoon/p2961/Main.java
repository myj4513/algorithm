package baekjoon.p2961;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static int[] S;
    static int[] B;
    static int min = Integer.MAX_VALUE;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        S = new int[N];
        B = new int[N];

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            S[i] = Integer.parseInt(st.nextToken());
            B[i] = Integer.parseInt(st.nextToken());
        }

        solve(0, 1, 0, false);
        System.out.println(min);
    }

    private static void solve(int idx, int ss, int bb, boolean used) {
        if (idx == N) {
            if(used)
                min = min > Math.abs(ss - bb) ? Math.abs(ss - bb) : min;
            return;
        }

        solve(idx + 1, ss*S[idx], bb+B[idx], true);
        solve(idx + 1, ss, bb, used);
    }
}
