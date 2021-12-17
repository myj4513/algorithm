package baekjoon.p17626;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int[] dp = new int[N + 1];

        for(int i=1;i<=N;i++){
            int min = Integer.MAX_VALUE;
            for(int j=(int)Math.sqrt(i);j>=1;j--){
                if(dp[i-j*j]<min)
                    min = dp[i-j*j];
            }
            dp[i] = min+1;
        }
        System.out.println(dp[N]);
    }
}
