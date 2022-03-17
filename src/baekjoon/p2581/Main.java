package baekjoon.p2581;

import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int M = Integer.parseInt(br.readLine());
        int N = Integer.parseInt(br.readLine());

        int min = Integer.MAX_VALUE;
        int sum = 0;
        boolean hasPrime = false;

        for (int i = M; i <= N; i++) {
            if (isPrime(i)) {
                min = Math.min(i, min);
                sum += i;
                hasPrime = true;
            }
        }
        if (!hasPrime) {
            System.out.println(-1);
            return;
        }
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        bw.write(new StringBuilder().append(sum).append('\n').append(min).toString());
        bw.flush();
        bw.close();
    }

    private static boolean isPrime(int n) {
        if(n<2) return false;
        for (int i = 2; i * i <= n; i++) {
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }
}
