package baekjoon.p1992;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    private static int[][] pixels;
    private static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        pixels = new int[N][N];
        for (int i = 0; i < N; i++) {
            String str = br.readLine();
            for (int j = 0; j < N; j++) {
                pixels[i][j] = str.charAt(j) - '0';
            }
        }

        solve(0, 0, N, N);
        System.out.println(sb);
    }

    private static void solve(int top, int left, int bottom, int right) {
        if (isCompressible(top, left, bottom, right)) {
            sb.append(pixels[top][left]);
        } else {
            sb.append('(');
            solve(top, left, (top + bottom) / 2, (left + right) / 2);
            solve(top, (left + right) / 2, (top + bottom) / 2, right);
            solve((top + bottom) / 2, left, bottom, (left + right) / 2);
            solve((top + bottom) / 2, (left + right) / 2, bottom, right);
            sb.append(')');
        }
    }

    private static boolean isCompressible(int top, int left, int bottom, int right) {
        int value = pixels[top][left];
        for (int i = top; i < bottom; i++) {
            for (int j = left; j < right; j++) {
                if (pixels[i][j] != value) {
                    return false;
                }
            }
        }
        return true;
    }
}
