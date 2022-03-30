package baekjoon.p2960;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int cnt = 0;
        boolean[] used = new boolean[N + 1];
        while (true) {
            int p = -1;
            for (int i = 2; i <= N; i++) {
                if (!used[i]) {
                    p = i;
                    break;
                }
            }
            for (int i = 1; i * p <= N; i++) {
                if (!used[i * p]) {
                    used[i*p] = true;
                    cnt++;
                    if (cnt == K) {
                        System.out.println(i * p);
                        return;
                    }
                }
            }
        }
    }
}
