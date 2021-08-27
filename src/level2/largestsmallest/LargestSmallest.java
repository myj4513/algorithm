package level2.largestsmallest;

import java.util.Arrays;

public class LargestSmallest {
    public static void main(String[] args) {
        Solution s = new Solution();
        String answer = s.solution("1 2 3 4");
        System.out.println(answer);
    }
}

class Solution {
    public String solution(String s) {
        String[] strArr = s.split(" ");
        int[] intArr = new int[strArr.length];
        for(int i=0;i<strArr.length;i++){
            intArr[i] = Integer.parseInt(strArr[i]);
        }
        Arrays.sort(intArr);
        System.out.println(Arrays.toString(intArr));
        return intArr[0] + " "+intArr[intArr.length-1];
    }
}
