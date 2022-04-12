package baekjoon.P14279;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());

        int min = Integer.MAX_VALUE;

        for (int i = 1; i * i <= c;i++) {
            if (c % i == 0) {
                int ii = c/i;
                min = Math.min(Math.abs(a-i) + Math.abs(b-ii),Math.min(Math.abs(a-ii) + Math.abs(b-i), min));
            }
        }
        int size = min;
        for (int d = c - size; d <= c + size; d++) {
            for (int i = 1; i * i <= c;i++) {
                if (d % i == 0) {
                    int ii = d/i;
                    min = Math.min(Math.abs(a-i) + Math.abs(b-ii) + Math.abs(d-c),Math.min(Math.abs(a-ii) + Math.abs(b-i) + Math.abs(d-c), min));
                }
            }
        }

        System.out.println(min);
    }
}
