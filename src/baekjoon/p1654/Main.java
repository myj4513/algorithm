package baekjoon.p1654;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int K = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());

        int[] lans = new int[K];
        long start = 1;
        long end = 0;

        for (int i = 0; i < K; i++) {
            int tmp = Integer.parseInt(br.readLine());
            lans[i] = tmp;
            end = Math.max(tmp, end);
        }
        long result = 0;
        while (start <= end) {
            long mid = (start + end)/2;
            int cnt = 0;
            for (int i = 0; i < K; i++) {
                cnt += lans[i]/mid;
            }
            if (cnt >= N) {
                result = mid;
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }
        System.out.println(result);
    }
}
