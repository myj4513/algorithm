package baekjoon.p11051;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    private static int[][] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        K = Math.min(N - K, K);

        dp = new int[1001][1001];
        System.out.println(recur(N,K));
    }

    static int recur(int n, int k) {
        if (dp[n][k] == 0) {
            if(k==0 || k==n) dp[n][k] = 1;
            else dp[n][k] = (recur(n-1, k-1) + recur(n-1, k))%10007;
        }
        return dp[n][k];
    }
}
