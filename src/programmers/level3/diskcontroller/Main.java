package programmers.level3.diskcontroller;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * 프로그래머스 레벨 3 - 디스크 컨트롤러
 */

public class Main {
    public static void main(String[] args) {
        System.out.println(new Solution().solution(new int[][]{ {1, 9}, {2, 6},{0, 3}}));
    }
}

class Solution {
    public int solution(int[][] jobs) {
        PriorityQueue<int[]> waitingQueue = new PriorityQueue(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0] - o2[0];
            }
        });
        PriorityQueue<int[]> runningQueue = new PriorityQueue(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[1] - o2[1];
            }
        });
        for (int i = 0; i < jobs.length; i++) {
            waitingQueue.add(jobs[i]);
        }
        int time = 0;
        int sum = 0;
        int count = 0;
        while (count != jobs.length) {
            while (!waitingQueue.isEmpty() && time >= waitingQueue.peek()[0]) {
                runningQueue.add(waitingQueue.poll());
            }
            if (runningQueue.isEmpty()) {
                time++;
                continue;
            }
            int[] poll = runningQueue.poll();
            sum += time - poll[0] + poll[1];
            time += poll[1];
            count++;
        }
        return sum/ jobs.length;
    }
}
