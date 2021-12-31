package baekjoon.p21317;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;

        int N = Integer.parseInt(br.readLine());

        int[][] energy = new int[N][2];

        for (int i = 1; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            energy[i][0] = Integer.parseInt(st.nextToken());
            energy[i][1] = Integer.parseInt(st.nextToken());
        }
        int K = Integer.parseInt(br.readLine());

        int[][] dp = new int[N + 3][2];

        if (N > 1) {
            dp[2][0] = energy[1][0];
        }

        for (int i = 3; i <= N; i++) {
            dp[i][0] = Math.min(dp[i - 1][0] + energy[i - 1][0], dp[i - 2][0] + energy[i - 2][1]);
        }

        dp[2][1] = dp[2][0];
        dp[3][1] = dp[3][0];


        for (int i = 4; i <= N; i++) {
            dp[i][1] = Math.min(Math.min(dp[i - 1][1] + energy[i - 1][0], dp[i - 3][0] + K), dp[i - 2][1] + energy[i - 2][1]);
        }

        System.out.println(Math.min(dp[N][0], dp[N][1]));
    }
}
