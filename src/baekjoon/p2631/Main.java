package baekjoon.p2631;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int[] kids = new int[N + 1];
        int[] lis = new int[N + 1];

        for (int i = 1; i <= N; i++) {
            kids[i] = Integer.parseInt(br.readLine());
        }

        for (int i = 1; i <= N; i++) {
            for (int j = 0; j < i; j++) {
                if (kids[i] > kids[j]) {
                    lis[i] = Math.max(lis[i], lis[j] + 1);
                }
            }
        }
        System.out.println(N-Arrays.stream(lis).max().getAsInt());
    }
}
