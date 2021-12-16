package baekjoon.p1010;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringTokenizer st = null;
        for(int i=0;i<T;i++){
            st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());
            if(N>M/2) N = M - N;
            long[] dp = new long[M/2+1];
            dp[0] = 1;
            for(int j=1;j<=N;j++){
                dp[j] = dp[j-1] * (M-j+1)/j;
            }
            System.out.println(dp[N]);
        }
    }
}
