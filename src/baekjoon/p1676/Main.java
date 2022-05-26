package baekjoon.p1676;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
//        if(N==0){
//            System.out.println(1);
//            return;
//        }
        int cnt2 = 0, cnt5 = 0;
        for (int i = 2; i <= N; i++) {
            int tmp2 = i, tmp5 = i;
            while(tmp2%2==0){
                tmp2/=2;
                cnt2++;
            }
            while(tmp5%5==0){
                tmp5/=5;
                cnt5++;
            }
        }
        System.out.println(Math.min(cnt2, cnt5));
    }
}
