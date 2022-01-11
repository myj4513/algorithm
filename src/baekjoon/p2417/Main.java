package baekjoon.p2417;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        long n = Long.parseLong(br.readLine());

        long start = 0L;
        long end = n;
        while (end - start > 0) {
            long tmp = (end + start)/2;
            if (tmp >= Math.sqrt(n)) {
                end = tmp;
            }
            else{
                start = tmp + 1;
            }
        }
        System.out.println(end);
    }
}
