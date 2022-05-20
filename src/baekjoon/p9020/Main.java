package baekjoon.p9020;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        boolean[] isPrime = new boolean[10001];
        Arrays.fill(isPrime, true);
        isPrime[0] = isPrime[1] = false;
        for (int i = 2; i <= 10000; i++) {
            if (isPrime[i]) {
                int j =i;
                while ((j += i) <= 10000){
                    isPrime[j] = false;
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        while (T-- > 0) {
            int n = Integer.parseInt(br.readLine());
            int a = n/2;
            int b = n/2;
            if(n%2!=0){
                b+=1;
            }
            while(true){
                if(isPrime[a] && isPrime[b]){
                    sb.append(a).append(' ').append(b).append('\n');
                    break;
                }
                a--;
                b++;
            }
        }
        System.out.println(sb);
    }
}
