package baekjoon.p2624;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        int K = Integer.parseInt(br.readLine());

        int[] P = new int[K+1];
        int[] N = new int[K+1];

        for (int i = 1; i <= K; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            P[i] = Integer.parseInt(st.nextToken());
            N[i] = Integer.parseInt(st.nextToken());
        }

        int[][] dp = new int[K+1][T + 1];
        dp[0][0] = 1;
        for (int i = 1; i <= K; i++) {
            dp[i][0] = 1;
            for (int j = 1; j <= T; j++) {
                for (int l = 0; l <= N[i]; l++) {
                    if (j - P[i] * l < 0) {
                        continue;
                    }
                    dp[i][j] += dp[i-1][j-P[i]*l];
                }

            }
        }
//        for (int i = 0; i <= K; i++) {
//            System.out.println(Arrays.toString(dp[i]));
//        }
        System.out.println(dp[K][T]);
    }
}
