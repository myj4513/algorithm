package baekjoon.p11728;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[] A = new int[N];
        int[] B = new int[M];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            A[i] = Integer.parseInt(st.nextToken());
        }
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < M; i++) {
            B[i] = Integer.parseInt(st.nextToken());
        }

        int[] AB = new int[N + M];
        int APointer = 0;
        int BPointer = 0;
        for (int i = 0; i < N + M; i++) {
            if (APointer == N) {
                AB[i] = B[BPointer++];
                continue;
            }
            if (BPointer == M) {
                AB[i] = A[APointer++];
                continue;
            }

            AB[i] = A[APointer] < B[BPointer]?A[APointer++]:B[BPointer++];

        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < N + M; i++) {
            sb.append(AB[i] + " ");
        }
        System.out.println(sb);
    }
}
