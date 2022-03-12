package baekjoon.p15655;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static StringBuilder sb = new StringBuilder();
    static int N;
    static int M;
    static int[] arr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        arr = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            Main.arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);

        solve(0,0, new boolean[N]);
        System.out.println(sb);
    }

    private static void solve(int idx, int m, boolean[] used) {
        if (idx == N) {
            if (m == M) {
                for (int i = 0; i < N; i++) {
                    if (used[i]) {
                        sb.append(arr[i]).append(' ');
                    }
                }
                sb.append('\n');
            }
            return;
        }

        if (!used[idx]) {
            used[idx] = true;
            solve(idx + 1, m + 1, used);
            used[idx] = false;
            solve(idx+1, m, used);
        }

    }


}
