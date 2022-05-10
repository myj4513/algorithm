package baekjoon.p11729;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    private static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        hanoi(N, 1,2,3);
        System.out.println(sb);
    }

    private static void hanoi(int n, int from, int mid, int to) {
        if(n==0) return;

        hanoi(n-1, from, to, mid);
        sb.append(from).append(' ').append(to).append('\n');
        hanoi(n-1, mid, from, to);
    }
}
