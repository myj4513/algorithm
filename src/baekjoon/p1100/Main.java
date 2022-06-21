package baekjoon.p1100;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int cnt = 0;
        for (int i = 0; i < 8; i++) {
            String str = br.readLine();
            for (int j = 0; j < 8; j++) {
                if (str.charAt(j) == 'F' && (i + j) % 2 == 0) {
                    cnt++;
                }
            }
        }
        System.out.println(cnt);
    }
}
