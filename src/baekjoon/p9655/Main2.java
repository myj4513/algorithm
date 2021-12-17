package baekjoon.p9655;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        boolean[] dp = new boolean[N + 1];
        Arrays.fill(dp, false);

        for(int i=1;i<=N;i++){
            if(!dp[i-1]){
                dp[i] = true;
            }
            if (i - 3 >= 0 && !dp[i - 3]) {
                dp[i] = true;
            }
        }
        if(dp[N]){
            System.out.println("SK");
        }
        else
            System.out.println("CY");
    }
}
