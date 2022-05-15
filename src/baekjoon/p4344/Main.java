package baekjoon.p4344;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        while (T-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int[] arr = new int[N];
            int sum = 0;
            for (int i = 0; i < N; i++) {
                arr[i] = Integer.parseInt(st.nextToken());
                sum += arr[i];
            }
            double avg = 1.0 * sum / N;
            int cnt = 0;
            for (int i = 0; i < N; i++) {
                if (arr[i] > avg) {
                    cnt++;
                }
            }
            System.out.printf("%.3f%%\n", Math.round(1.0 * cnt/N * 100000)/1000.0);
        }
    }
}
