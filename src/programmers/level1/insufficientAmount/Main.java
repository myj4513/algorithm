package programmers.level1.insufficientAmount;

/**
 * 프로그래머스 레벨 1 부족한금액계산하기
 */
public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.solution(3,20,4));
    }
}

class Solution {
    public long solution(int price, int money, int count) {
        long cost = 0;
        for (int i = 1; i <= count; i++) {
            cost += price * i;
        }
        return cost > money ? cost - money : 0;
    }
}