package baekjoon.p4659;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        String aeiou = "aeiou";
        while (true) {
            String str = br.readLine();
            if(str.equals("end")) break;

            boolean isAvailable = true;
            char lastChar = ' ';
            boolean isSuccessive = false;
            for (int i = 0; i < str.length(); i++) {
                char currChar = str.charAt(i);
                if (lastChar == ' ') {
                    lastChar = currChar;
                    continue;
                }
                if (lastChar == currChar) {
                    if (currChar != 'e' && currChar != 'o') {
                        isAvailable = false;
                        break;
                    }
                }
                if (aeiou.contains(lastChar + "") == aeiou.contains(currChar + "")) {
                    if (isSuccessive) {
                        isAvailable = false;
                        break;
                    } else {
                        isSuccessive = true;
                    }
                } else {
                    isSuccessive = false;
                }
                lastChar = currChar;
            }
            boolean containsAeiou = false;
            for (int i = 0; i < str.length(); i++) {
                if (aeiou.contains(str.charAt(i) + "")) {
                    containsAeiou = true;
                    break;
                }
            }
            if(!containsAeiou) isAvailable = false;
            sb.append('<'+str+"> is ");
            if (!isAvailable) {
                sb.append("not ");
            }
            sb.append("acceptable.\n");
        }
        System.out.println(sb);
    }
}
