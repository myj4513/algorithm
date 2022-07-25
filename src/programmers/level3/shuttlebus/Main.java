package programmers.level3.shuttlebus;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class Main {
    public static void main(String[] args) {
        System.out.println(new Solution().solution(2, 10, 2, new String[]{"09:10", "09:09", "08:00"}));
    }
}

class Solution {
    public String solution(int n, int t, int m, String[] timetable) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int i = 0; i < timetable.length; i++) {
            String[] split = timetable[i].split(":");
            pq.add(Integer.parseInt(split[0]) * 60 + Integer.parseInt(split[1]));
        }
        int last = -1;
        for (int i = 0; i < n; i++) {
            int time = 540 + i * t;
            int cnt = 0;
            while (!pq.isEmpty() && pq.peek() <= time && cnt < m) {
                cnt++;
                last = pq.poll();
            }
            if (i == n - 1) {
                if (cnt == m) {
                    return String.format("%02d:%02d",(last -1)/60, (last-1)%60);
                }
                else
                    return String.format("%02d:%02d", time/60, time%60);
            }
        }
        return "error";
    }
}
