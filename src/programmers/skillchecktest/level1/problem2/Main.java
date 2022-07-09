package programmers.skillchecktest.level1.problem2;

public class Main {
    public static void main(String[] args) {
        System.out.println(new Solution().solution("4444"));
    }
}

class Solution {
    public String solution(String phone_number) {
        int len = phone_number.length();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < len - 4; i++) {
            sb.append('*');
        }
        sb.append(phone_number.substring(len - 4));
        return sb.toString();
    }
}