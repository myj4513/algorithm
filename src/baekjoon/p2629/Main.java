package baekjoon.p2629;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] weights = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            weights[i] = Integer.parseInt(st.nextToken());
        }

        boolean[] isAvailable = new boolean[40001];

        for (int i = 0; i < N; i++) {
            ArrayList<Integer> temp = new ArrayList<>();
            temp.add(weights[i]);
            for (int j = 1; j <= 15000; j++) {
                if (isAvailable[j]) {
                    if(j+weights[i]<=15000) temp.add(j + weights[i]);
                    if(j-weights[i] > 0) temp.add(j - weights[i]);
                    if(weights[i] - j>0) temp.add(weights[i] - j);
                }
            }
            for (int j = 0; j < temp.size(); j++) {
                isAvailable[temp.get(j)] = true;
            }
        }
        int T = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        while (T-- > 0) {
            int t = Integer.parseInt(st.nextToken());
            if (isAvailable[t]) {
                sb.append('Y');
            } else {
                sb.append('N');
            }
            sb.append(' ');
        }
        System.out.println(sb);
    }
}
