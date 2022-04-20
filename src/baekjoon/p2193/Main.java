package baekjoon.p2193;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        long[] dp0 = new long[92];
        long[] dp1 = new long[92];

        dp0[1] = 0;
        dp1[1] = 1;
        dp0[2] = 1;
        dp1[2] = 0;
        for (int i = 3; i <= 90; i++) {
            dp0[i] = dp1[i - 1] + dp0[i - 1];
            dp1[i] = dp0[i - 1];
        }
        System.out.println(dp0[N] + dp1[N]);
    }
}
