package level1.pAndY;

public class PAndY {
    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.solution("edbca"));
    }
}
class Solution {
    boolean solution(String s) {
        boolean answer = true;
        int cntP = 0;
        int cntY = 0;
        for(int i=0;i<s.length();i++){
            char c = s.charAt(i);
            if('P'==c || c=='p'){
                cntP++;
            }
            if('Y'==c || c=='y'){
                cntY++;
            }
        }
        if(cntP != cntY){
            return false;
        }
        return answer;
    }
}