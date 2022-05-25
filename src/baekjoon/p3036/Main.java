package baekjoon.p3036;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());

        int[] arr = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        for (int i = 1; i < N; i++) {
            int gcc = gcc(arr[0], arr[i]);
            sb.append(arr[0] / gcc).append('/').append(arr[i] / gcc).append('\n');
        }
        System.out.println(sb);
    }

    static int gcc(int a, int b) {
        if (b == 0) {
            return a;
        }
        return gcc(b, a % b);
    }
}
