package baekjoon.p2588;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int a = Integer.parseInt(br.readLine());
        String s = br.readLine();
        int sum = 0;
        int mul = 1;
        for (int i = 2; i >= 0; i--) {
            int n = (s.charAt(i) - '0') * a;
            sb.append(n).append('\n');
            n *= mul;
            mul *= 10;
            sum += n;
        }
        sb.append(sum);
        System.out.println(sb);
    }
}
