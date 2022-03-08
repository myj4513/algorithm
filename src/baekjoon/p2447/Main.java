package baekjoon.p2447;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static boolean[][] Arr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        Arr = new boolean[][]{{true, true, true}, {true, false, true}, {true, true, true}};
        while (N > 3) {
            solve(Arr);
            N/=3;
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < Arr.length; i++) {
            for (int j = 0; j < Arr.length; j++) {
                if(Arr[i][j])
                    sb.append('*');
                else
                    sb.append(' ');
            }
            sb.append('\n');
        }
        System.out.println(sb);
    }

    private static void solve(boolean[][] arr) {
        int len = arr.length;
        boolean[][] newArr = new boolean[len*3][len*3];
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if(i==1 && j==1) continue;
                for (int x = 0; x < len; x++) {
                    for (int y = 0; y < len; y++) {
                        newArr[i*len + x][j*len+y] = arr[x][y];
                    }
                }
            }
        }
        Arr = newArr;
    }
}
