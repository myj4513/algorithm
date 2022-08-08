package programmers.level3.numbergame;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * 프로그래머스 레벨 3 - 숫자 게임
 */

public class Main {
    public static void main(String[] args) {
        System.out.println(new Solution().solution(new int[]{5,1,3,7}, new int[]{2,2,6,8}));
    }
}

class Solution {
    public int solution(int[] A, int[] B) {
        PriorityQueue<Integer> apq = new PriorityQueue<>(Comparator.reverseOrder());
        PriorityQueue<Integer> bpq = new PriorityQueue<>(Comparator.reverseOrder());
        for (int i = 0; i < A.length; i++) {
            apq.add(A[i]);
            bpq.add(B[i]);
        }
        int answer = 0;
        while(!apq.isEmpty()){
            if (apq.peek() >= bpq.peek()) {
                apq.poll();
            } else {
                answer++;
                apq.poll();
                bpq.poll();
            }
        }
        return answer;
    }
}
