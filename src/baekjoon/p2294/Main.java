package baekjoon.p2294;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        int[] coin = new int[n];
        int[] dp = new int[k + 1];

        Arrays.fill(dp,2000000000);
        dp[0] = 0;
        for(int i=0;i<n;i++){
            coin[i] = Integer.parseInt(br.readLine());
            if(k>=coin[i])
                dp[coin[i]] = 1;
        }
        for(int i=1;i<=k;i++){
            for (int j = 0; j < coin.length; j++) {
                if(i-coin[j]<0) continue;
                dp[i] = Math.min(dp[i], dp[i-coin[j]] + 1);
            }
        }

        if(dp[k]==2000000000)
            System.out.println(-1);
        else
            System.out.println(dp[k]);
    }
}
