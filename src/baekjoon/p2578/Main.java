package baekjoon.p2578;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;
        int[][] bingo = new int[6][6];
        boolean[][] check = new boolean[6][6];
        int[] order = new int[26];
        for (int i = 1; i <= 5; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= 5; j++) {
                bingo[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i = 0; i < 5; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= 5; j++) {
                order[i*5+j] = Integer.parseInt(st.nextToken());
            }
        }

        int result = 0;
        while (true) {
            result++;
            int countBingo = 0;
            for (int i = 1; i <= 5; i++) {
                for (int j = 1; j <= 5; j++) {
                    if (bingo[i][j] == order[result]) {
                        check[i][j] = true;
                        break;
                    }
                }
            }

            for (int i = 1; i <= 5; i++) {
                boolean flag = true;
                for (int j = 1; j <= 5; j++) {
                    if (!check[i][j]) {
                        flag = false;
                        break;
                    }
                }
                if(flag) countBingo++;
            }

            for (int i = 1; i <= 5; i++) {
                boolean flag = true;
                for (int j = 1; j <= 5; j++) {
                    if (!check[j][i]) {
                        flag = false;
                        break;
                    }
                }
                if(flag) countBingo++;
            }

            boolean flag = true;
            for (int i = 1; i <= 5; i++) {
                if (!check[i][i]) {
                     flag = false;
                     break;
                }
            }
            if(flag){
                countBingo++;
            }

            flag = true;
            for (int i = 1; i <= 5; i++) {
                if (!check[i][6-i]) {
                    flag = false;
                    break;
                }
            }
            if(flag){
                countBingo++;
            }

            if(countBingo>=3){
                System.out.println(result);
                return;
            }
        }
    }
}
