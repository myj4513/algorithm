package level2.jadencasestring;

import java.util.Arrays;

public class JadenCaseString {
    public static void main(String[] args) {
        Solution s = new Solution();
        String answer = s.solution("3people followed me");
        System.out.println("answer = " + answer);
    }
}

//class Solution {
//    public String solution(String s) {
//        String answer = "";
//        String[] strArr = s.split(" ");
//        System.out.println(Arrays.toString(strArr));
//        for(int i=0;i<strArr.length;i++){
//            strArr[i] = strArr[i].toLowerCase();
//            if(Character.isAlphabetic(strArr[i].charAt(0))){
//                strArr[i] = Character.toUpperCase(strArr[i].charAt(0))+strArr[i].substring(1);
//            }
//        }
//
//        for(String str : strArr) {
//            if(str.length()==0){
//                answer += " ";
//            }
//            else answer += str;
//        }
//        return answer;
//    }
//}

class Solution {
    public String solution(String s) {
        int idx = 0;
        s = s.toLowerCase();
        char[] chars = s.toCharArray();
        for(int i=0;i<chars.length;i++){
            if(chars[i]==' '){
                idx=0;
                continue;
            }
            if(idx==0 && Character.isAlphabetic(chars[i])) {
                chars[i] = Character.toUpperCase(chars[i]);
            }
            idx++;
        }

        return new String(chars);
    }
}