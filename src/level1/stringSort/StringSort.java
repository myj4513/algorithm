package level1.stringSort;

import java.util.Arrays;
import java.util.Comparator;

public class StringSort {
    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(Arrays.toString(s.solution(new String[]{"aaa","cca","bab"}, 2)));
    }
}

class Solution{
    public String[] solution(String[] strings, int n){
        Arrays.sort(strings,new MyComparator(n));
        return strings;

    }
}

class MyComparator implements Comparator<String>{
    int i;
    MyComparator(int n){
        i=n;
    }
    @Override
    public int compare(String s1, String s2) {
        if(s1.charAt(i)==s2.charAt(i))
            return s1.compareTo(s2);
        return s1.charAt(i)-s2.charAt(i);
    }
}