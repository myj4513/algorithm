package baekjoon.p16439;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int max = 0;

        int[][] prefer = new int[N][M];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                prefer[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i = 0; i < M - 2; i++) {
            for (int j = i + 1; j < M - 1; j++) {
                for (int k = j + 1; k < M; k++) {
                    int total = 0;
                    for (int x = 0; x < N; x++) {
                        total += Math.max(Math.max(prefer[x][i], prefer[x][j]), prefer[x][k]);
                    }
                    if(total>max) max = total;
                }
            }
        }
        System.out.println(max);
    }
}
