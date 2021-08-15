package level2.makeLarge;

public class MakeLarge {
    public static void main(String[] args) {
        Solution s = new Solution();
        String result = s.solution("4177252841", 4);
        System.out.println(result);
    }
}

class Solution {
    public String solution(String number, int k) {
        String answer = "";
        boolean[] check = new boolean[number.length()];
        for(int i=0;i<number.length()-1;i++){
            if(!check[i]){
                for(int j=i+1;j<number.length();j++){
                    if(!check[j]){
                        if(number.charAt(i)<number.charAt(j)){
                            check[i] = true;
                            if(i>0)
                                i-=2;
                            else
                                i--;
                            k--;
                        }
                        break;
                    }
                }
            }
            if(k==0) break;
        }

        for(int i=0;i<number.length();i++){
            if(!check[i])
                answer += number.charAt(i);
        }
        if(k>0){
            answer = answer.substring(0,answer.length()-k);
        }
        return answer;
    }
}