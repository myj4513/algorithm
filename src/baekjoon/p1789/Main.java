package baekjoon.p1789;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        long S = Long.parseLong(br.readLine());

        long sum = 0L;
        int n=0;
        while (sum <= S) {
            n++;
            sum += n;
        }
        System.out.println(--n);


    }
}
