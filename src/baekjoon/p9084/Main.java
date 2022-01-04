package baekjoon.p9084;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        while (T-- > 0) {
            int N = Integer.parseInt(br.readLine());
            int[] coins = new int[N];
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int i = 0; i < N; i++) {
                coins[i] = Integer.parseInt(st.nextToken());
            }
            int M = Integer.parseInt(br.readLine());
            int[] dp = new int[M + 1];

            for (int i = 0; i < N; i++) {
                if(coins[i]>M) continue;
                dp[coins[i]]++;
                for (int j = coins[i]+1; j <= M; j++) {
                    dp[j] += dp[j - coins[i]];
                }
            }
            System.out.println(dp[M]);
        }
    }
}
