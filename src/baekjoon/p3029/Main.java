package baekjoon.p3029;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st1 = new StringTokenizer(br.readLine());
        StringTokenizer st2 = new StringTokenizer(br.readLine());

        int[] start = new int[3];
        int[] end = new int[3];
        for(int i=0;i<3;i++){
            start[i] = Integer.parseInt(st1.nextToken(":"));
            end[i] = Integer.parseInt(st2.nextToken(":"));
        }

        if(Arrays.equals(start,end)){
            System.out.println("24:00:00");
            return;
        }

        int[] result = new int[3];
        if(start[2]>end[2]){
            end[1] -= 1;
            end[2] += 60;
        }

        if(start[1]>end[1]){
            end[0] -= 1;
            end[1] += 60;
        }

        if(end[0]<0 || start[0]>end[0]){
            end[0] += 24;
        }

        result[2] = end[2] - start[2];
        result[1] = end[1] - start[1];
        result[0] = end[0] - start[0];
        System.out.printf("%02d:%02d:%02d",result[0],result[1],result[2]);

    }
}
