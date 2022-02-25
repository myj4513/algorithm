package programmers.level2.nextLargestNum;

public class NextLargestNum {
    public static void main(String[] args) {
        Solution s = new Solution();
        int answer = s.solution(15);
        System.out.println("answer = " + answer);
    }
}


class Solution {
    public int solution(int n) {
        String s = Integer.toString(n, 2);
        int lastIdx1 = s.lastIndexOf("1");
        int count=0;
        for(int i=lastIdx1-1;i>=0;i--){
            if(s.charAt(i)=='1'){
                count++;
            }
            else{
                StringBuilder sb = new StringBuilder();
                sb.append(s, 0, i);
                sb.append("1");
                int length = s.length()-sb.length();
                for(int j=0;j<length;j++){
                    if(s.length()-sb.length()>count){
                        sb.append(0);
                    }
                    else{
                        sb.append(1);
                    }
                }
                return Integer.parseInt(sb.toString(), 2);
            }
        }
        StringBuilder sb = new StringBuilder();
        for(int j=0;j<s.length()-1;j++){
            if(s.length()-1-sb.length()>count){
                sb.append(0);
            }
            else{
                sb.append(1);
            }
        }
        sb.insert(0, "10");
        return Integer.parseInt(sb.toString(), 2);
    }
}


/*
class Solution
{
    public int nextBigNumber(int n)
    {
        int a = Integer.bitCount(n);
        int compare = n+1;

        while(true) {
            if(Integer.bitCount(compare)==a)
                break;
            compare++;
        }

        return compare;
    }
}*/
