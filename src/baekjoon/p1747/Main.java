package baekjoon.p1747;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        while (true) {
            if (isPrime(N) && isPalindrome(N)) {
                System.out.println(N);
                return;
            }
            N++;
        }
    }

    private static boolean isPalindrome(int n) {
        String str = String.valueOf(n);
        int start = 0, end = str.length()-1;
        while (start < end) {
            if (str.charAt(start) != str.charAt(end)) {
                return false;
            }
            start++;
            end--;
        }
        return true;
    }

    private static boolean isPrime(int n) {
        if(n<2) return false;
        for (int i = 2; i * i <= n; i++) {
            if(n%i==0) return false;
        }
        return true;
    }
}
