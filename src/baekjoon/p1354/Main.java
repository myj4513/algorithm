package baekjoon.p1354;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {
    static long P;
    static long Q;
    static long X;
    static long Y;
    static Map<Long, Long> map;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        long N = Long.parseLong(st.nextToken());
        P = Integer.parseInt(st.nextToken());
        Q = Integer.parseInt(st.nextToken());
        X = Integer.parseInt(st.nextToken());
        Y = Integer.parseInt(st.nextToken());

        map = new HashMap<>();

        System.out.println(solve(N));
    }

    private static long solve(long n) {
        if (n <= 0)
            return 1;
        else {
            if(map.containsKey(n)) return map.get(n);
            else{
                long temp = solve(n / P - X) + solve(n / Q - Y);
                map.put(n, temp);
                return temp;
            }
        }
    }
}
