package baekjoon.p2798;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int[] nums;
    static int max = Integer.MIN_VALUE;
    static int M;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        nums = new int[N];

        st = new StringTokenizer(br.readLine());
        for(int i=0;i<N;i++){
            nums[i] = Integer.parseInt(st.nextToken());
        }
        dfs(0,0,new boolean[N]);

        System.out.println(max);

    }

    public static void dfs(int i, int size, boolean[] used){
        if(size==3){
            int sum = 0;
            if(sum == M){
                max = M;
                return;
            }
            for(int j=0;j<used.length;j++){
                if(used[j])
                    sum += nums[j];
            }
            if(sum <= M && sum>max)
                max = sum;
        }

        if(i==used.length)
            return;

        used[i] = true;
        dfs(i+1, size+1, used);
        used[i] = false;
        dfs(i+1, size, used);
    }
}
