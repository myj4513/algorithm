package level2.judge1018;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());

        for(int j=0;j<n;j++){
            int min = Integer.MAX_VALUE;
            String[] str = scanner.nextLine().split(" ");
            for(int i=0;i<str[1].length()-str[0].length()+1;i++){
                int length = 0;
                for(int k=0;k<str[0].length();k++){
                    if(str[0].charAt(k)!=str[1].charAt(i+k)) length++;
                }
                if(length<min) min = length;
            }
            System.out.println(min);
        }
    }
}
