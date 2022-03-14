package baekjoon.p3053;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        double R = Double.parseDouble(br.readLine());

        double euclid = Math.round(Math.PI * R * R * 1000000) / 1000000.0;
        double taxi = Math.round(2 * R * R * 1000000) / 1000000.0;
        System.out.println(euclid);
        System.out.println(taxi);
    }
}
