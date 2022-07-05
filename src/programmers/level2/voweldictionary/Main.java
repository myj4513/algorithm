package programmers.level2.voweldictionary;

public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.solution("EIO"));
    }
}

class Solution {
    private int[] inc = new int[]{781, 156, 31, 6, 1};
    String vowels = "AEIOU";
    public int solution(String word) {
        int answer = word.length();
        for (int i = 0; i < word.length(); i++) {
            answer += inc[i] * vowels.indexOf(word.charAt(i));
        }
        return answer;
    }
}