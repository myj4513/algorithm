package level1.ternary;

public class Ternary {
    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.solution(125));
    }
}

class Solution {
    public int solution(int n){
        int answer = toDecimal(toReverseTernary(n));;
        return answer;
    }

    public String toReverseTernary(int n){
        String result = "";
        while(n>0){
            result += n%3;
            n /= 3;
        }
        return result;
    }
    public int toDecimal(String s){
        int result = 0;
        int power = 0;
        for(int i = s.length()-1;i>=0;i--){
            result += Math.pow(3,power++) * (s.charAt(i)-'0');
        }
        return result;
    }
}