package baekjoon.p16926;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int R = Integer.parseInt(st.nextToken());

        int[][] arr = new int[N + 1][M + 1];
        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= M; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        while (R-- > 0) {
            int x1 = 1;
            int x2 = N;
            int y1 = 1;
            int y2 = M;
            while (x1<x2 && y1<y2) {
                Queue<Integer> queue = new LinkedList<>();
                int curX = x1;
                int curY = y1;
                queue.add(arr[curX][curY]);

                while (curX <= x2) {
                    queue.add(arr[curX][curY]);
                    arr[curX][curY] = queue.poll();
                    curX++;
                }
                curX--;
                curY++;

                while (curY <= y2) {
                    queue.add(arr[curX][curY]);
                    arr[curX][curY] = queue.poll();
                    curY++;
                }
                curY--;
                curX--;

                while (curX >= x1) {
                    queue.add(arr[curX][curY]);
                    arr[curX][curY] = queue.poll();
                    curX--;
                }
                curX++;
                curY--;
                while (curY >= y1) {
                    queue.add(arr[curX][curY]);
                    arr[curX][curY] = queue.poll();
                    curY--;
                }

                x1++;
                y1++;
                x2--;
                y2--;

            }
        }

        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= M; j++) {
                sb.append(arr[i][j] + " ");
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }
}
