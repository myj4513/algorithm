package baekjoon.p22869;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int[] stone = new int[N + 1];
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            stone[i] = Integer.parseInt(st.nextToken());
        }

        boolean[] dp = new boolean[N + 1];
        dp[1] = true;
        for (int i = 2; i <= N; i++) {
            for (int j = i - 1; j >= 1; j--) {
                if (dp[j] && (i - j) * (1 + Math.abs(stone[j] - stone[i])) <= K) {
                    dp[i] = true;
                    break;
                }
            }
        }
        System.out.println(dp[N]?"YES":"NO");
    }
}

