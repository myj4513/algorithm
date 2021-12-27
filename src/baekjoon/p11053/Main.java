package baekjoon.p11053;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] A = new int[N+1];
        int[] dp = new int[N+1];
        dp[1] = 1;

        for (int i = 1; i <= N; i++) {
            int max = -1;
            A[i] = Integer.parseInt(st.nextToken());
            for(int j=0;j<i;j++){
                if(A[j]<A[i] && dp[j]>max)
                    max = dp[j];
            }
            dp[i] = max+1;
        }
        int max = 0;
        for(int i=1;i<=N;i++){
            if(dp[i]>max)
                max = dp[i];
        }
        System.out.println(max);
    }
}
