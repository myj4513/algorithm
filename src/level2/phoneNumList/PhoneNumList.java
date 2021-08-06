package level2.phoneNumList;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;

public class PhoneNumList {
    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.solution(new String[]{"123","456", "789"}));
    }
}

class Solution {
    public boolean solution(String[] phone_book) {
        HashSet<String> set = new HashSet<>();
        Arrays.stream(phone_book).forEach(s->set.add(s));
        for(String s : set){
            for(int i=1;i<s.length();i++){
                if(set.contains(s.substring(0,i)))
                    return false;
            }
        }
        return true;
    }
}