package baekjoon.p16937;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    static int H;
    static int W;
    static boolean[][] paper;
    static int N;
    static int[][] stickers;
    static int max = Integer.MIN_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        H = Integer.parseInt(st.nextToken());
        W = Integer.parseInt(st.nextToken());

        paper = new boolean[H][W];

        N = Integer.parseInt(br.readLine());
        stickers = new int[N][2];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            stickers[i][0] = Integer.parseInt(st.nextToken());
            stickers[i][1] = Integer.parseInt(st.nextToken());
        }

        for (int i = 0; i < N-1; i++) {
            for (int j = i + 1; j < N; j++) {
                solve(i, j);
            }
        }
        if(max == Integer.MIN_VALUE) System.out.println(0);
        else System.out.println(max);
    }

    private static void solve(int i, int j) {
        int r1 = stickers[i][0];
        int c1 = stickers[i][1];
        int r2 = stickers[j][0];
        int c2 = stickers[j][1];
        paper = new boolean[H][W];
        if (isAvailable(0, 0, r1, c1)) {
            putSticker(0, 0, r1, c1);
            for (int a = 0; a < H; a++) {
                for (int b = 0; b < W; b++) {
                    if (isAvailable(a, b, r2, c2)) {
                        int size = (r1 * c1) + (r2 * c2);
                        max = size > max ? size : max;
                        return;
                    }
                    if (isAvailable(a, b, c2, r2)) {
                        int size = (r1 * c1) + (r2 * c2);
                        max = size > max ? size : max;
                        return;
                    }
                }
            }
        }

        paper = new boolean[H][W];
        if (isAvailable(0, 0, c1, r1)) {
            putSticker(0, 0, c1, r1);
            for (int a = 0; a < H; a++) {
                for (int b = 0; b < W; b++) {
                    if (isAvailable(a, b, r2, c2)) {
                        int size = (r1 * c1) + (r2 * c2);
                        max = size > max ? size : max;
                        return;
                    }
                    if (isAvailable(a, b, c2, r2)) {
                        int size = (r1 * c1) + (r2 * c2);
                        max = size > max ? size : max;
                        return;
                    }
                }
            }
        }


    }

    private static boolean isAvailable(int x, int y, int r, int c) {
        for (int i = x; i < x + r; i++) {
            for (int j = y; j < y + c; j++) {
                if (i >= H || j >= W) {
                    return false;
                } else if (paper[i][j]) {
                    return false;
                }
            }
        }
        return true;
    }

    private static void putSticker(int x, int y, int r, int c) {
        for (int i = x; i < x + r; i++) {
            for (int j = y; j < y + c; j++) {
                paper[i][j] = true;
            }
        }
    }

}
