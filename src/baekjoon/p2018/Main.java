package baekjoon.p2018;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int result = 0;
        int a = 0;
        for(int i=1;;i++) {
            a += i;
            if (a> N) {
                break;
            }
            if((N-a)%i==0) result++;
        }
        System.out.println(result);
    }
}