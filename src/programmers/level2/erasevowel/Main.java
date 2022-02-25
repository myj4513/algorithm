package programmers.level2.erasevowel;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Character> vowels = Arrays.asList('a', 'e', 'i', 'o', 'u');
        int n = Integer.parseInt(scanner.nextLine());
        for(int j=0;j<n;j++){
            int answer = 0;
            String s = scanner.nextLine();
            for(int i=0;i<s.length();i++){
                if(vowels.contains(s.charAt(i))){
                    answer += s.length()-i-1;
                }
            }
            System.out.println(answer);
        }
    }
}
