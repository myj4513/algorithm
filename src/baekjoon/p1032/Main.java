package baekjoon.p1032;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        String str = br.readLine();
        int len = str.length();
        for (int i = 0; i < N - 1; i++) {
            String cmpString = br.readLine();
            for (int j = 0; j < len; j++) {
                if (str.charAt(j) != cmpString.charAt(j)) {
                    str = str.substring(0,j) + '?' + str.substring(j + 1, len);
                }
            }
        }
        System.out.println(str);
    }
}
