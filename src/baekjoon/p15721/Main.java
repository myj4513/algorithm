package baekjoon.p15721;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int A = Integer.parseInt(br.readLine());
        int T = Integer.parseInt(br.readLine());
        int cry = Integer.parseInt(br.readLine());

        int order = 2;
        int cryCnt = 1;
        int memberPos = 0;
        while (true) {
            int[] cryArr = new int[4 + order * 2];
            cryArr[0] = 0;
            cryArr[1] = 1;
            cryArr[2] = 0;
            cryArr[3] = 1;
            for (int i = 4 + order; i < cryArr.length; i++) {
                cryArr[i] = 1;
            }

            for (int i = 0; i < cryArr.length; i++) {
                if (cryArr[i] == cry) {
                    if (cryCnt == T) {
                        System.out.println(memberPos);
                        return;
                    }
                    cryCnt++;

                }
                memberPos++;
                if(memberPos >= A)
                    memberPos = 0;
            }
            order++;
        }
    }
}
