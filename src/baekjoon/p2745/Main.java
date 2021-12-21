package baekjoon.p2745;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        String N = st.nextToken();
        int B = Integer.parseInt(st.nextToken());

        int result = 0;
        int r = 0;
        for(int i=N.length()-1;i>=0;i--){
            char c = N.charAt(i);
            int n = 0;
            if(c<='Z' && c>='A'){
                n = c - 55;
            }else {
                n = Integer.parseInt(String.valueOf(c));
            }
            result += Math.pow(B, r++) * n;
        }
        System.out.println(result);
    }
}
