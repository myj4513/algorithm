package programmers.level4.emptyroomassignment;

import java.util.*;

/**
 * 프로그래머스 레벨 4 - 호텔 방 배정
 */

public class Main {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(new Solution().solution(10, new long[]{1,3,4,1,3,1})));
    }
}

class Solution {
    private Map<Long, Long> parent;
    public long[] solution(long k, long[] room_number) {
        parent = new HashMap<>();

        long[] answer = new long[room_number.length];

        for (int i = 0; i < room_number.length; i++) {
            answer[i] = find(room_number[i]);
        }

        return answer;
    }

    long find(long target) {
        if (!parent.containsKey(target)) {
            parent.put(target, target+1);
            return target;
        }

        if (parent.get(target) != target) {
            parent.put(target, find(parent.get(target)));
        } else {
            parent.put(target, target+1);
        }
        return parent.get(target);
    }
}
