package baekjoon.p9934;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    static List<List<Integer>> list = new ArrayList<>();
    static int[] inorder;
    static int K;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        K = Integer.parseInt(br.readLine());
        for (int i = 0; i < K; i++) {
            list.add(new ArrayList<>());
        }

        int size = (int)Math.pow(2,K)-1;

        inorder = new int[size];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < size; i++) {
            inorder[i] = Integer.parseInt(st.nextToken());
        }

        solve(0, 0, inorder.length-1);
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < K; i++) {
            List<Integer> list = Main.list.get(i);
            for (int j = 0; j < list.size(); j++) {
                sb.append(list.get(j)).append(" ");
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }

    private static void solve(int depth, int start, int end) {
        if(depth == K) return;
        int mid = (start + end) /2;
        list.get(depth).add(inorder[mid]);

        solve(depth + 1, start, mid-1);
        solve(depth + 1, mid + 1, end);

    }
}
