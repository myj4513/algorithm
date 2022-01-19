package baekjoon.p1913;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());
        int k = N*N;
        int[][] snail = new int[N][N];

        int direction = 1;
        int x = -1;
        int y = 0;
        int t = N;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < t; j++) {
                x += direction;
                snail[x][y] = k--;
            }
            t--;
            for (int j = 0; j < t; j++) {
                y += direction;
                snail[x][y] = k--;
            }
            direction *= -1;
        }

        int M = Integer.parseInt(br.readLine());
        int xPos = 0;
        int yPos = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (snail[i][j] == M) {
                    xPos = i+1;
                    yPos = j+1;
                }
                sb.append(snail[i][j] + " ");
            }
            sb.append("\n");
        }
        sb.append(xPos + " " + yPos);
        System.out.println(sb);
    }
}
