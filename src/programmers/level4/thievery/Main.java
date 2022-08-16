package programmers.level4.thievery;

/**
 * 프로그래머스 레벨 4 - 도둑질
 */

public class Main {
    public static void main(String[] args) {
        System.out.println(new Solution().solution(new int[]{1,2,3,1}));
    }
}

class Solution {
    public int solution(int[] money) {
        int size = money.length;
        int[] dp1 = new int[size]; //첫집 포함 뒤에서 두번째와 세번째 비교
        int[] dp2 = new int[size]; //첫집 제외 뒤에서 첫번째와 두번째 비교

        dp1[0] = money[0];
        dp1[1] = money[1];
        dp1[2] = money[2] + dp1[0];
        for(int i=3;i<size;i++){
            dp1[i] = Math.max(dp1[i-2], dp1[i-3]) + money[i];
        }
        dp2[1] = money[1];
        dp2[2] = money[2];
        for(int i=3;i<size;i++){
            dp2[i] = Math.max(dp2[i-2], dp2[i-3]) + money[i];
        }
        return Math.max(Math.max(Math.max(dp2[size-1], dp2[size-2]),dp1[size-2]),dp1[size-3]);
    }
}
