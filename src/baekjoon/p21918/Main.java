package baekjoon.p21918;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int[] bulb;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        bulb = new int[N + 1];
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            bulb[i] = Integer.parseInt(st.nextToken());
        }

        while (M-- > 0) {
            st = new StringTokenizer(br.readLine());
            int command = Integer.parseInt(st.nextToken());
            int param1 = Integer.parseInt(st.nextToken());
            int param2 = Integer.parseInt(st.nextToken());
            switch (command) {
                case 1:
                    change(param1, param2);
                    break;
                case 2:
                    toggle(param1, param2);
                    break;
                case 3:
                    off(param1, param2);
                    break;
                case 4:
                    on(param1, param2);
                    break;
            }
        }

        for (int i = 1; i <= N; i++) {
            sb.append(bulb[i] + " ");
        }
        System.out.println(sb);
    }

    public static void change(int i, int x){
        bulb[i] = x;
    }

    public static void toggle(int l, int r){
        for (int i = l; i <= r; i++) {
            bulb[i] = bulb[i]==1?0:1;
        }
    }

    public static void on(int l, int r){
        for (int i = l; i <= r; i++) {
            bulb[i] = 1;
        }
    }

    public static void off(int l, int r){
        for (int i = l; i <= r; i++) {
            bulb[i] = 0;
        }
    }
}
