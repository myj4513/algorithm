package baekjoon.p2343;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int[] lectures;
    static int N;
    static int M;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        lectures = new int[N];
        int[] blueRays = new int[M];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            lectures[i] = Integer.parseInt(st.nextToken());
        }
        int start = 0;
        int end = 0;
        for (int i = 0; i < N; i++) {
            start = Math.max(start, lectures[i]);
            end += lectures[i];
        }
        int ans = Integer.MAX_VALUE;
        while (start <= end) {
            int mid = (start + end) / 2;
            int count = count(mid);
            if (count > M) {
                start = mid + 1;
            } else {
                end = mid - 1;
                ans = Math.min(ans, mid);
            }
        }
        System.out.println(ans);
    }

    private static int count(int mid) {
        int sum = 0;
        int cnt = 1;
        for (int i = 0; i < N; i++) {
            if (sum + lectures[i] > mid) {
                cnt++;
                sum = lectures[i];
            } else
                sum += lectures[i];
        }
        return cnt;
    }
}
