package baekjoon.p21278;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static int sp[][];
    static Chicken MIN_CHICKEN = new Chicken(0, 0, 1000000000);

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        sp = new int[N][N];
        for (int i = 0; i < N; i++) {
            Arrays.fill(sp[i], 1000000);
        }
        for (int i = 0; i < N; i++) {
            sp[i][i] = 0;
        }
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken())-1;
            int to = Integer.parseInt(st.nextToken())-1;
            sp[from][to] = 1;
            sp[to][from] = 1;
        }

        for (int k = 0; k < N; k++) {
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    sp[i][j] = Math.min(sp[i][j], sp[i][k] + sp[k][j]);
                }
            }
        }

        solve(0, 0, new boolean[N]);

        System.out.println(MIN_CHICKEN.x + 1+" " + (MIN_CHICKEN.y+1) + " " + MIN_CHICKEN.distance * 2);
    }

    private static void solve(int idx, int cnt, boolean[] used) {
        if (cnt == 2) {
            Chicken chicken = getDistance(used);
            if (MIN_CHICKEN.distance > chicken.distance) {
                MIN_CHICKEN = chicken;
            } else if (MIN_CHICKEN.distance == chicken.distance) {
                if (MIN_CHICKEN.x > chicken.x) {
                    MIN_CHICKEN = chicken;
                } else if (MIN_CHICKEN.x == chicken.x) {
                    if (MIN_CHICKEN.y > chicken.y) {
                        MIN_CHICKEN = chicken;
                    }
                }
            }
            return;
        }

        if (idx == N) {
            return;
        }

        used[idx] = true;
        solve(idx + 1, cnt + 1, used);
        used[idx] = false;
        solve(idx + 1, cnt, used);
    }

    private static Chicken getDistance(boolean[] used) {
        int total = 0;
        int[] chicken = new int[2];
        int a = 0;
        for (int i = 0; i < N; i++) {
            if (used[i]) {
                chicken[a++] = i;
            }
        }
        for (int i = 0; i < N; i++) {
            if (!used[i]) {
                total += Math.min(sp[i][chicken[0]], sp[i][chicken[1]]);
            }
        }
        return new Chicken(chicken[0], chicken[1], total);
    }

    static class Chicken {
        int x;
        int y;
        int distance;

        public Chicken(int x, int y, int distance) {
            this.x = x;
            this.y = y;
            this.distance = distance;
        }
    }
}

