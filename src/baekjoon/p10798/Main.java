package baekjoon.p10798;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        String[] strArr = new String[5];
        int maxLength = -1;
        for (int i = 0; i < 5; i++) {
            strArr[i] = br.readLine();
            maxLength = maxLength < strArr[i].length() ? strArr[i].length() : maxLength;
        }

        for (int i = 0; i < maxLength; i++) {
            for (int j = 0; j < 5; j++) {
                if (strArr[j].length() > i) {
                    sb.append(strArr[j].charAt(i));
                }
            }
        }
        System.out.println(sb);
    }
}
