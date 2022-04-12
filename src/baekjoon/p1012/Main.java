package baekjoon.p1012;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static int M;
    static boolean[][] arr;
    static int[] dr = new int[]{-1,1,0,0};
    static int[] dc = new int[]{0,0,-1,1};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());
        while (T-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            M = Integer.parseInt(st.nextToken());
            N = Integer.parseInt(st.nextToken());
            int K = Integer.parseInt(st.nextToken());
            arr = new boolean[N][M];
            for (int i = 0; i < K; i++) {
                StringTokenizer st2 = new StringTokenizer(br.readLine());
                int x = Integer.parseInt(st2.nextToken());
                int y = Integer.parseInt(st2.nextToken());
                arr[y][x] = true;
            }
            int cnt = 0;
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < M; j++) {
                    if (arr[i][j]) {
                        arr[i][j] = false;
                        solve(i,j);
                        cnt++;
                    }
                }
            }
            sb.append(cnt).append('\n');
        }
        System.out.println(sb);
    }

    private static void solve(int r, int c) {
        for (int i = 0; i < 4; i++) {
            int rr = r+dr[i];
            int cc = c+dc[i];
            if (0 <= rr && rr < N && 0 <= cc && cc < M && arr[rr][cc]) {
                arr[rr][cc] = false;
                solve(rr,cc);
            }
        }

    }
}
