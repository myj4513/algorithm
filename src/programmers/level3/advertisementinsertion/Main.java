package programmers.level3.advertisementinsertion;

/**
 * 프로그래머스 레벨 3 - 광고 삽입
 */

import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) {
        System.out.println(new Solution().solution("02:03:55", "00:14:15",
                new String[]{"01:20:15-01:45:14", "00:40:31-01:00:00", "00:25:50-00:48:29", "01:30:59-01:53:29", "01:37:44-02:02:30"}));
//        System.out.println(new Solution().solution("00:01:00", "00:00:04", new String[]{"00:00:02-00:00:04","00:00:03-00:00:05"}));
    }
}

class Solution {
    public String solution(String play_time, String adv_time, String[] logs) {
        int playTimeInSec = getTimeInSec(play_time);
        int advTimeInSec = getTimeInSec(adv_time);
        PriorityQueue<int[]> waitingQueue = new PriorityQueue<>((o1, o2) -> {
            if (o1[0] == o2[0]) {
                return o1[1] - o2[1];
            }
            return o1[0] - o2[0];
        });
        for (String log : logs) {
            String[] split = log.split("-");
            waitingQueue.add(new int[]{getTimeInSec(split[0]), getTimeInSec(split[1])});
        }
        int start = -advTimeInSec;
        long max = 0;
        long curValue = 0;
        PriorityQueue<int[]> watchingQueue = new PriorityQueue<>((o1, o2) -> {
            if (o1[0] == o2[0]) {
                return o1[1] - o2[1];
            }
            return o1[0] - o2[0];
        });
        PriorityQueue<Integer> addQueue = new PriorityQueue<>();
        PriorityQueue<Integer> removeQueue = new PriorityQueue<>();
        for (int i = 0; i <= playTimeInSec; i++) {
            int startTimeInSec = i-advTimeInSec;
            while(!waitingQueue.isEmpty() && waitingQueue.peek()[0] < i) {
                int[] poll = waitingQueue.poll();
                watchingQueue.add(poll);
                addQueue.add(poll[1]);
            }
            while (!addQueue.isEmpty() && i > addQueue.peek()) {
                addQueue.poll();
            }

            curValue += addQueue.size();
            curValue -= removeQueue.size();
            if (curValue > max) {
                start = startTimeInSec;
                max = curValue;
            }
            while(!watchingQueue.isEmpty() && startTimeInSec >= watchingQueue.peek()[0]){
                removeQueue.add(watchingQueue.poll()[1]);
            }

            while (!removeQueue.isEmpty() && startTimeInSec >= removeQueue.peek()) {
                removeQueue.poll();
            }
        }

        if(start<=0)
            return "00:00:00";
        return getTimeInString(start);
    }

    private int getTimeInSec(String string) {
        StringTokenizer st = new StringTokenizer(string, ":");
        int timeInSec = 0;
        timeInSec += Integer.parseInt(st.nextToken()) * 60 * 60;
        timeInSec += Integer.parseInt(st.nextToken()) * 60;
        timeInSec += Integer.parseInt(st.nextToken());
        return timeInSec;
    }

    private String getTimeInString(int sec) {
        StringBuilder sb = new StringBuilder();
        sb.append(String.format("%02d",sec/(60*60))).append(':');
        sec %= 60*60;
        sb.append(String.format("%02d",sec/60)).append(':');
        sec %= 60;
        sb.append(String.format("%02d",sec));
        return sb.toString();
    }
}