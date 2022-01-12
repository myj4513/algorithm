package baekjoon.p1212;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        String[] converter = new String[]{"000", "001", "010", "011", "100", "101", "110", "111"};
        String octa = br.readLine();
        if (octa.equals("0")) {
            System.out.println(0);
            return;
        }
        for (int i = 0; i < octa.length(); i++) {
            sb.append(converter[Integer.parseInt(String.valueOf(octa.charAt(i)))]);
        }
        String result = sb.toString();

        while(true){
            if (result.charAt(0) == '0') {
                result = result.substring(1);
            }
            else{
                break;
            }
        }
        System.out.println(result);
    }
}
