package baekjoon.p1018;

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
        int[][] map = new int[N][M];
        for (int i = 0; i < N; i++) {
            String str = br.readLine();
            for (int j = 0; j < M; j++) {
                if (str.charAt(j) == 'B') {
                    map[i][j] = 1;
                } else {
                    map[i][j] = 0;
                }
            }
        }
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < N - 7; i++) {
            for (int j = 0; j < M - 7; j++) {
                int cnt = 0;
                for (int x = i; x < i + 8; x++) {
                    for (int y = j; y < j + 8; y++) {
                        if ((x + y) % 2 == (i + j) % 2 && map[x][y] != map[i][j]) {
                            continue;
                        } else if ((x + y) % 2 != (i + j) % 2 && map[x][y] == map[i][j]) {
                            continue;
                        } else
                            cnt++;
                    }
                }
                min = Integer.min(min, cnt);
                cnt = 0;
                for (int x = i; x < i + 8; x++) {
                    for (int y = j; y < j + 8; y++) {
                        if ((x + y) % 2 == (i + j) % 2 && map[x][y] == map[i][j]) {
                            continue;
                        } else if ((x + y) % 2 != (i + j) % 2 && map[x][y] != map[i][j]) {
                            continue;
                        } else
                            cnt++;
                    }
                }
                min = Integer.min(min, cnt);

            }
        }
        System.out.println(min);
    }
}
