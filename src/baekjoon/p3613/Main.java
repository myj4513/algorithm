package baekjoon.p3613;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        boolean hasUpper = false;
        boolean hasBar = false;
        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            if(Character.isUpperCase(ch)) hasUpper = true;
            else if(ch == '_') hasBar = true;
        }

        if (hasUpper && hasBar) {
            System.out.println("Error!");
            return;
        }
        StringBuilder sb = new StringBuilder();
        if (hasBar) {
            System.out.println('A'-'a');
            StringTokenizer st = new StringTokenizer(str, "_");
            while(st.hasMoreTokens()) {
                String s = st.nextToken();
                sb.append((char)(s.charAt(0)+32)).append(s.substring(1));
            }
        }
        System.out.println(sb);
    }
}
