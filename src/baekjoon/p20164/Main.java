package baekjoon.p20164;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String N = br.readLine();

        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;

        Queue<Pair> longQueue = new LinkedList<>();
        Queue<Pair> shortQueue = new LinkedList<>();
        if(N.length()>2) longQueue.add(new Pair(N, 0));

        while (!longQueue.isEmpty()) {
            Pair pair = longQueue.poll();
            String num = pair.num;
            int cnt = pair.cnt;
            int tmpCnt = cntOdd(num);
            for (int i = 1; i < num.length()-1; i++) {
                for (int j = i + 1; j < num.length(); j++) {
                    String tmpStr;
                    int A = Integer.parseInt(num.substring(0, i));
                    int B = Integer.parseInt(num.substring(i, j));
                    int C = Integer.parseInt(num.substring(j));
                    tmpStr = A + B + C + "";
                    if(tmpStr.length()>2) longQueue.add(new Pair(tmpStr, tmpCnt + cnt));
                    else shortQueue.add(new Pair(tmpStr, tmpCnt + cnt));
                }
            }
        }

        while (!shortQueue.isEmpty()) {
            Pair pair = shortQueue.poll();
            String num = pair.num;
            int cnt = pair.cnt;
            int tmpCnt = cntOdd(num);
            if (num.length() == 2) {
                String tmpStr;
                int A = Integer.parseInt(num.substring(0, 1));
                int B = Integer.parseInt(num.substring(1));
                tmpStr = A + B + "";
                shortQueue.add(new Pair(tmpStr, tmpCnt + cnt));
            } else {
                if(Integer.parseInt(num)%2==1) cnt++;
                if (max < cnt) max = cnt;
                if (min > cnt) min = cnt;
            }
        }
        System.out.println(min + " " + max);
    }

    public static int cntOdd(String n) {
        int cnt = 0;
        for (int i = 0; i < n.length(); i++) {
            if (Integer.parseInt(n.charAt(i) + "") % 2 != 0) {
                cnt++;
            }
        }
        return cnt;
    }

    static class Pair {
        String num;
        int cnt;

        public Pair(String num, int cnt) {
            this.num = num;
            this.cnt = cnt;
        }
    }
}
