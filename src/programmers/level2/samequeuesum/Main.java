package programmers.level2.samequeuesum;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 프로그래머스 레벨 2 - 두 큐의 합 같게 만들기
 */

public class Main {
    public static void main(String[] args) {
        System.out.println(new Solution().solution(new int[]{3, 2, 7, 2}, new int[]{4, 6, 5, 1}));
    }
}

class Solution {
    public int solution(int[] queue1, int[] queue2) {
        int answer = 0;
        long sum1 = 0;
        long sum2 = 0;
        Queue<Integer> q1 = new LinkedList<>();
        Queue<Integer> q2 = new LinkedList<>();
        for (int i = 0; i < queue1.length; i++) {
            sum1 += queue1[i];
            q1.add(queue1[i]);
        }
        for (int i = 0; i < queue2.length; i++) {
            sum2 += queue2[i];
            q2.add(queue2[i]);
        }
        while (sum1 != sum2) {
            answer++;
            if (sum1 > sum2) {
                int num = q1.poll();
                sum1 -= num;
                sum2 += num;
                q2.add(num);
            } else if (sum2 > sum1) {
                int num = q2.poll();
                sum2 -= num;
                sum1 += num;
                q1.add(num);
            }
            if (answer > queue1.length * 3 - 3) return -1;
        }
        return answer;
    }
}
