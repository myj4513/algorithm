package baekjoon.p1966;

import java.util.LinkedList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int T = scanner.nextInt();

        while(T-- >0){
            int N = scanner.nextInt();
            int M = scanner.nextInt();

            int count = 0;

            LinkedList<int[]> queue = new LinkedList<>();
            for(int i=0;i<N;i++){
                queue.offer(new int[]{i, scanner.nextInt()});
            }
            while(true){
                int[] front = queue.poll();
                boolean isMax = true;
                for(int i=0;i<queue.size();i++){
                    if(front[1] < queue.get(i)[1]){
                        isMax = false;
                        break;
                    }
                }

                if(isMax){
                    count++;
                    if(front[0]==M) {
                        System.out.println(count);
                        break;
                    }
                }
                if(!isMax)
                    queue.offer(front);

            }
        }
    }
}
