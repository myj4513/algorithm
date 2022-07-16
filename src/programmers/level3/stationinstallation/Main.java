package programmers.level3.stationinstallation;

/**
 * 프로그래머스 레벨 3 기지국 설치
 */

public class Main {
    public static void main(String[] args) {
        System.out.println(new Solution().solution(11, new int[]{4, 11}, 1));
    }
}

class Solution {
    public int solution(int n, int[] stations, int w) {
        int answer = 0;

        int cur = 1;
        int next;
        for (int i = 0; i < stations.length; i++) {
            next = stations[i] - w - 1;
            if (next >= cur)
                answer += (next - cur + 1) % (2 * w + 1) == 0 ? (next - cur + 1) / (2 * w + 1) : (next - cur + 1) / (2 * w + 1) + 1;
            cur = stations[i] + w + 1;
        }
        next = n;
        if (next >= cur)
            answer += (next - cur + 1) % (2 * w + 1) == 0 ? (next - cur + 1) / (2 * w + 1) : (next - cur + 1) / (2 * w + 1) + 1;

        return answer;
    }
}
