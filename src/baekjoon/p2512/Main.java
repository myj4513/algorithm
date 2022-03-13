package baekjoon.p2512;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int[] arr;
    static int N;
    static int mid;
    static int MAX;
    static int ans = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        arr = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);
        MAX = Integer.parseInt(br.readLine());

        solve(0, arr[N-1]);
        System.out.println(ans);
    }

    public static void solve(int start, int end) {
        mid = (start + end) / 2;
        if(start > end) {
            return;
        }

        int sum = sum(mid);
        if (MAX < sum) {
            end = mid - 1;
        } else {
            start = mid + 1;
            ans = Math.max(ans, mid);

        }
        solve(start, end);
    }

    public static int sum(int mid) {
        int result = 0;
        for (int i = 0; i < N; i++) {
            result += Math.min(arr[i], mid);
        }
        return result;
    }
}
