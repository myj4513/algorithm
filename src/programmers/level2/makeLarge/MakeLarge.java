package programmers.level2.makeLarge;

public class MakeLarge {
    public static void main(String[] args) {
        Solution s = new Solution();
        String result = s.solution("1231234", 3);
        System.out.println(result);
    }
}

class Solution{
    public String solution(String number, int k){
        int length = number.length() - k+1;
        int startIdx = 0;
        StringBuilder sb = new StringBuilder();

        for(int i=0;i<number.length()-k;i++){
            int max = -1;
            for(int j=startIdx;j<=length;j++){
                if(number.charAt(j)-'0'>max){
                    max = number.charAt(j)-'0';
                    startIdx = j;
                }
            }
            sb.append(number.charAt(startIdx));
            startIdx++;
            length++;
        }
        return sb.toString();
    }
}

/*      10번케이스 시간초과
class Solution {
    public String solution(String number, int k) {
        StringBuilder sb = new StringBuilder(number);
        int deleteIdx;
        for(int i=0;i<k;i++){
            deleteIdx = sb.length()-1;
            for(int j=0;j<sb.length()-1;j++){
                if(sb.charAt(j)<sb.charAt(j+1)){
                    deleteIdx=j;
                    break;
                }
            }
            sb.deleteCharAt(deleteIdx);
        }
        return sb.toString();
    }

}*/


