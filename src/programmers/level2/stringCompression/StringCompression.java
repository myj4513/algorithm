package programmers.level2.stringCompression;

public class StringCompression {
    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.solution("aaaaaaaaaaaaaaa"));
    }
}

class Solution{
    public int solution(String s){
        int result = s.length();
        if(s.length()<2)
            return result;
        int[] arr = new int[s.length()/2];
        for(int j=1;j<=(s.length()/2);j++){
            String answer = "";
            String[] split = split(j, s);
            int cnt=1;
            String prev ="";
            for(int i=0;i<split.length;i++){
                if(split[i].equals(prev)){
                    cnt++;
                }
                else{
                    if(cnt==1)
                        answer+=prev;
                    else
                        answer+=cnt+prev;
                    cnt=1;
                    prev = split[i];
                }
            }
            if(cnt==1)
                answer+=prev;
            else
                answer+=cnt+prev;
            if(answer.length()<result)
                result = answer.length();
        }

        return result;
    }

    public String[] split(int n, String s){
        String[] result = new String[s.length()==1?1:(int)Math.ceil(s.length()/(double)n)];
        int cnt = 0;
        for(int i=0;i<s.length();i+=n){
            if(i+n+1>s.length())
                result[cnt] = s.substring(i);
            else
                result[cnt] = s.substring(i,i+n);
            cnt++;
        }
        return result;
    }
}