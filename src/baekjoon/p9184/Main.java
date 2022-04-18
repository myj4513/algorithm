package baekjoon.p9184;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    private static int[][][] dp;

    public static void main(String[] args) throws IOException {
        int N = 101;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        dp = new int[N][N][N];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                Arrays.fill(dp[i][j], Integer.MAX_VALUE);
            }
        }
        StringBuilder sb = new StringBuilder();
        while (true) {
            String s = br.readLine();
            if (s.equals("-1 -1 -1")) break;
            StringTokenizer st = new StringTokenizer(s);
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            sb.append("w(").append(a).append(", ").append(b).append(", ").append(c).append(") = ").append(recur(a, b, c)).append('\n');

        }
        System.out.print(sb);
    }

    public static int recur(int a, int b, int c) {

        if (dp[a+50][b+50][c+50] != Integer.MAX_VALUE) {
            return dp[a+50][b+50][c+50];
        }
        if (a <= 0 || b <= 0 || c <= 0) {
            dp[a+50][b+50][c+50] = 1;
            return 1;
        }
        if (a > 20 || b > 20 || c > 20) {
            dp[a+50][b+50][c+50] = recur(20,20,20);
            return dp[a+50][b+50][c+50];
        }
        if (a < b && b < c) {
            dp[a+50][b+50][c+50] = recur(a, b, c - 1) + recur(a, b - 1, c - 1) - recur(a, b - 1, c);
            return dp[a+50][b+50][c+50];
        }
        dp[a+50][b+50][c+50] = recur(a-1, b, c) + recur(a-1, b-1, c) + recur(a-1, b, c-1) - recur(a-1, b-1, c-1);
        return dp[a+50][b+50][c+50];
    }
}
