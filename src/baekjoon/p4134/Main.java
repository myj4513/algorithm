package baekjoon.p4134;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());

        while (T-- > 0) {
            long n = Long.parseLong(br.readLine());
            for (long i = n; ; i++) {
                if (isPrime(i)) {
                    sb.append(i).append(('\n'));
                    break;
                }
            }
        }
        System.out.println(sb);
    }

    private static boolean isPrime(long n) {
        if(n<=1) return false;
        for (long i = 2; i * i <= n; i++) {
            if (n % i == 0)
                return false;
        }
        return true;
    }
}
