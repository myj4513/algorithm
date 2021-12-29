package baekjoon.p2156;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] wine = new int[n + 2];
        int[] dp = new int[n + 2];

        for (int i = 1; i <= n; i++) {
            wine[i] = Integer.parseInt(br.readLine());
        }
        dp[1] = wine[1];
        dp[2] = wine[1] + wine[2];
        for (int i = 3; i <= n; i++) {
            dp[i] = Math.max(Math.max(wine[i - 1] + dp[i - 3], dp[i - 2]) + wine[i], dp[i - 1]);
        }

        System.out.println(dp[n]);
    }
}
