package baekjoon.p1711;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[][] points = new int[N][2];
        int cnt = 0;
        StringTokenizer st = null;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            points[i][0] = Integer.parseInt(st.nextToken());
            points[i][1] = Integer.parseInt(st.nextToken());
        }
        int[] lengths = new int[N * (N - 1) / 2];
        int idx = 0;
        for (int i = 0; i < N - 1; i++) {
            for (int j = i + 1; j < N; j++) {
                lengths[idx++] = Math.abs(points[i][0] - points[j][0]) * Math.abs(points[i][0] - points[j][0]) + Math.abs(points[i][1] - points[j][1]) * Math.abs(points[i][1] - points[j][1]);
            }
        }
        Arrays.sort(lengths);
        System.out.println(Arrays.toString(lengths));
        for (int i = 0; i < lengths.length - 2; i++) {
            for (int j = i+1; j < lengths.length - 1; j++) {
                for (int k = j+1; k < lengths.length; k++) {
                    if (lengths[i] + lengths[j] == lengths[k]) cnt++;
                }
            }
        }

        System.out.println(cnt);
    }
}
