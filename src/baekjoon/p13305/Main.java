package baekjoon.p13305;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] cities = new int[N];
        long[] roads = new long[N - 1];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N - 1; i++) {
            roads[i] = Long.parseLong(st.nextToken());
        }
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            cities[i] = Integer.parseInt(st.nextToken());
        }

        long sum = 0;
        int minPrice = Integer.MAX_VALUE;
        for (int i = 0; i < N-1; i++) {
            minPrice = Math.min(minPrice, cities[i]);
            sum += minPrice * roads[i];
        }
        System.out.println(sum);
    }
}
