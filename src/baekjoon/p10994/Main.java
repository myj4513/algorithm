package baekjoon.p10994;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(br.readLine());

        boolean[][] arr = new boolean[N * 4 - 2][N * 4 - 2];

        int length = N * 4 - 3;
        int start = 1;
        for (int i = 0; i < N; i++) {
            for (int j = start; j <= length; j++) {
                arr[start][j] = true;
                arr[j][start] = true;
            }
            for (int j = length; j >= start; j--) {
                arr[length][j] = true;
                arr[j][length] = true;
            }
            start+=2;
            length-=2;
        }


        for (int i = 1; i <= N * 4 - 3; i++) {
            for (int j = 1; j <= N * 4 - 3; j++) {
                if (arr[i][j]) sb.append("*");
                else sb.append(" ");
            }
            sb.append("\n");
        }

        System.out.println(sb);
    }
}
