package baekjoon.p10816;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < N; i++) {
            int n = Integer.parseInt(st.nextToken());
            map.put(n, map.getOrDefault(n, 0)+1);
        }

        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        while (T-- > 0) {
            sb.append(map.getOrDefault(Integer.parseInt(st.nextToken()), 0)).append(' ');
        }
        System.out.println(sb);
    }
}
