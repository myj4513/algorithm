package baekjoon.p2422;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main2 {

    static int N, M, ans;
    static boolean[][] comb;
    static boolean visited[];
    static int[] data = new int[3];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        comb = new boolean[N][N];
        visited = new boolean[N];

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken()) - 1;
            int b = Integer.parseInt(st.nextToken()) - 1;
            comb[a][b] = true;
            comb[b][a] = true;
        }

        ans = 0;
        solve(0, 0);
        System.out.println(ans);

    }

    private static void solve(int index, int depth) {
        if (depth == 3) {
            if (check())
                ans++;
            return;
        }
        for (int i = index; i < N; i++) {
            if (!visited[i]) {
                visited[i] = true;
                data[depth] = i;
                solve(i, depth + 1);
                visited[i] = false;
            }
        }
    }

    private static boolean check() {
        for (int i = 0; i < 2; i++) {
            for (int j = i + 1; j < 3; j++) {
                if (comb[data[i]][data[j]])
                    return false;
            }
        }
        return true;
    }
}
