package baekjoon.p10815;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(br.readLine());
        int[] cards = new int[N];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            cards[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(cards);
        int M = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        while (M-- > 0) {
            sb.append((binarySearch(Integer.parseInt(st.nextToken()), cards)?"1":"0") + " ");
        }
        System.out.println(sb);
    }

    public static boolean binarySearch(int target, int[] cards){
        int end = cards.length-1;
        int start = 0;
        while (end - start > 0) {
            int tmp = (end + start) / 2;
            if(target == cards[end] || target == cards[start] || target == cards[tmp])
                return true;
            if (target < cards[tmp]) {
                end = tmp-1;
            }
            else{
                start = tmp + 1;
            }
        }
        return false;
    }
}
