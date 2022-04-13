package baekjoon.p2153;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        int sum = 0;
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            if ('a' <= c && c <= 'z') {
                sum += c - 'a' + 1;
            } else {
                sum += c - 'A' + 1;
            }
        }

        if (isPrime(sum)) {
            System.out.println("It is a prime word.");
        } else
            System.out.println("It is not a prime word.");
    }

    private static boolean isPrime(int sum) {
        for (int i = 2; i * i <= sum; i++) {
            if (sum % 2 == 0) {
                return false;
            }
        }
        return true;
    }
}
