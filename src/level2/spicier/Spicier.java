package level2.spicier;

import java.util.PriorityQueue;

public class Spicier {
    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.solution(new int[]{1, 0}, 1));
    }
}

class Solution {
    public int solution(int[] scoville, int K) {
        int answer = 0;

        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for(int i=0;i< scoville.length;i++){
            pq.add(scoville[i]);
        }
        while(pq.peek()<K){
            if(pq.size()==1) return -1;
            int first = pq.poll();
            int second = pq.poll();
            answer++;
            pq.add(first+(second*2));
        }

        return answer;
    }
}