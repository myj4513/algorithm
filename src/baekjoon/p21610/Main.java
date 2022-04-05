package baekjoon.p21610;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    private static int[] dr = new int[]{0, -1, -1, -1, 0, 1, 1, 1};
    private static int[] dc = new int[]{-1, -1, 0, 1, 1, 1, 0, -1};
    private static int N;
    private static int[][] A;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        A = new int[N][N];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                A[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        boolean[][] clouds = new boolean[N][N];
        clouds[N - 1][0] = clouds[N - 1][1] = clouds[N - 2][0] = clouds[N - 2][1] = true;
        while (M-- > 0) {
            st = new StringTokenizer(br.readLine());
            int d = Integer.parseInt(st.nextToken()) - 1;
            int s = Integer.parseInt(st.nextToken());

            clouds = move(d, s, clouds);
            rain(clouds);
            magic(clouds);
            clouds = makeClouds(clouds);
        }
        System.out.println(sum());
    }

    private static int sum() {
        int sum = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                sum += A[i][j];
            }
        }
        return sum;
    }

    private static boolean[][] makeClouds(boolean[][] clouds) {
        boolean[][] newClouds = new boolean[N][N];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (!clouds[i][j] && A[i][j] >= 2) {
                    A[i][j] -= 2;
                    newClouds[i][j] = true;
                }
            }
        }
        return newClouds;
    }

    private static void magic(boolean[][] clouds) {
        int cnt;
        int r;
        int c;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (clouds[i][j]) {
                    cnt = 0;
                    for (int k = 1; k < 8; k += 2) {
                        r = i + dr[k];
                        c = j + dc[k];
                        if (0 <= r && r < N && 0 <= c && c < N && A[r][c] > 0) {
                            cnt++;
                        }
                    }
                    A[i][j] += cnt;

                }
            }
        }
    }

    private static void rain(boolean[][] clouds) {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (clouds[i][j]) {
                    A[i][j] += 1;
                }
            }
        }
    }

    private static boolean[][] move(int d, int s, boolean[][] clouds) {
        boolean[][] movedClouds = new boolean[N][N];
        int r;
        int c;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (clouds[i][j]) {
                    r = i + s * dr[d];
                    while (r < 0) r += N;
                    r = (r >= N || r < 0) ? r % N : r;
                    c = j + s * dc[d];
                    while (c < 0) c += N;
                    c = (c >= N || c < 0) ? c % N : c;
                    movedClouds[r][c] = true;
                }
            }
        }
        return movedClouds;
    }
}
