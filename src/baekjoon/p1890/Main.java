package baekjoon.p1890;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[][] board = new int[N + 1][N + 1];
        long[][] dp = new long[N + 1][N + 1];

        for(int i=1;i<=N;i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j=1;j<=N;j++){
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for(int i=1;i<N;i++){
            if(board[i][N] + i == N){
                dp[i][N] = 1;
            }
            if(board[N][i] + i == N){
                dp[N][i] = 1;
            }
        }

        for(int i=N;i>0;i--){
            for(int j=N;j>0;j--){
                if(dp[i][j]==1)
                    continue;
                int move = board[i][j];
                if(move + j <= N)
                    dp[i][j] += dp[i][j + move];
                if(move + i <= N)
                    dp[i][j] += dp[i + move][j];
            }
        }


        System.out.println(dp[1][1]);
    }
}
