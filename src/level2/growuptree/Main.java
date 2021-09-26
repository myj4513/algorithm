package level2.growuptree;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int count = 0;
        List<Integer> list = new ArrayList<>();
        String s = Integer.toString(n, 2);

        for(int i=0;i<s.length();i++) {
            if (s.charAt(i) == '1') {
                count++;
                list.add(i+1);
            }
        }
        System.out.println(count);
        list.stream().forEach(e-> System.out.println(e));
        System.out.println(s.length()+1);
    }
}
