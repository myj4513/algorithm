package baekjoon.p6550;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str;
        while ((str=br.readLine()) != null) {
            StringTokenizer st = new StringTokenizer(str);
            String sub = st.nextToken();
            String main = st.nextToken();
            if (isSub(sub, main)) {
                System.out.println("Yes");
            } else {
                System.out.println("No");
            }
        }
    }

    private static boolean isSub(String sub, String main) {
        int mainIdx = 0;
        for (int i = 0; i < sub.length(); i++) {
            char ch = sub.charAt(i);
            while (true) {
                if(mainIdx == main.length()) return false;
                char mainChar = main.charAt(mainIdx);
                mainIdx++;
                if (mainChar == ch) {
                    break;
                }
            }
        }
        return true;
    }
}
