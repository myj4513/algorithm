package baekjoon.p5557;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int[] nums = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 1; i < N; i++) {
            nums[i] = Integer.parseInt(st.nextToken());
        }

        int target = Integer.parseInt(st.nextToken());

        long[][] dp = new long[21][N];

        dp[nums[1]][1] = 1;
        for (int i = 2; i < N; i++) {
            for (int j = 0; j <= 20; j++) {
                if (j - nums[i] >= 0) {
                    dp[j][i] += dp[j - nums[i]][i - 1];
                }
                if (j + nums[i] <= 20) {
                    dp[j][i] += dp[j + nums[i]][i - 1];
                }
            }
        }
//        for (int i = 0; i <= 20; i++) {
//            System.out.println(Arrays.toString(dp[i]));
//        }
        System.out.println(dp[target][N-1]);
    }
}
