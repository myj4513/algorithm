package baekjoon.p21312;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] drinks = new int[3];
        boolean isUsed = false;
        for (int i = 0; i < 3; i++) {
            drinks[i] = Integer.parseInt(st.nextToken());
        }
        int result = 1;
        for (int i = 0; i < 3; i++) {
            if (drinks[i] % 2 == 1) {
                isUsed = true;
                result *= drinks[i];
            }
        }
        if (!isUsed) {
            for (int i = 0; i < 3; i++) {
                result *= drinks[i];
            }
        }
        System.out.println(result);
    }
}
