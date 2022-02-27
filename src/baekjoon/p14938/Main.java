package baekjoon.p14938;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int R = Integer.parseInt(st.nextToken());
        int[] items = new int[N];
        int[][] dp = new int[N][N];

        for (int i = 0; i < N; i++) {
            Arrays.fill(dp[i], 100000);
            dp[i][i] = 0;
        }

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            items[i] = Integer.parseInt(st.nextToken());
        }

        for (int i = 0; i < R; i++) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken()) - 1;
            int to = Integer.parseInt(st.nextToken()) - 1;
            int cost = Integer.parseInt(st.nextToken());
            dp[from][to] = cost;
            dp[to][from] = cost;
        }

        for (int k = 0; k < N; k++)
            for (int i = 0; i < N; i++)
                for (int j = 0; j < N; j++) {
                    dp[i][j] = Math.min(dp[i][j], dp[i][k] + dp[k][j]);
                }

        int max = Integer.MIN_VALUE;
        for (int i = 0; i < N; i++) {
            int itemCnt = 0;
            for (int j = 0; j < N; j++) {
                if (dp[i][j] <= M) {
                    itemCnt += items[j];
                }
            }
            max = Math.max(itemCnt, max);
        }
        System.out.println(max);
    }
}
