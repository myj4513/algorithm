package baekjoon.p22858;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        StringTokenizer stS = new StringTokenizer(br.readLine());
        StringTokenizer stD = new StringTokenizer(br.readLine());

        int[] S = new int[N + 1];
        int[] D = new int[N + 1];
        for (int i = 1; i <= N; i++) {
            S[i] = Integer.parseInt(stS.nextToken());
            D[i] = Integer.parseInt(stD.nextToken());
        }

        while (K-- > 0) {
            int[] result = new int[N + 1];
            for (int i = 1; i <= N; i++) {
                result[D[i]] = S[i];
            }
            S = result;
        }
        Arrays.stream(S).filter(s -> s!=0).forEach(s -> sb.append(s + " "));
        System.out.println(sb);
    }
}
