package baekjoon.p2228;

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

        int[] arr = new int[N + 1];
        for (int i = 1; i <= N; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        int[][] dp = new int[N + 1][N + 1];
        for (int i = 1; i <= N; i++) {
            for (int j = i; j <= N; j++) {
                dp[i][j] = arr[j] + dp[i][j - 1];
            }
        }

        int max = -1;
        for (int i = 1; i <= M; i++) {
            for (int j = i + 2; j <= M; j++) {
                max = Math.max(dp[i])
            }
        }

        for (int i = 0; i <= M; i++) {
            System.out.println(Arrays.toString(dp[i]));

        }
    }
}
