package baekjoon.p2224;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static final int SIZE = 58;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int N = Integer.parseInt(br.readLine());

        int[][] dp = new int[SIZE][SIZE];
        for (int i = 0; i < N; i++) {
            String str = br.readLine();
            int from = str.charAt(0)-'A';
            int to = str.charAt(5)-'A';
            dp[from][to] = 1;
        }

        for (int k = 0; k < SIZE; k++) {
            for (int i = 0; i < SIZE; i++) {
                for (int j = 0; j < SIZE; j++) {
                    if (dp[i][j] == 1) {
                        continue;
                    }
                    if (dp[i][k] != 0 && dp[k][j] != 0) {
                        dp[i][j] = 1;
                    }
                }
            }
        }
        int count = 0;
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                if(i==j) continue;
                if (dp[i][j] == 1) {
                    count++;
                    sb.append((char)(i+'A')).append(" => ").append((char)(j+'A')).append("\n");
                }
            }
        }
        sb.insert(0, count + "\n");
        System.out.println(sb);
    }
}
