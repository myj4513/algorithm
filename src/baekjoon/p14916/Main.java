package baekjoon.p14916;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int[] dp = new int[n + 1];

        for (int i = 1; i <= n; i++) {
            if (i - 2 < 0) {
                dp[i] = -1;
                continue;
            }
            if (i - 5 < 0) {
                dp[i] = i % 2 == 0 ? i / 2 : -1;
                continue;
            }
            dp[i] = dp[i - 2] == -1 ? (dp[i - 5] == -1 ? -1 : dp[i - 5] + 1) : (dp[i - 5] == -1 ? dp[i - 2] + 1 : Math.min(dp[i - 2], dp[i - 5]) + 1);
        }
        System.out.println(dp[n]);
    }
}
