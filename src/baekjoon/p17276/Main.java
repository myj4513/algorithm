package baekjoon.p17276;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = null;
        int T = Integer.parseInt(br.readLine());

        while (T-- > 0) {
            st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int d = (Integer.parseInt(st.nextToken()) + 360)/45 % 8;

            int[][] arr = new int[n][n];

            for (int i = 0; i < n; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < n; j++) {
                    arr[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            int[][] result = rotate(arr, d);
            for (int i = 0; i < n; i++) {
                Arrays.stream(result[i]).forEach(e -> sb.append(e + " "));
                sb.append("\n");
            }
        }
        System.out.println(sb);
    }

    public static int[][] rotate(int[][] arr, int d) {
        int n = arr.length;

        while (d-- > 0) {
            int[][] newArr = new int[n][n];

            for (int i = 0; i < n; i++) {
                newArr[i] = Arrays.copyOf(arr[i], n);
            }
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (i == j) {
                        newArr[i][n/2] = arr[i][j];
                    } else if (i == n - 1 - j) {
                        newArr[n / 2][j] = arr[i][j];
                    } else if (j == n / 2) {
                        newArr[i][n - 1 - i] = arr[i][j];
                    } else if (i == n / 2) {
                        newArr[j][j] = arr[i][j];
                    }
                }
            }
            arr = newArr;
        }

//        for (int i = 0; i < n; i++) {
//            System.out.println(Arrays.toString(newArr[i]));
//        }

        return arr;
    }
}
