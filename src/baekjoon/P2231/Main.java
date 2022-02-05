package baekjoon.P2231;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        for (int i = 1;i<1000001 ; i++) {
            int tmp = i;
            String s = i+"";
            for (int j = 0; j < s.length(); j++) {
                tmp += Integer.parseInt(s.charAt(j)+"");
            }
            if (tmp == N) {
                System.out.println(i);
                return;
            }
        }
        System.out.println(0);
    }
}
