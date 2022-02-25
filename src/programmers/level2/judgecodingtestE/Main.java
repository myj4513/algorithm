package programmers.level2.judgecodingtestE;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        for(int i=0;i<n;i++){
            int number = Integer.parseInt(scanner.nextLine());
            int x2 = 1;
            int x5 = 1;
            int count2 = -1;
            int count5 = -1;
            while(x5<=number){
                x5*=5;
                count5++;
            }
            while(x2<=number){
                x2*=2;
                count2++;
            }
            System.out.println(Math.min(count2, count5));
        }
    }
}
