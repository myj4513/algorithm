package level2.judgetestb;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());

        for(int i=0;i<n;i++){
            int C = Integer.parseInt(scanner.nextLine());
            int[] A = new int[C];
            int[] B = new int[C];
            String[] strA = scanner.nextLine().split(" ");
            String[] strB = scanner.nextLine().split(" ");
            for(int j=0;j<C;j++){
                A[j] = Integer.parseInt(strA[j]);
                B[j] = Integer.parseInt(strB[j]);
            }

            boolean success = true;

            for(int j=0;j<C;j++){
                success = true;
                long fuel = 0L;
                for(int k=j;k<j+C;k++){
                    int idx = k>=C?k%C:k;
                    fuel += A[idx];      //연료주입
                    if(fuel < B[idx]) { //주유량보다 연료가 큰경우 탈출 후 다음 진행
                        success = false; //여행 실패
                        break;
                    }
                    fuel -= B[idx];   //연료차감
                }
                if(success) {
                    System.out.println(j);  //여행 성공시 인덱스 출력
                    break;
                }
            }
            if(!success) System.out.println(-1); //여행 불가 시 -1 출력
        }
    }
}
