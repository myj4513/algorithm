package baekjoon.p2470;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr);
        int start = 0;
        int end = N-1;
        int a = 0;
        int b = 0;
        int value = Integer.MAX_VALUE;
        while (start < end) {
            if (Math.abs(arr[start] + arr[end]) < value) {
                a = start;
                b = end;
                value = Math.abs(arr[start] + arr[end]);
            } else if (arr[start] + arr[end] > 0) {
                end--;
            } else {
                start++;
            }
        }
        StringBuilder sb = new StringBuilder();
        sb.append(arr[a]).append(' ').append(arr[b]);
        System.out.println(sb);
    }
}
