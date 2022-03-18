package baekjoon.p11663;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[] arr = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);

        while (M-- > 0) {
            st = new StringTokenizer(br.readLine());
            int startInput = Integer.parseInt(st.nextToken());
            int endInput = Integer.parseInt(st.nextToken());

            int start = 0;
            int end = N-1;
            int result1 = N;
            while (start <= end) {
                int mid = (start + end) / 2;
                if (arr[mid] >= startInput) {
                    result1 = mid;
                    end = mid -1;
                } else {
                    start = mid + 1;
                }
            }

            start = 0;
            end = N-1;
            int result2 = -1;
            while (start <= end) {
                int mid = (start + end) / 2;
                if (arr[mid] > endInput) {
                    end = mid -1;
                } else {
                    result2 = mid;
                    start = mid + 1;
                }
            }
            sb.append(result2 - result1 + 1).append('\n');
        }
        System.out.println(sb);
    }
}
