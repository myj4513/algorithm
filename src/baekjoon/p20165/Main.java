package baekjoon.p20165;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    private static int[][] board;
    private static boolean[][] isLying;
    private static int[][] direction = new int[][]{{-1, 0}, {0, 1}, {1, 0}, {0, -1}};//상,우,하,좌

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int R = Integer.parseInt(st.nextToken());

        int answer = 0;

        board = new int[N][M];
        isLying = new boolean[N][M];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        while (R-- > 0) {
            st = new StringTokenizer(br.readLine());
            Queue<Domino> q = new LinkedList<>();
            q.add(new Domino(Integer.parseInt(st.nextToken())-1, Integer.parseInt(st.nextToken())-1, getDir(st.nextToken().charAt(0))));
            while (!q.isEmpty()) {
                Domino poll = q.poll();
                int r = poll.r;
                int c = poll.c;
                if (r < 0 || r >= N || c < 0 || c >= M || isLying[r][c]) {
                    continue;
                }
                isLying[r][c] = true;
                answer++;
                int height = board[r][c];
                for (int i = 1; i < height; i++) {
                    q.add(new Domino(r+(direction[poll.dir][0]*i),(c+direction[poll.dir][1]*i),poll.dir));
                }
            }
            st = new StringTokenizer(br.readLine());
            isLying[Integer.parseInt(st.nextToken())-1][Integer.parseInt(st.nextToken())-1] = false;
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (isLying[i][j]) {
                    sb.append('F');
                } else {
                    sb.append('S');
                }
                sb.append(' ');
            }
            sb.append('\n');
        }
        System.out.println(answer);
        System.out.println(sb);
    }

    private static int getDir(char c) {
        switch (c) {
            case 'N':
                return 0;
            case 'E':
                return 1;
            case 'S':
                return 2;
            case 'W':
                return 3;
        }
        return -1;
    }
}

class Domino {
    int r;
    int c;
    int dir;

    Domino(int r, int c, int dir) {
        this.r = r;
        this.c = c;
        this.dir = dir;
    }
}
