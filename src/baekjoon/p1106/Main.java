package baekjoon.p1106;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int C = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());

        int[][] promotion = new int[N + 1][2];
        int max = Integer.MIN_VALUE;
        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            promotion[i][0] = Integer.parseInt(st.nextToken());  //비용
            int num = Integer.parseInt(st.nextToken());
            promotion[i][1] = num;  //고객 수
            if(num>max) max = num;
        }

        int[] dp = new int[C + max + 1];
        Arrays.fill(dp, 1000000);
        dp[0] = 0;

        for(int i=1;i<=N;i++){
            dp[promotion[i][1]] = promotion[i][0];
        }

        for (int i = 1; i <= C + max; i++) {
            for(int j=1;j<=N;j++){
                if (i - promotion[j][1] < 0) continue;
                if(dp[i-promotion[j][1]] + promotion[j][0] < dp[i])
                    dp[i] = dp[i-promotion[j][1]] + promotion[j][0];
            }
        }

        int result = Integer.MAX_VALUE;
        for (int i = C; i <= C + max; i++) {
            if(result > dp[i]) result = dp[i];
        }
        System.out.println(result);
    }
}
