package baekjoon.p9079;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static Set<String> set;
    static Queue<CoinCnt> queue;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;
        int T = Integer.parseInt(br.readLine());

        while (T-- > 0) {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < 3; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < 3; j++) {
                    if(st.nextToken().equals("H")) sb.append("1");
                    else sb.append("0");
                }
            }
            boolean isSolvable = false;
            set = new HashSet();
            queue = new LinkedList<>();
            set.add(sb.toString());
            queue.add(new CoinCnt(sb.toString(), 0));
            while (!queue.isEmpty()) {
                CoinCnt coinCnt = queue.poll();
                if(isSolved(coinCnt.s)){
                    isSolvable = true;
                    System.out.println(coinCnt.cnt);
                    break;
                }
                flip(coinCnt);
            }
            if(!isSolvable) System.out.println(-1);
        }
    }

    public static void flip(CoinCnt coinCnt) {
        StringBuilder sb = new StringBuilder();
        String str = coinCnt.s;
        //가로
        for (int i = 0; i < 9; i++) {
            if(0<=i && i<3) sb.append(toggle(str.charAt(i)));
            else sb.append(str.charAt(i));
        }
        addToQueue(sb.toString(), coinCnt.cnt);
        sb = new StringBuilder();
        for (int i = 0; i < 9; i++) {
            if(3<=i && i<6) sb.append(toggle(str.charAt(i)));
            else sb.append(str.charAt(i));
        }
        addToQueue(sb.toString(), coinCnt.cnt);
        sb = new StringBuilder();
        for (int i = 0; i < 9; i++) {
            if(6<=i && i<9) sb.append(toggle(str.charAt(i)));
            else sb.append(str.charAt(i));
        }
        addToQueue(sb.toString(), coinCnt.cnt);
        sb = new StringBuilder();
        //세로
        for (int i = 0; i < 9; i++) {
            if((i+1)%3==0) sb.append(toggle(str.charAt(i)));
            else sb.append(str.charAt(i));
        }
        addToQueue(sb.toString(), coinCnt.cnt);
        sb = new StringBuilder();
        for (int i = 0; i < 9; i++) {
            if((i+1)%3==1) sb.append(toggle(str.charAt(i)));
            else sb.append(str.charAt(i));
        }
        addToQueue(sb.toString(), coinCnt.cnt);
        sb = new StringBuilder();
        for (int i = 0; i < 9; i++) {
            if((i+1)%3==2) sb.append(toggle(str.charAt(i)));
            else sb.append(str.charAt(i));
        }
        addToQueue(sb.toString(), coinCnt.cnt);
        sb = new StringBuilder();
        //대각선
        for (int i = 0; i < 9; i++) {
            if(i==0 || i==4 || i==8) sb.append(toggle(str.charAt(i)));
            else sb.append(str.charAt(i));
        }
        addToQueue(sb.toString(), coinCnt.cnt);
        sb = new StringBuilder();
        for (int i = 0; i < 9; i++) {
            if(i==2 || i==4 || i==6) sb.append(toggle(str.charAt(i)));
            else sb.append(str.charAt(i));
        }
        addToQueue(sb.toString(), coinCnt.cnt);
    }

    public static void addToQueue(String str, int cnt) {
        if (set.add(str)) {
            queue.add(new CoinCnt(str, cnt + 1));
        }
    }

    public static char toggle(char ch) {
        if(ch=='1') return '0';
        else return '1';
    }

    public static boolean isSolved(String str) {
        for (int i = 0; i < 8; i++) {
            if (str.equals("000000000") || str.equals("111111111")) {
                return true;
            }
        }
        return false;
    }

    static class CoinCnt{
        String s;
        int cnt;

        public CoinCnt(String s, int cnt) {
            this.s = s;
            this.cnt = cnt;
        }

        @Override
        public int hashCode() {
            return s.hashCode();
        }

        @Override
        public boolean equals(Object obj) {
            CoinCnt cc = (CoinCnt) obj;
            return this.s.equals(cc.s);
        }
    }
}
