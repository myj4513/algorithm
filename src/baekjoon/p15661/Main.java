package baekjoon.p15661;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int min = Integer.MAX_VALUE;
    static int N;
    static int[][] S;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        S = new int[N][N];
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                S[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        solve(0, 0, 0, false, false, new boolean[N], new boolean[N]);
        System.out.println(min);
    }

    private static void solve(int idx, int A, int B, boolean usedA, boolean usedB, boolean[] usedAA, boolean[] usedBB) {
        if (idx == N) {
            if (usedA && usedB) {
                min = Math.abs(A - B) < min ? Math.abs(A - B) : min;
            }
            return;
        }
        int stat;

        //A팀에 들어갈 경우
        usedAA[idx] = true;
        stat = 0;
        for (int i = 0; i < N; i++) {
            if (usedAA[i]) {
                stat += (S[idx][i] + S[i][idx]);
            }
        }
        solve(idx + 1, A+stat, B, true, usedB, usedAA, usedBB);
        usedAA[idx] = false;

        //B팀에 들어갈 경우
        usedBB[idx] = true;
        stat = 0;
        for (int i = 0; i < N; i++) {
            if (usedBB[i]) {
                stat += (S[idx][i] + S[i][idx]);
            }
        }
        solve(idx + 1, A,B+stat, usedA, true, usedAA, usedBB);
        usedBB[idx] = false;

    }

}
