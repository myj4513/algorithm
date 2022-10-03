package baekjoon.p19951;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 백준 199551번
 */

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int[] arr = new int[N+1];
        int[] prefixSum = new int[N+1];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken())-1;
            int end = Integer.parseInt(st.nextToken());
            int degree = Integer.parseInt(st.nextToken());
            prefixSum[start] += degree;
            prefixSum[end] -= degree;
        }
        for (int i = 1; i < N; i++) {
            prefixSum[i] += prefixSum[i-1];
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < N; i++) {
            arr[i] += prefixSum[i];
            sb.append(arr[i] + " ");
        }
        System.out.println(sb);
    }
}
