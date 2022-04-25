package baekjoon.p9536;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        while (T-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            List<String> list = new ArrayList<>();
            while (st.hasMoreTokens()) {
                list.add(st.nextToken());
            }
            String s = br.readLine();
            List<String> sounds = new ArrayList<>();
            while (!s.equals("what does the fox say?")) {
                StringTokenizer st2 = new StringTokenizer(s);
                st2.nextToken(); st2.nextToken();
                sounds.add(st2.nextToken());
                s = br.readLine();
            }
            list.removeAll(sounds);
            StringBuilder sb = new StringBuilder();
            list.forEach(ss -> sb.append(ss).append(' '));
            System.out.println(sb);
        }

    }
}
