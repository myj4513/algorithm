package baekjoon.p14889;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    private static int MIN = Integer.MAX_VALUE;
    private static int N;
    private static int[][] S;
    private static boolean visited[];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        S = new int[N][N];

        StringTokenizer st = null;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                S[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        visited = new boolean[N];
        comb(0, 0);
        System.out.println(MIN);
    }

    private static void comb(int depth, int idx) {
        if (depth == N / 2) {
            diff();
            return;
        }

        for (int i = idx; i < N; i++) {
            if (!visited[i]) {
                visited[i] = true;
                comb(depth + 1, i + 1);
                visited[i] = false;
            }
        }
    }

    private static void diff() {
        int home = 0;
        int away = 0;

        for (int i = 0; i < N; i++) {
            if (visited[i]) {
                for (int j = 0; j < N; j++) {
                    if (visited[j] && i != j) {
                        home += S[i][j];
                    }
                }
            } else {
                for (int j = 0; j < N; j++) {
                    if (!visited[j] && i != j) {
                        away += S[i][j];
                    }
                }
            }
        }

        MIN = Math.min(Math.abs(home - away), MIN);
    }


}
