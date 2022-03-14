package baekjoon.p9657;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        boolean[] dp = new boolean[N + 5];
        dp[1] = true;
        dp[3] = true;
        dp[4] = true;
        for (int i = 1; i < N; i++) {
            if (!dp[i]) {
                dp[i + 1] = true;
                dp[i + 3] = true;
                dp[i + 4] = true;
            }
        }
        if (dp[N]) {
            System.out.println("SK");
        } else
            System.out.println("CY");
    }
}
