package level2.largestNumber;

import java.util.Arrays;

public class LargestNumber {
    public static void main(String[] args) {
        Solution s = new Solution();
        String result = s.solution(new int[]{151,15});
        System.out.println(result);
    }
}

class Solution {
    public String solution(int[] numbers) {
        String answer = "";
        String[] str = new String[numbers.length];
        boolean[] used = new boolean[numbers.length];
        for(int i=0;i<numbers.length;i++){
            str[i] = ""+numbers[i];
        }
        Arrays.sort(str);
        System.out.println(Arrays.toString(str));
        for(int i= str.length-1;i>=0;i--){
            if(!used[i]){
                if(str[i].length()>1){
                    for(int k=0;k<str[i].length();k++){
                        if(str[i].charAt(k)!=str[i].charAt(0)){
                            if(str[i].charAt(k)>str[i].charAt(0))
                                break;
                            else{
                                for(int j=i-1;j>=0;j--){
                                    if(str[j].length()==1 && str[j].charAt(0)==str[i].charAt(0)){
                                        used[j] = true;
                                        answer += str[j];
                                    }
                                }
                            }
                        }
                    }
                }
                used[i] = true;
                answer += str[i];
            }
        }
        return answer;
    }
}