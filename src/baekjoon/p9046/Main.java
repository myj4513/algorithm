package baekjoon.p9046;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < N; i++) {
            String str = br.readLine();
            int[] count = new int[26];

            for (int j = 0; j < str.length(); j++) {
                if(str.charAt(j)==' ') continue;
                count[str.charAt(j) - 'a']++;
            }
            boolean multi = false;
            int maxCnt = -1;
            char max=' ';
            for (int j = 0; j < 26; j++) {
                if (count[j] > maxCnt) {
                    maxCnt = count[j];
                    max = (char)(j +'a');
                    multi = false;
                } else if (count[j] == maxCnt) {
                    multi = true;
                }
            }
            if(multi)
                sb.append("?\n");
            else
                sb.append(max + "\n");
        }
        System.out.println(sb);
    }
}
