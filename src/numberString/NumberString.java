package numberString;

public class NumberString {
    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.solution("one4seveneight"));
    }
}

class Solution{
    String[] num = {"zero", "one", "two","three","four", "five","six","seven","eight","nine"};
    public int solution(String s){
        for(int i=0;i<num.length;i++){
            s=s.replaceAll(num[i], Integer.toString(i));
        }

        return Integer.parseInt(s);
    }
}