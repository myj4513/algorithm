package baekjoon.p15650;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static int M;
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        solve(0, 0, new boolean[N]);
        System.out.print(sb);
    }

    private static void solve(int idx, int m, boolean[] used) {
        if (idx == N) {
            if (m == M) {
                for (int i = 0; i < N; i++) {
                    if (used[i]) {
                        sb.append(i + 1).append(' ');
                    }
                }
                sb.append('\n');
            }
            return;
        }

        used[idx] = true;
        solve(idx + 1, m + 1, used);
        used[idx] = false;
        solve(idx + 1, m, used);
    }


}
