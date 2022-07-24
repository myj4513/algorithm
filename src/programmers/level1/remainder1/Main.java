package programmers.level1.remainder1;

public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.solution(10));
    }
}

class Solution {
    public int solution(int n) {
        int i=2;
        while(true){
            if(n%i==1){
                return i;
            }
            i++;
        }
    }
}