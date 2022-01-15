package baekjoon.p14467;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;
        int N = Integer.parseInt(br.readLine());

        int result = 0;

        Map<Integer, Integer> cowMap = new HashMap<>();
        while (N-- > 0) {
            st = new StringTokenizer(br.readLine());
            int cowNum = Integer.parseInt(st.nextToken());
            int pos = Integer.parseInt(st.nextToken());

            if (cowMap.containsKey(cowNum)) {
                int prevPos = cowMap.get(cowNum);
                if (prevPos != pos) {
                    result++;
                    cowMap.put(cowNum, pos);
                }
            } else {
                cowMap.put(cowNum, pos);
            }
        }
        System.out.println(result);
    }
}
