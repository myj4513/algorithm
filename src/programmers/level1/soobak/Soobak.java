package programmers.level1.soobak;

public class Soobak {
    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.solution(3));
    }
}

class Solution{
    public String solution(int n){
        String answer = "";
        for(int i=0;i<n;i++){
            if(i%2==0)
                answer+="수";
            else
                answer+="박";
        }
        return answer;
    }
}