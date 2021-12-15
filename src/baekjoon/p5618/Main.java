package baekjoon.p5618;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        int[] nums = new int[n];
        for(int i=0;i<n;i++){
            nums[i] = Integer.parseInt(st.nextToken());
        }
        int min = nums[0];
        for(int i=1;i<n;i++){
            if(nums[i]<min)
                min = nums[i];
        }

        for(int i=1;i<=min;i++){
            boolean bool = true;
            for(int j=0;j<n;j++){
                if(nums[j]%i!=0){
                    bool = false;
                    break;
                }
            }
            if(bool){
                sb.append(i + "\n");
            }
        }
        System.out.println(sb);
    }
}
