package level1.countvowels;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());

        Set<Character> set = new HashSet<>();
        set.add('a'); set.add('e'); set.add('i'); set.add('o'); set.add('u');

        for(int j=0;j<n;j++){
            String s = scanner.nextLine();
            int count = 0;
            for(int i=0;i<s.length();i++){
                if(set.contains(s.charAt(i))){
                    count++;
                }
            }
            System.out.println(count);
        }
    }
}
