package programmers.level1.evenOdd;

public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.solution(3));
    }
}

class Solution {
    public String solution(int num) {
        if(num%2==0) return "Even";
        return "Odd";
    }
}
