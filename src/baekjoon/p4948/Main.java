package baekjoon.p4948;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = 123456 * 2 + 1;
        boolean isPrime[] = new boolean[N];
        Arrays.fill(isPrime, true);
        isPrime[0]= isPrime[1] = false;
        for (int i = 2; i < N; i++) {
            if (isPrime[i]) {
                int k = i *2;
                while (k < N) {
                    isPrime[k] = false;
                    k+=i;
                }
            }
        }
        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        while (T != 0) {
            int cnt = 0;
            for (int i = T+1; i <= 2 * T; i++) {
                if(isPrime[i]) {
                    cnt++;
                }
            }
            sb.append(cnt).append('\n');
            T = Integer.parseInt(br.readLine());
        }
        System.out.println(sb);
    }
}
