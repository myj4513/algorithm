package level2.pureprofit;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        int[] answer = new int[n];
        for(int i=0;i<n;i++){
            String[] str = scanner.nextLine().split(" ");
            int P = Integer.parseInt(str[0]);
            int K = Integer.parseInt(str[1]);
            int min = (int)((3*K*P)/(double)(K+9));
            int max = (int)((3*K*(P+4))/(double)(K+9));
            for(int j=min;j<=max;j++){
                if(j%3==0 || j%K==0){
                    int M = j/3 + 3*(j/K);
                    if(M==P){
                        answer[i] = j;
                        break;
                    }
                    if(M>P){
                        answer[i] = -1;
                        break;
                    }
                }
            }
        }
        for (int i : answer) {
            System.out.println(i);
        }
    }
}
