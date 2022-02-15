package baekjoon.p1548;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static int[] nums;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;
        N = Integer.parseInt(br.readLine());

        nums = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            nums[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(nums);

        System.out.println(solve());
    }

    private static int solve() {
        if(N<=2) return N;
        int max = 0;
        for (int i = 0; i < N - 1; i++) {
            for (int j = N - 1; j >= 0; j--) {
                if(i+1==j) break;
                if (nums[i] + nums[i + 1] > nums[j]) {
                    max = Math.max(max, j - i + 1);
                    break;
                }
            }
        }
        return max<3?2:max;
    }
}
