package baekjoon.p10655;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int N = Integer.parseInt(br.readLine());

        int[][] cp = new int[N][2];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            cp[i][0] = Integer.parseInt(st.nextToken());
            cp[i][1] = Integer.parseInt(st.nextToken());
        }

        long sum = 0;
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < N-2; i++) {
            int curX = cp[i][0];
            int curY = cp[i][1];
            int nextX = cp[i + 1][0];
            int nextY = cp[i + 1][1];

            sum += Math.abs(curX - nextX) + Math.abs(curY - nextY);

            int targetX = cp[i + 2][0];
            int targetY = cp[i + 2][1];
            int distance = 0;
            if (nextX < Math.min(curX, targetX)) {
                distance += Math.min(curX, targetX) - nextX;
            } else if (nextX > Math.max(curX, targetX)) {
                distance += nextX - Math.max(curX, targetX);
            }
            if (nextY < Math.min(curY, targetY)) {
                distance += Math.min(curY, targetY) - nextY;
            } else if (nextY > Math.max(curY, targetY)) {
                distance += nextY - Math.max(curY, targetY);
            }
            max = Math.max(max, distance);
        }
        sum += Math.abs(cp[N - 2][0] - cp[N - 1][0]) + Math.abs(cp[N - 2][1] - cp[N - 1][1]);
        System.out.println(sum - max * 2);
    }
}
