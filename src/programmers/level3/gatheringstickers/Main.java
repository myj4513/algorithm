package programmers.level3.gatheringstickers;

/**
 * 프로그래머스 레벨 3 - 스티커 모으기(2)
 */

public class Main {
    public static void main(String[] args) {
        System.out.println(new Solution().solution(new int[]{14, 6, 5, 11, 3, 9, 2, 10}));
    }
}

class Solution {
    public int solution(int sticker[]) {
        if (sticker.length == 1) return sticker[0];
        if (sticker.length == 2) return Math.max(sticker[0], sticker[1]);
        int size = sticker.length;
        int[] dpWithStart = new int[size];
        int[] dpWithoutStart = new int[size];
        dpWithStart[0] = sticker[0];
        dpWithoutStart[0] = 0;
        for (int i = 1; i < size; i++) {
            dpWithStart[i] = Math.max(i - 2 < 0 ? 0 : dpWithStart[i - 2], i - 3 < 0 ? 0 : dpWithStart[i - 3]) + sticker[i];
            dpWithoutStart[i] = Math.max(i - 2 < 0 ? 0 : dpWithoutStart[i - 2], i - 3 < 0 ? 0 : dpWithoutStart[i - 3]) + sticker[i];
        }
        return Math.max(Math.max(Math.max(dpWithoutStart[size - 1], dpWithoutStart[size - 2]), dpWithStart[size - 2]), dpWithStart[size - 3]);
    }
}