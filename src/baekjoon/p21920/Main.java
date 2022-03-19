package baekjoon.p21920;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int X = Integer.parseInt(br.readLine());
        long sum = 0;
        int cnt = 0;

        for (int i = 0; i < N; i++) {
            if (gcd(X, arr[i]) == 1) {
                sum += arr[i];
                cnt++;
            }
        }

        System.out.println(1.0*sum/cnt);
    }

    private static int gcd(int a, int b) {
        if(a%b==0)
            return b;
        else
            return gcd(b, a % b);
    }
}
