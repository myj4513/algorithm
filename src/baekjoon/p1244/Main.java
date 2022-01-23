package baekjoon.p1244;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int[] switches;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());
        switches = new int[N+1];
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            switches[i] = Integer.parseInt(st.nextToken());
        }
        int T = Integer.parseInt(br.readLine());

        while (T-- > 0) {
            st = new StringTokenizer(br.readLine());
            int sex = Integer.parseInt(st.nextToken());
            int target = Integer.parseInt(st.nextToken());

            if (sex == 1) {
                int curPos = target;
                while (curPos <= N) {
                    toggle(curPos);
                    curPos += target;
                }
            } else {
                int range = 1;
                while (true) {
                    if (target + range <= N && target - range > 0) {
                        if (switches[target + range] != switches[target - range]) {
                            range--;
                            break;
                        }
                        range++;
                    } else{
                        range--;
                        break;
                    }
                }
                for (int i = target - range; i <= target + range; i++) {
                    toggle(i);
                }
            }
        }
        int cnt = 0;
        for (int i = 1; i <= N; i++) {
            sb.append(switches[i] + " ");
            cnt++;
            if (cnt == 20) {
                sb.append("\n");
                cnt = 0;
            }
        }
        System.out.println(sb);
    }

    public static void toggle(int target) {
        switches[target] = switches[target] == 0 ? 1 : 0;
    }
}
