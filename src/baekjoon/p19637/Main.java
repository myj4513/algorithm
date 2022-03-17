package baekjoon.p19637;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int[] values = new int[N];
        String[] names = new String[N];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            names[i] = st.nextToken();
            values[i] = Integer.parseInt(st.nextToken());
        }

        while (K-- > 0) {
            int c = Integer.parseInt(br.readLine());
            int start = 0;
            int end = N-1;
            int result = -1;
            while (start <= end) {
                int mid = (start + end) / 2;
                if (c <= values[mid]) {
                    result = mid;
                    end = mid - 1;
                } else {
                    start = mid + 1;
                }
            }
            sb.append(names[result]).append('\n');
        }
        System.out.println(sb);
    }
}
