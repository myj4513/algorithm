package baekjoon.p16139;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        int N = Integer.parseInt(br.readLine());
        int[][] sum = new int[26][str.length()];
        sum[str.charAt(0) - 'a'][0] = 1;
        for (int j = 1; j < str.length(); j++) {
            for (int i = 0; i < 26; i++) {
                sum[i][j] = sum[i][j-1];
            }
            sum[str.charAt(j) -'a'][j]++;
        }

        StringBuilder sb = new StringBuilder();
        while (N-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            char ch = st.nextToken().charAt(0);
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            sb.append(sum[ch-'a'][end] - (start == 0 ? 0 : sum[ch-'a'][start-1])).append('\n');
        }
        System.out.print(sb);
    }
}
