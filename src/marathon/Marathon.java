package marathon;
import java.util.HashMap;

public class Marathon {
    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.solution(new String[]{"mislav", "stanko", "mislav", "ana"}, new String[]{"stanko", "ana", "mislav"}));
    }
}

class Solution{
    public String solution(String[] participant, String[] completion) {
        String answer ="";
        HashMap<String, Integer> partMap = new HashMap<>();
        for(String s : participant){
            if(partMap.containsKey(s))
                partMap.put(s, partMap.get(s)+1);
            else
                partMap.put(s,1);
        }
        for(int i=0;i<completion.length;i++){
            if(partMap.containsKey(completion[i]) && partMap.get(completion[i])>0){
                partMap.put(completion[i],partMap.get(completion[i])-1);
            }
        }
        for(String s : partMap.keySet()){
            if(partMap.get(s)==1) answer = s;
        }
        return answer;
    }
}