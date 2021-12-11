package baekjoon.p7662;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;
        int T = Integer.parseInt(br.readLine());
        while(T-->0){
            PriorityQueue<Integer> pq = new PriorityQueue<>();
            int K = Integer.parseInt(br.readLine());
            for(int i=0;i<K;i++){
                st = new StringTokenizer(br.readLine());
                if(st.nextToken().equals("I")){
                    pq.add(Integer.parseInt(st.nextToken()));
                }
                else if(st.nextToken().equals("D") && !pq.isEmpty()){
                    System.out.println("hi");
                    if(st.nextToken().equals("1")){
                        pq.remove(pq.size()-1);
                    }
                    else{
                        pq.remove();
                    }
                }
            }
            System.out.println(pq);
            if(pq.size()==0){
                System.out.println("EMPTY");
            } else if(pq.size()==2){
                System.out.println(pq.toArray()[0] + " " + pq.toArray()[pq.size()-1]);

            }
        }

    }
}
