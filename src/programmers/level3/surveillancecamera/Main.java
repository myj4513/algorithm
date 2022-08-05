package programmers.level3.surveillancecamera;

/**
 * 프로그래머스 레벨 3 - 단속 카메라
 */

import java.util.PriorityQueue;

public class Main {
    public static void main(String[] args) {
        System.out.println(new Solution().solution(new int[][]{{-20, -15}, {-14, -5}, {-18, -13}, {-5, -3}, {-18, -14}, {-18, -12}}));
    }
}

class Solution {
    public int solution(int[][] routes) {
        PriorityQueue<int[]> pq = new PriorityQueue<>((o1, o2) -> {
            if (o1[0] == o2[0]) {
                return o1[1] - o2[1];
            }
            return o1[0] - o2[0];
        });

        for (int i = 0; i < routes.length; i++) {
            pq.add(routes[i]);
        }

        int answer = 0;
        while (!pq.isEmpty()) {
            int[] poll = pq.poll();
            int camPos = poll[1];
            answer++;
            while (!pq.isEmpty() && pq.peek()[0] <= camPos) {
                camPos = Math.min(pq.poll()[1], camPos);
            }
        }

        return answer;
    }
}
