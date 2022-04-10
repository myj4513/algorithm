package baekjoon.p2616;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] trains = new int[N + 1];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            trains[i] = trains[i - 1] + Integer.parseInt(st.nextToken());
        }
        int K = Integer.parseInt(br.readLine());
        int[][] dp = new int[4][N + 1];
        for (int i = 1; i <= 3; i++) {
            for (int j = i * K; j <= N; j++) {
                dp[i][j] = Math.max(dp[i][j - 1], dp[i - 1][j - K] + trains[j] - trains[j - K]);
            }
        }
        System.out.println(dp[3][N]);
    }
}
