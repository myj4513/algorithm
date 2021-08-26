package level2.englishwordchain;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class EnglishWordChain {
    public static void main(String[] args) {
        Solution s = new Solution();
        int[] answer = s.solution(2, new String[]{"hello", "one", "even", "never", "now", "world", "draw"});
        System.out.println(Arrays.toString(answer));
    }
}

class Solution {
    public int[] solution(int n, String[] words) {
        int[] answer = {};
        String prev = words[0];
        Set set = new HashSet();
        set.add(prev);

        for(int i=1;i<words.length;i++){
            if(set.contains(words[i]) || prev.charAt(prev.length()-1)!=words[i].charAt(0)){
                return new int[]{(i+1)%n==0?n:(i+1)%n,(int)Math.ceil((i+1.0)/n)};
            }else{
                set.add(words[i]);
                prev=words[i];
            }
        }

        return new int[]{0,0};
    }
}