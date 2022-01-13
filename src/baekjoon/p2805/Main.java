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

//        System.out.println(Arrays.toString(trees));
        long start = 0;
        long end = trees[N-1];
        long result = binarySearch(start, end, M);
        System.out.println(result);
    }

    public static long binarySearch(long start, long end, int target){
        long tmp = -1;
        boolean isOver = false;
        while (end - start >= 0) {
            tmp = (end + start) / 2;
            long sum = 0;
            for (int i = 0; i < N; i++) {
                sum += (trees[i] > tmp ? trees[i] - tmp : 0);
            }
//            System.out.println("end = " + end);
//            System.out.println("start = " + start);
//            System.out.println("sum = " + sum);
//            System.out.println("tmp = " + tmp);
//            System.out.println("====================");
            if(sum < target){
                end = tmp - 1;
                isOver = false;
            }
            else if(sum > target){
                start = tmp + 1;
                isOver = true;
            }
            else {
                return tmp;
            }
        }

        return isOver?tmp:tmp - 1;
    }
}
