package baekjoon.p1002;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        StringTokenizer st = null;
        StringBuilder sb = new StringBuilder();
        while (T-- > 0) {
            st = new StringTokenizer(br.readLine());
            int x1 = Integer.parseInt(st.nextToken());
            int y1 = Integer.parseInt(st.nextToken());
            int r1 = Integer.parseInt(st.nextToken());
            int x2 = Integer.parseInt(st.nextToken());
            int y2 = Integer.parseInt(st.nextToken());
            int r2 = Integer.parseInt(st.nextToken());

            if (x1 == x2 && y1 == y2) {
                if (r1 == r2) {
                    sb.append(-1).append('\n');
                    continue;
                }
                sb.append(0).append('\n');
                continue;
            }

            int d = Math.abs(x1 - x2) * Math.abs(x1 - x2) + Math.abs(y1 - y2) * Math.abs(y1 - y2);
            if ((r1 - r2) * (r1 - r2) == d) {
                sb.append(1).append('\n');
            } else if ((r1 - r2) * (r1 - r2) > d) {
                sb.append(0).append('\n');
            } else if ((r1 + r2) * (r1 + r2) < d) {
                sb.append(0).append('\n');
            } else if ((r1 + r2) * (r1 + r2) == d) {
                sb.append(1).append('\n');
            } else {
                sb.append(2).append('\n');
            }
        }
        System.out.println(sb);
    }
}
