package baekjoon.p18511;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static int K;
    static int[] nums;
    static int max = Integer.MIN_VALUE;
    static int T;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        T = (N+"").length();
        nums = new int[K];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < K; i++) {
            nums[i] = Integer.parseInt(st.nextToken());
        }

        solve(0, 0, "");
        T--;
        solve(0, 0, "");
        System.out.println(max);
    }

    private static void solve(int index, int depth, String str) {
        if (depth == T) {
            int n = Integer.parseInt(str);
            if(n <= N && n > max) max = n;
            return;
        }
        if(index == K) return;

        solve(0, depth + 1, str+nums[index]);
        solve(index+1, depth, str);
    }
}
