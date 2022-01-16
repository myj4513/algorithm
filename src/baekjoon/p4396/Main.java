package baekjoon.p4396;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        int[][] pos = {{-1, -1}, {-1, 0}, {-1, 1}, {0, -1}, {0, 1}, {1, -1}, {1, 0}, {1, 1}};

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;

        int N = Integer.parseInt(br.readLine());

        char[][] board = new char[N][N];
        char[][] checked = new char[N][N];
        char[][] result = new char[N][N];

        for (int i = 0; i < N; i++) {
            Arrays.fill(result[i], '.');
        }

        for (int i = 0; i < N; i++) {
            String line = br.readLine();
            for (int j = 0; j < N; j++) {
                board[i][j] = line.charAt(j);
            }
        }

        for (int i = 0; i < N; i++) {
            String line = br.readLine();
            for (int j = 0; j < N; j++) {
                checked[i][j] = line.charAt(j);
            }
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (checked[i][j] == 'x') {
                    if (board[i][j] == '.') {
                        int count = 0;
                        for (int k = 0; k < 8; k++) {
                            int iPos = i + pos[k][0];
                            int jPos = j + pos[k][1];
                            if(0<= iPos && iPos< N && 0<=jPos && jPos < N && board[iPos][jPos] == '*')
                                count++;
                        }
                        result[i][j] = Character.forDigit(count, 10);
                    } else {
                        for (int a = 0; a < N; a++) {
                            for (int b = 0; b < N; b++) {
                                if(board[a][b] == '*') result[a][b] = '*';
                            }
                        }
                    }
                }
            }
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                sb.append(result[i][j]);
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }
}
