package baekjoon.p1152;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine().trim();
        if(str.equals("")) {
            System.out.println(0);
            return;
        }
        System.out.println(str.split(" ").length);
    }
}
