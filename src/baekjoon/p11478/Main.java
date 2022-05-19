package baekjoon.p11478;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();

        Set<String> set = new HashSet<>();
        int n = str.length();
        for (int i = 0; i < n; i++) {
            for (int j = i+1; j < n+1; j++) {
                set.add(str.substring(i, j));
            }
        }
        System.out.println(set.size());
    }
}
