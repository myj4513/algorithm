package baekjoon.p2630;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int[][] arr;
    static int white = 0;
    static int blue = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        arr = new int[N][N];
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        solve(0, 0, N - 1, N - 1);
        System.out.println(white);
        System.out.println(blue);
    }

    private static void solve(int r1, int c1, int r2, int c2) {
        if (check(r1, c1, r2, c2)) {
            if (arr[r1][c1] == 1)
                blue++;
            else
                white++;
            return;
        }

        int midR = r1 + (r2 - r1 + 1) / 2;
        int midC = c1 + (c2 - c1 + 1) / 2;
        solve(r1, midC, midR - 1, c2);  //1사분면
        solve(r1, c1, midR - 1, midC - 1);  //2사분면
        solve(midR, c1, r2, midC - 1);  //3사분면
        solve(midR, midC, r2, c2);  //4사분면

    }

    private static boolean check(int r1, int c1, int r2, int c2) {
        int value = arr[r1][c1];
        for (int i = r1; i <= r2; i++) {
            for (int j = c1; j <= c2; j++)
                if (arr[i][j] != value)
                    return false;
        }
        return true;
    }
}
