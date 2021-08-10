package level2.newsClustering;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class NewsClustering {
    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.solution("FRANCE", "FRENCH"));
    }
}

class Solution {
    public int solution(String str1, String str2) {
        double similarity = 0;
        List<String> list1 = new ArrayList<>();
        List<String> list2 = new ArrayList<>();
        for(int i=0;i<str1.length()-1;i++){
            if(Character.isAlphabetic(str1.charAt(i)) && Character.isAlphabetic(str1.charAt(i+1))){
                list1.add(str1.substring(i, i+2).toUpperCase(Locale.ROOT));
            }
        }
        for(int i=0;i<str2.length()-1;i++){
            if(Character.isAlphabetic(str2.charAt(i)) && Character.isAlphabetic(str2.charAt(i+1))){
                list2.add(str2.substring(i, i+2).toUpperCase(Locale.ROOT));
            }
        }
        List<String> hab = new ArrayList<>(list1);
        List<String> kyo = new ArrayList<>();
        for(int i=0;i<list1.size();i++){
            if(list2.contains(list1.get(i))){
                kyo.add(list1.get(i));
                list2.remove(list1.get(i));
            }
        }
        for(int i=0;i<list2.size();i++){
            hab.add(list2.get(i));
        }

        if(hab.size()==0 && kyo.size()==0){
            similarity = 1;
        } else{
            similarity = (double)kyo.size()/hab.size();
        }
        return (int)(similarity * 65536);
    }
}