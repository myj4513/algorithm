package programmers.longestpalindrome;

/**
 * 프로그래머스 레벨 3 - 가장 긴 팰린드롬
 */

public class Main {
    public static void main(String[] args) {
        System.out.println(new Solution().solution("abcdcbb"));
    }
}

class Solution {
    private String s;
    public int solution(String s) {
        this.s = s;
        for (int i = s.length(); i >= 0; i--) {
            for (int j = 0; j <= s.length() - i; j++) {
                if (isPalindrome(j, j+i-1)) return i;
            }
        }

        return 0;
    }

    private boolean isPalindrome(int start, int end) {
        while (start < end) {
            if (s.charAt(start) != s.charAt(end)) return false;
            start++;
            end--;
        }
        return true;
    }
}
