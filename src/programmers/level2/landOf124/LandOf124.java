package programmers.level2.landOf124;

public class LandOf124 {
    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.solution(10));
    }
}

class Solution{
    public String solution(int n){
        String s = Integer.toString(n,3);;
        String[] sArr = s.split("");
        int[] iArr = new int[sArr.length];
        for(int i=0;i<sArr.length;i++){
            iArr[i] = Integer.parseInt(sArr[i]);
        }
        for(int i=sArr.length-1;i>0;i--){
            if(iArr[i]<=0){
                iArr[i]+=3;
                iArr[i-1]-=1;
                if(iArr[i]==3){
                    iArr[i]++;
                }
            }
        }
        StringBuilder answer = new StringBuilder();
        for(int i=0;i<iArr.length;i++){
            if(iArr[i]!=0)
                answer.append(iArr[i]);
        }

        return answer.toString();
    }
}