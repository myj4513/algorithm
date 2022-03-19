package baekjoon.p21275;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        String strA = st.nextToken();
        String strB = st.nextToken();

        int cnt=0;
        for (int i = 2; i <= 36; i++) {
            for (int j = 2; j <= 36; j++) {
                if(i==j) continue;
                try {
                    if (Long.parseLong(strA, i) == Long.parseLong(strB, j)) {
                        cnt++;
                        if (cnt > 1) {
                            System.out.println("Multiple");
                            return;
                        }
                        sb.append(Long.parseLong(strA, i)).append(' ').append(i).append(' ').append(j);
                    }
                } catch (NumberFormatException e) {}
            }
        }
        if(cnt==0)
            System.out.println("Impossible");
        else
            System.out.println(sb);
    }
}
