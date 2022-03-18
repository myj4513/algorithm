package baekjoon.p2217;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] wires = new int[N];
        for (int i = 0; i < N; i++) {
            wires[i] = Integer.parseInt(br.readLine());
        }
        Arrays.sort(wires);

        int weight = 0;
        int j=1;
        for (int i = N - 1; i >= 0; i--) {
            weight = Math.max(wires[i] * j, weight);
            j++;
        }
        System.out.println(weight);
    }
}
