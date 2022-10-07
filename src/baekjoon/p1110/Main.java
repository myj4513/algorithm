package baekjoon.p1110;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String initNum = br.readLine();
        String newNum = initNum;
        int count = 0;
        while (true) {
            if (newNum.equals(initNum) && count != 0) {
                break;
            }
            String copy = newNum;
            int sum = 0;
            for (int i = 0; i < copy.length(); i++) {
                sum += (copy.charAt(i) - '0');
            }
            newNum = String.valueOf(Integer.parseInt(copy) % 10 * 10 + (sum % 10));
            count++;
        }
        System.out.println(count);
    }
}