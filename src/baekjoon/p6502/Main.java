package baekjoon.p6502;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        for(int i=1;;i++) {
            String str = br.readLine();
            if (str.equals("0")) {
                break;
            }
            StringTokenizer st = new StringTokenizer(str);
            int r = Integer.parseInt(st.nextToken());
            double w = Integer.parseInt(st.nextToken())/2.0;
            double l = Integer.parseInt(st.nextToken())/2.0;
            sb.append("Pizza ").append(i);
            if (r * r >= w * w + l * l) {
                sb.append(" fits on the table.\n");
            } else
                sb.append(" does not fit on the table.\n");
        }
        System.out.println(sb);

    }
}
