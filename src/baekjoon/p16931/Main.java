package baekjoon.p16931;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[][] bricks = new int[N][M];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                bricks[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int sum = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (j == 0) sum += bricks[i][j];
                else if (bricks[i][j] > bricks[i][j - 1]) sum += bricks[i][j] - bricks[i][j - 1];
            }
        }

        for (int i = 0; i < M; i++) {
            for (int j = 0; j < N; j++) {
                if (j == 0) sum += bricks[j][i];
                else if (bricks[j][i] > bricks[j - 1][i]) sum += bricks[j][i] - bricks[j - 1][i];
            }
        }

        for (int i = 0; i < N; i++) {
            for (int j = M - 1; j >= 0; j--) {
                if (j == M - 1) sum += bricks[i][j];
                else if (bricks[i][j] > bricks[i][j + 1]) sum += bricks[i][j] - bricks[i][j + 1];
            }
        }

        for (int i = 0; i < M; i++) {
            for (int j = N - 1; j >= 0; j--) {
                if (j == N - 1) sum += bricks[j][i];
                else if (bricks[j][i] > bricks[j + 1][i]) sum += bricks[j][i] - bricks[j + 1][i];
            }
        }
        System.out.println(sum + (N * M * 2));
    }
}
