package baekjoon.p21919;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < N; i++) {
            int n = Integer.parseInt(st.nextToken());
            if (isPrime(n)) {
                set.add(n);
            }
        }
        if (set.size()==0){
            System.out.println(-1);}
        else{
            long result = 1;
            for (Integer integer : set) {
                result *= integer;
            }
            System.out.println(result);
        }

    }

    private static boolean isPrime(int n) {
        if (n < 2) {
            return false;
        }
        for (int i = 2; i * i <= n; i++) {
            if (n % i == 0) return false;
        }
        return true;
    }
}
