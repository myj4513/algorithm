package baekjoon.p2579;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int[] stairs = new int[N+1];
        int[] dp = new int[N+1];
        boolean[] prevUsed = new boolean[N+1];

        for(int i=1;i<=N;i++){
            stairs[i] = Integer.parseInt(br.readLine());
        }
        if(N==1){
            System.out.println(stairs[1]);
            return;
        }
        if(N==2){
            System.out.println(stairs[1] + stairs[2]);
            return;
        }

        dp[1] = stairs[1];
        dp[2] = dp[1] + stairs[2];
        prevUsed[2] = true;

        for(int i=3;i<=N;i++){
            if(prevUsed[i-1]){
                if (stairs[i - 1] + dp[i - 3] > dp[i - 2]) {
                    prevUsed[i] = true;
                    dp[i] = stairs[i - 1] + dp[i - 3] + stairs[i];
                }
                else{
                    dp[i] = dp[i - 2] + stairs[i];
                }
            }
            else{
                if (dp[i - 1] > dp[i - 2]) {
                    prevUsed[i] = true;
                    dp[i] = dp[i - 1] + stairs[i];
                }
                else{
                    dp[i] = dp[i - 2] + stairs[i];
                }
            }
        }
        System.out.println(dp[N]);
    }
}
