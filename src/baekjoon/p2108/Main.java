package baekjoon.p2108;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];
        int sum = 0;
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(br.readLine());
            sum += arr[i];
        }

        Arrays.sort(arr);
        int prev = arr[0];
        int cnt = 1;
        int maxCnt = 1;
        int maxNum = arr[0];
        boolean flag = true;
        for (int i = 1; i < N; i++) {
            if (arr[i] == prev) {
                cnt++;
            } else {
                prev = arr[i];
                cnt = 1;
            }

            if (cnt > maxCnt) {
                maxCnt = cnt;
                maxNum = arr[i];
                flag = true;
            } else if (cnt == maxCnt && flag) {
                flag = false;
                maxCnt = cnt;
                maxNum = arr[i];
            }
        }

        StringBuilder sb = new StringBuilder();
        sb.append(Math.round((double) sum / N)).append('\n')
                .append(arr[N / 2]).append('\n')
                .append(maxNum).append('\n')
                .append(arr[N - 1] - arr[0]);
        System.out.println(sb);
    }
}
