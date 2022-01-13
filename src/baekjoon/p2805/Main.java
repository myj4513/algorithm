package baekjoon.p2805;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    static int[] trees;
    static int N;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        trees = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            trees[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(trees);
        int start = 0;
        int end = N-1;
        int result = binarySearch(start, end, M);
        System.out.println(result);
    }

    public static int binarySearch(int start, int end, int target){
        int tmp = (end + start) / 2;
        while (end - start > 0) {

            long sum = 0;
            for (int i = 0; i < N; i++) {
                sum += (trees[i] - trees[tmp] <= 0 ? 0 : trees[i] - trees[tmp]);
            }
            System.out.println(sum);
            if(sum < target){
                end = tmp - 1;
            }
            else if(sum > target){
                start = tmp;
            }
            else {
                return trees[tmp];
            }
            tmp = (end + start) / 2;
        }

        return trees[tmp]-1;
    }
}
