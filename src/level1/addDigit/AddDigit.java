package level1.addDigit;

public class AddDigit {
    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.solution(1234));
    }
}

class Solution {
    public int solution(int n) {
        int answer = 0;
        String s = String.valueOf(n);
        for(int i=0;i<s.length();i++){
            char c = s.charAt(i);
            answer += c-'0';
        }


        return answer;
    }
}