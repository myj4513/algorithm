package baekjoon.p1463;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int X = Integer.parseInt(br.readLine());

        int[] dp = new int[X + 1];
        dp[1] = 0;
        for(int i=2;i<=X;i++){
            int min = Integer.MAX_VALUE;
            if(i%3==0 && min>dp[i/3])
                min = dp[i/3];
            if(i%2==0 && min>dp[i/2])
                min = dp[i/2];
            if(min>dp[i-1])
                min = dp[i-1];
            dp[i] = min+1;
        }
        System.out.println(dp[X]);
    }
}
