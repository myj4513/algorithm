package baekjoon.p13460;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    private static char[][] board;
    private static int MIN = Integer.MAX_VALUE;
    private static int[][] dir = new int[][]{{-1, 0}, {0, 1}, {1, 0}, {0, -1}};

    //방향 dir 0=북, 1=동, 2=남, 3=서
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        board = new char[N][M];
        int redR = -1;
        int redC = -1;
        int blueR = -1;
        int blueC = -1;
        for (int i = 0; i < N; i++) {
            String str = br.readLine();
            for (int j = 0; j < M; j++) {
                char c = str.charAt(j);
                if (c == 'R') {
                    redR = i;
                    redC = j;
                } else if (c == 'B') {
                    blueR = i;
                    blueC = j;
                }
                board[i][j] = c;
            }
        }
        bfs(redR, redC, blueR, blueC);
        System.out.println(MIN == Integer.MAX_VALUE ? -1 : MIN);
    }

    private static void bfs(int redR0, int redC0, int blueR0, int blueC0) {
        // {direction, redR, redC, blueR, blueC, cnt}
        Queue<int[]> queue = new LinkedList<>();
        for (int i = 0; i < 4; i++) {
            queue.add(new int[]{i, redR0, redC0, blueR0, blueC0, 0});
        }
        while (!queue.isEmpty()) {
            int[] info = queue.poll();
            int d = info[0];
            int redR = info[1];
            int redC = info[2];
            int blueR = info[3];
            int blueC = info[4];
            int cnt = info[5];

            if (cnt >= 10) {
                continue;
            }

            boolean isRedHole = false;
            boolean isBlueHole = false;

            while (board[redR + dir[d][0]][redC + dir[d][1]] != '#') {
                redR += dir[d][0];
                redC += dir[d][1];
                if (board[redR][redC] == 'O') {
                    isRedHole = true;
                    break;
                }
            }

            while (board[blueR + dir[d][0]][blueC + dir[d][1]] != '#') {
                blueR += dir[d][0];
                blueC += dir[d][1];
                if (board[blueR][blueC] == 'O') {
                    isBlueHole = true;
                    break;
                }
            }

            if (isBlueHole) {
                continue;
            } else if (isRedHole) {
                MIN = Math.min(MIN, cnt + 1);
                continue;
            }

            int prevRedR = info[1];
            int prevRedC = info[2];
            int prevBlueR = info[3];
            int prevBlueC = info[4];

            if (redR == blueR && redC == blueC) {
                if (d == 0) {
                    if (prevBlueR > prevRedR) {
                        blueR++;
                    } else {
                        redR++;
                    }
                } else if (d == 1) {
                    if (prevBlueC > prevRedC) {
                        redC--;
                    } else {
                        blueC--;
                    }
                } else if (d == 2) {
                    if (prevBlueR > prevRedR) {
                        redR--;
                    } else {
                        blueR--;
                    }
                } else { //d ==3
                    if (prevBlueC > prevRedC) {
                        blueC++;
                    } else {
                        redC++;
                    }
                }
            }

            for (int i = 0; i < 4; i++) {
                if (i != d) {
                    queue.add(new int[]{i, redR, redC, blueR, blueC, cnt + 1});
                }
            }
        }
    }
}
