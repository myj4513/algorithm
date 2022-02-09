package baekjoon.p2503;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;
        int N = Integer.parseInt(br.readLine());

        List<String> list = new ArrayList<>();
        for (int i = 1; i <= 9; i++) {
            for (int j = 1; j <= 9; j++) {
                if (j != i) {
                    for (int k = 1; k <= 9; k++) {
                        if (k != j && k != i) {
                            list.add("" + i + j + k);
                        }
                    }
                }
            }
        }

        while (N-- > 0) {
            st = new StringTokenizer(br.readLine());
            String target = st.nextToken();
            int strike = Integer.parseInt(st.nextToken());
            int ball = Integer.parseInt(st.nextToken());

            for (int i = 0; i < list.size(); i++) {
                String str = list.get(i);
                if (!solve(str,target, strike, ball)) {
                    list.remove(i);
                    i--;
                }
            }
        }
        System.out.println(list.size());
    }

    private static boolean solve(String str, String target, int strike, int ball) {
        int cntStrike = 0;
        int cntBall = 0;

        for (int i = 0; i < 3; i++) {
            if(str.charAt(i) == target.charAt(i)) cntStrike++;
            else if(target.contains(str.charAt(i)+"")) cntBall++;
        }
        if(cntStrike==strike && cntBall==ball) return true;
        return false;
    }
}
