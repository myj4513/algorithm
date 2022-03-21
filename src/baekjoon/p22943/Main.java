package baekjoon.p22943;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

    private static int K;
    private static int M;
    private static boolean[] sum;
    private static boolean[] mul;
    private static int cnt = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        K = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        int SIZE = (int) Math.pow(10, K);
        boolean[] isPrime = new boolean[SIZE];
        sum = new boolean[SIZE];
        mul = new boolean[SIZE];

        List<Integer> list = new ArrayList<>();
        isPrime[0] = false;
        isPrime[1] = false;
        for (int i = 2; i < SIZE; i++) {
            if (isPrime[i]) {
                list.add(i);
                for (int j = 2; j * i < SIZE; j++) {
                    isPrime[j * i] = false;
                }
            }
        }

        for (Integer i : list) {
            for (Integer j : list) {
                if (i + j < SIZE && isPrime[i] && isPrime[j] && i != j) {
                    sum[i + j] = true;
                }
                if (1L *i * j < SIZE && isPrime[i] && isPrime[j]) {
                    mul[i * j] = true;
                }
            }
        }

        solve(0, 0, new boolean[10]);
        System.out.println(cnt);
    }

    private static void solve(int depth, int n, boolean[] used) {
        if (depth == K) {
            if (sum[n]) {
                while (n % M == 0) {
                    n /= M;
                }
                if (mul[n]) {
                    cnt++;
                }
            }
            return;
        }
        for (int i = 0; i < 10; i++) {
            if (i == 0 && depth == 0) continue;
            if (!used[i]) {
                used[i] = true;
                solve(depth + 1, n * 10 + i, used);
                used[i] = false;
            }
        }
    }
}
