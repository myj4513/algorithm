package level2.judge1011;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        for(int i=0;i<n;i++){
            int m = Integer.parseInt(scanner.nextLine());
            int[] bridge = new int[m];
            String[] s = scanner.nextLine().split(" ");
            if(m<3) {
                System.out.println(0);
            }

            else{
                for(int j=0;j<m;j++){
                    bridge[j] = Integer.parseInt(s[j]);
                }

                for(int j=3;j<m;j++){
                    int min = Math.min(Math.min(bridge[j - 1], bridge[j - 2]), bridge[j - 3]);
                    bridge[j] += min;
//                System.out.println("j = " + j);
//                System.out.println(Arrays.toString(bridge));
                }
                System.out.println(Math.min(Math.min(bridge[m - 1], bridge[m - 2]), bridge[m - 3]));
            }
        }
    }
}
