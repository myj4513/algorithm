package baekjoon.p17829;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    static int result;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int[][] arr = new int[N][N];
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++)
                arr[i][j] = Integer.parseInt(st.nextToken());
        }

        solve(N, arr);
        System.out.println(result);
    }

    private static void solve(int N, int[][] arr) {
        if (N == 1) {
            result = arr[0][0];
            return;
        }

        int[][] newArr = new int[N / 2][N / 2];
        for (int i = 0; i < N / 2; i++) {
            for (int j = 0; j < N / 2; j++) {
                List<Integer> list = new ArrayList<>();
                list.add(arr[i * 2][j * 2]);
                list.add(arr[i * 2 + 1][j * 2]);
                list.add(arr[i * 2][j * 2 + 1]);
                list.add(arr[i * 2 + 1][j * 2 + 1]);
                Collections.sort(list);
                newArr[i][j] = list.get(2);
            }
        }
        solve(N / 2, newArr);
    }
}
