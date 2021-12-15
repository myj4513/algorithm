package baekjoon.p22864;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int A = Integer.parseInt(st.nextToken()); //시간 당 피로도
        int B = Integer.parseInt(st.nextToken()); //시작 당 작업량
        int C = Integer.parseInt(st.nextToken()); //휴식 시 회복량
        int M = Integer.parseInt(st.nextToken()); //최대 피로도

        int work = 0;
        int fatigue = 0;
        for(int i=0;i<24;i++){
            if(fatigue+A <= M){
                work += B;
                fatigue += A;
            }
            else{
                fatigue -= C;
                if(fatigue <0)
                    fatigue = 0;
            }
        }
        System.out.println(work);
    }
}
