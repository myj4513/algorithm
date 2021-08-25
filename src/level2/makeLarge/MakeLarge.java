package level2.makeLarge;

import java.util.Arrays;

public class MakeLarge {
    public static void main(String[] args) {
        Solution s = new Solution();
        String result = s.solution("4177252841", 4);
        System.out.println(result);
    }
}

class Solution {
    public String solution(String number, int k) {
        StringBuilder sb = new StringBuilder(number);
        int deleteIdx;
        for(int i=0;i<k;i++){
            deleteIdx = sb.length()-1;
            for(int j=0;j<number.length();j++){
                if(sb.charAt(j)<sb.charAt(j+1)){
                    deleteIdx=j;
                    break;
                }
            }
            sb.deleteCharAt(deleteIdx);
        }
        return sb.toString();
    }

}