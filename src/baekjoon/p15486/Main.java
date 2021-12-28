package baekjoon.p15486;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int[][] consulting = new int[N + 2][2];
        for(int i=1;i<=N;i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j=0;j<2;j++){
                consulting[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int[] dp = new int[N+2];

        for(int i=1;i<=N+1;i++){
            int T = consulting[i][0];
            int P = consulting[i][1];
            dp[i] = Math.max(dp[i], dp[i-1]);
            if(i+T>N+1) continue;
            dp[i+T] = Math.max(dp[i+T], P+dp[i]);
        }

        System.out.println(dp[N+1]);
    }
}
