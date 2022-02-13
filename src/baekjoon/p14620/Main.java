package baekjoon.p14620;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static int[][] planted;
    static int[][] flowerBed;
    static int min = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;
        N = Integer.parseInt(br.readLine());

        flowerBed = new int[N][N];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                flowerBed[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        planted = new int[N][N];
        dfs(0, 0);
        System.out.println(min);
    }

    private static void dfs(int index, int price) {
        if (index >= 3) {
            if (check())
                min = min > price ? price : min;
            return;
        }

        for (int i = 1; i < N - 1; i++) {
            for (int j = 1; j < N - 1; j++) {
                planted[i - 1][j]++; //상
                planted[i + 1][j]++; //하
                planted[i][j - 1]++; //좌
                planted[i][j + 1]++; //우
                planted[i][j]++;     //중앙
                dfs(index + 1, price
                        + flowerBed[i - 1][j]
                        + flowerBed[i + 1][j]
                        + flowerBed[i][j - 1]
                        + flowerBed[i][j + 1]
                        + flowerBed[i][j]);
                planted[i - 1][j]--; //상
                planted[i + 1][j]--; //하
                planted[i][j - 1]--; //좌
                planted[i][j + 1]--; //우
                planted[i][j]--;     //중앙
            }
        }
    }

    private static boolean check() {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if(planted[i][j]>1)
                    return false;
            }
        }
        return true;
    }
}
