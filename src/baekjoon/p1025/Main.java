package baekjoon.p1025;

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

        int[][] arr = new int[N][M];
        for (int i = 0; i < N; i++) {
            String str = br.readLine();
            for (int j = 0; j < M; j++) {
                arr[i][j] = str.charAt(j) - '0';
            }
        }
        int MAX = -1;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                for (int i2 = 0; i2 < N; i2++) {
                    for (int j2 = 0; j2 < M; j2++) {
                        StringBuilder sb = new StringBuilder();
                        sb.append(arr[i][j]);
                        if (i != i2 || j != j2) {
                            int dn = i2 - i;
                            int dm = j2 - j;
                            int nextX = i2 + dn;
                            int nextY = j2 + dm;
                            sb.append(arr[i2][j2]);
                            int n = Integer.parseInt(sb.toString());

                            if (isSquareNum(n)) {
                                MAX = MAX < n ? n : MAX;
                            }
                            while (true) {
                                if (0 <= nextX && nextX < N && 0 <= nextY && nextY < M) {
                                    sb.append(arr[nextX][nextY]);
                                    nextX += dn;
                                    nextY += dm;
                                    n = Integer.parseInt(sb.toString());
                                    if (isSquareNum(n)) {
                                        MAX = MAX < n ? n : MAX;
                                    }
                                } else {
                                    break;
                                }
                            }
                        }
                        int n = Integer.parseInt(sb.toString());

                        if (isSquareNum(n)) {
                            MAX = MAX < n ? n : MAX;
                        }
                    }
                }
            }
        }
        System.out.println(MAX);
    }

    public static boolean isSquareNum(int n) {
        int sqrt = (int) Math.sqrt(n);
        return sqrt * sqrt == n;
    }
}
