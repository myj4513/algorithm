package programmers.level2.judgetestc;

import java.util.Scanner;

public class Main {
    static int MAX = Integer.MIN_VALUE;
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine()); //테스트 케이스수

        for(int j=0;j<n;j++){
            String[] str = scanner.nextLine().split(" ");
            int size = Integer.parseInt(str[0]);
            int N = Integer.parseInt(str[1]);
            int[] w = new int[N];  //아이템 무게
            int[] p = new int[N];  //아이템 이득
            boolean[] used = new boolean[N]; //사용여부
            str = scanner.nextLine().split(" ");
            for(int i=0;i<N;i++){
                p[i] = Integer.parseInt(str[2 * i]);
                w[i] = Integer.parseInt(str[2 * i + 1]);
            }

            recur(size, 0, used, w, p, 0, 0);
            System.out.println(MAX);
            MAX = Integer.MIN_VALUE;
        }
    }

    public static void recur(int size, int idx, boolean[] used, int[] w, int[] p, int weight, int price){
        if(idx == w.length){
            if(price>MAX) MAX = price;
            return;
        }

        if(!used[idx] && weight + w[idx] <= size){
            used[idx] = true;
            recur(size, idx + 1, used, w, p, weight + w[idx], price + p[idx]);
            used[idx] = false;
        }
        recur(size, idx + 1, used, w, p, weight, price);
    }
}
