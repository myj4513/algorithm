package baekjoon.p2407;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        if(m>n/2){
            m = n-m;
        }
        long[] dp = new long[n+1];
        dp[0] = 1;
        for(int i=1;i<=m;i++){
            dp[i] = dp[i-1] * (n-i+1) / i;
        }

        System.out.println(dp[m]);
    }
}