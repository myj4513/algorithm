package baekjoon.p1309;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        long a = 2;
        long b = 1;
        for (int i = 0; i < N - 1; i++) {
            long tempA = b*2 + a;
            long tempB = a + b;
            a = tempA%9901;
            b = tempB%9901;
        }
        System.out.println((a+b)%9901);
    }
}
