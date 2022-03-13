package baekjoon.p2056;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int N;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        int[] dp = new int[N + 1];

        for (int i = 1; i <= N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int time = Integer.parseInt(st.nextToken());
            int cnt = Integer.parseInt(st.nextToken());
            int max = 0;
            for (int j = 0; j < cnt; j++) {
                max = Math.max(max, dp[Integer.parseInt(st.nextToken())]);
            }
            dp[i] = max + time;
        }

        int max = 0;
        for (int i = 1; i <= N; i++) {
            max = Math.max(dp[i], max);
        }
        System.out.println(max);
    }
}
