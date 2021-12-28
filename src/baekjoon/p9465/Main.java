package baekjoon.p9465;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        while(T-->0){
            int n = Integer.parseInt(br.readLine());
            int[][] points = new int[n+1][2];
            for(int i=0;i<2;i++){
                StringTokenizer st = new StringTokenizer(br.readLine());
                for(int j=1;j<=n;j++){
                    points[j][i] = Integer.parseInt(st.nextToken());
                }
            }

            int[][] dp = new int[n+1][2];
            dp[1] = points[1];
            for(int i=2;i<=n;i++){
                dp[i][0] = Math.max(dp[i-1][1],dp[i-2][1]) + points[i][0];
                dp[i][1] = Math.max(dp[i-1][0],dp[i-2][0]) + points[i][1];
            }

            System.out.println(Math.max(dp[n][1], dp[n][0]));

        }
    }
}
