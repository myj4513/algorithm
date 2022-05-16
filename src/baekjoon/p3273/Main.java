package baekjoon.p3273;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] nums = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            nums[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(nums);

        int target = Integer.parseInt(br.readLine());
        int start = 0;
        int end = N-1;

        int result = 0;
        while(start<end){
            if(nums[start] + nums[end] <= target){
                if(nums[start] + nums[end] == target) result++;
                start++;
            } else {
                end--;
            }
        }
        System.out.println(result);
    }
}
