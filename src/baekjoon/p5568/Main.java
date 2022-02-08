package baekjoon.p5568;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

public class Main {
    static Set<Integer> set;
    static StringBuilder sb = new StringBuilder();
    static int[] nums;
    static boolean[] used;
    static int N;
    static int K;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        K = Integer.parseInt(br.readLine());

        nums = new int[N];
        used = new boolean[N];

        for (int i = 0; i < N; i++) {
            nums[i] = Integer.parseInt(br.readLine());
        }

        set = new HashSet<>();
        loop(0, 0, "");
        System.out.println(set.size());
    }

    public static void loop(int index, int depth, String str) {
        if (depth == K) {
            set.add(Integer.parseInt(str));
            return;
        }
        if (index == N) return;

        if (!used[index]) {
            String newStr = str + nums[index];
            used[index] = true;
            loop(0, depth + 1, newStr);
            used[index] = false;
        }
        loop(index + 1, depth, str);
    }
}
