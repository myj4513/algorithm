package baekjoon.p2156;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] wine = new int[n + 1];
        int[] dp = new int[n + 1];
        boolean[] usedPrev = new boolean[n + 1];

        for (int i = 1; i <= n; i++) {
            wine[i] = Integer.parseInt(br.readLine());
        }
        dp[1] = wine[1];
        for (int i = 2; i <= n; i++) {
            if (!usedPrev[i-1]) {
                dp[i] = dp[i - 1] + wine[i];
                usedPrev[i] = true;
            }
            else{
                if(wine[i-1]+dp[i-3] > dp[i-2]) {
                    usedPrev[i] = true;
                }
                dp[i] = Math.max(wine[i - 1] + dp[i-3], dp[i - 2]) + wine[i];
                if(dp[i-1]>dp[i]){
                    dp[i] = dp[i-1];
                    usedPrev[i] = false;
                }
            }
        }

        System.out.println(dp[n]);
    }
}
