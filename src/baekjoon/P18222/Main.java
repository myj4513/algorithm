package baekjoon.P18222;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        long N = Long.parseLong(br.readLine());
        boolean convert = false;


        while (true) {
            if (N == 1)
                break;

            int k = 0;
            for (int i = 0; ; i++) {
                if (pow(2, i) >= N) {
                    k = i;
                    break;
                }
            }

            N = N - pow(2, k - 1);
            convert = !convert;
        }
        if (convert)
            System.out.println(1);
        else
            System.out.println(0);
    }

    private static long pow(int a, int b) {
        long result = 1;
        for (int i = 0; i < b; i++) {
            result *= a;
        }
        return result;
    }
}
