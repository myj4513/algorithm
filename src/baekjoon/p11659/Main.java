package baekjoon.p11659;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int[] sum = new int[N + 1];
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i < N + 1; i++) {
            sum[i] = Integer.parseInt(st.nextToken()) + sum[i - 1];
        }

        StringBuilder sb = new StringBuilder();
        while (M-- > 0) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            sb.append(sum[end] - sum[start - 1]).append('\n');
        }
        System.out.println(sb);
    }
}
