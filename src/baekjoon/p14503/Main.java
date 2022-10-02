package baekjoon.p14503;

/**
 * 백준 14503번
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    private static final int[][] dir = new int[][]{{-1, 0}, {0, 1}, {1, 0}, {0, -1}};
    private static int N;
    private static int M;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        int r = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());
        int d = Integer.parseInt(st.nextToken());
        boolean[][] room = new boolean[N][M]; //벽이면 false, 아니면 true
        boolean[][] isCleaned = new boolean[N][M];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                room[i][j] = Integer.parseInt(st.nextToken()) == 1 ? false : true;
            }
        }
        int answer = 0;
        while (true) {
            if (!isCleaned[r][c]) { //청소한다.
                answer++;
                isCleaned[r][c] = true;
            }
            boolean hasWork = false;
            int nextR = -1;
            int nextC = -1;
            for (int i = 0; i < 4; i++) {
                d = (d + 3) % 4;
                nextR = r + dir[d][0];
                nextC = c + dir[d][1];
                if (room[nextR][nextC] && !isCleaned[nextR][nextC]) {
                    hasWork = true;
                    break;
                }
            }
            if (hasWork) {
                r = nextR;
                c = nextC;
                continue;
            }

            int tempD = (d + 2) % 4;
            nextR = r + dir[tempD][0];
            nextC = c + dir[tempD][1];
            if (room[nextR][nextC]) {
                r = nextR;
                c = nextC;
                continue;
            }
            System.out.println(answer);
            return;
        }
    }

    private static boolean check(int r, int c) {
        if (0 <= r && r < N && 0 <= c && c < M) {
            return true;
        }
        return false;
    }
}
