package baekjoon.p4358;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Map;
import java.util.TreeMap;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        Map<String, Double> map = new TreeMap<>();

        int N = 0;
        while (true) {
            String tree = br.readLine();

            if (tree == null || tree.length()==0) {
                break;
            }

            N++;
            if (map.containsKey(tree)) {
                map.put(tree, map.get(tree) + 1);
            } else {
                map.put(tree, 1.0);
            }
        }

        for (String tree : map.keySet()) {
            double n = map.get(tree);
            double percent = n/N * 100;
            sb.append(tree + " " + String.format("%.4f",percent)+"\n");
        }
        System.out.println(sb);
    }
}
