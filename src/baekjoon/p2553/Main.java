package baekjoon.p2553;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int[] dp = new int[20001];
        dp[0] = dp[1] = 1;
        dp[2] = 2;
        dp[3] = 6;
        dp[4] = 4;
        for (int i = 5; i <= N; i++) {
            if (i % 5 == 0) {
                dp[i] = (dp[i / 5] * (int) Math.pow(2, (i / 5) % 4)) % 10;
            } else {
                int before = i/5*5;
                int total=1;
                for (int j = i; j > before; j--) {
                    total *= j%10;
                }
                total *= dp[before];
                dp[i] = total%10;
            }
        }
        System.out.println(dp[N]);
    }
}
