package baekjoon.p1068;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int cnt = 0;
    static Map<Integer, List<Integer>> tree;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        tree = new HashMap<>();
        for (int i = 0; i < N; i++) {
            tree.put(i, new ArrayList<>());
        }
        int root = -1;
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            int parent = Integer.parseInt(st.nextToken());
            if (parent == -1) {
                root = i;
                continue;
            }
            tree.get(parent).add(i);
        }

        int remove = Integer.parseInt(br.readLine());
        if (remove == root) {
            System.out.println(0);
        } else {
            remove(remove);
            remove2(remove);
            cntLeaf();
            System.out.println(cnt);
        }
    }

    private static void cntLeaf() {
        for (Integer integer : tree.keySet()) {
            if(tree.get(integer).size()==0) cnt++;
        }
    }

    public static void remove(int data) {
        List<Integer> list = tree.get(data);
        for (Integer integer : list) {
            remove(integer);
        }
        tree.remove(data);
    }

    public static void remove2(int data) {
        for (Integer integer : tree.keySet()) {
            if(tree.get(integer).contains(data)) tree.get(integer).remove(Integer.valueOf(data));
        }
    }
}
