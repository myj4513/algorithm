package baekjoon.p15730;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static int M;
    static int[][] pool;
    static int cnt = 0;
    static int[] dx = new int[]{0,0,-1,1};
    static int[] dy = new int[]{-1,1,0,0};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        pool = new int[N][M];
        int max = 0;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                int p = Integer.parseInt(st.nextToken());
                max = Math.max(p, max);
                pool[i][j] = p;
            }
        }

        for (int k = 0; k <= max; k++) {
            for (int i = 1; i < N - 1; i++) {
                for (int j = 1; j < M - 1; j++) {

                }
            }
        }

    }
}
