package baekjoon.p1427;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < str.length(); i++) {
            list.add(str.charAt(i) - '0');
        }
        Collections.sort(list, Comparator.reverseOrder());
        StringBuilder sb = new StringBuilder();
        list.forEach(i -> sb.append(i));
        System.out.println(sb);
    }
}
