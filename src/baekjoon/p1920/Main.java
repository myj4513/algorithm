package baekjoon.p1920;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    private static int[] arr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        arr = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr);

        int M = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        while (M-- > 0) {
            int n = Integer.parseInt(st.nextToken());
            if (binarySearch(0, N - 1, n)) {
                sb.append(1);
            } else {
                sb.append(0);
            }
            sb.append('\n');
        }
        System.out.println(sb);
    }

    private static boolean binarySearch(int start, int end, int n) {
        if(start >= end) return false;
        int mid = (start + end)/2;
        if (arr[mid] == n) {
            return true;
        } else if (arr[mid] > n) {
            end = mid-1;
        } else {
            start = mid + 1;
        }
        return binarySearch(start, end, n);
    }
}
