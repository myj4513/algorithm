package programmers.level2.menuRenewal;

import java.util.*;

public class MenuRenewal {
    public static void main(String[] args) {
        Solution s = new Solution();
        String[] result = s.solution(new String[]{"XYZ", "XWY", "WXA"}, new int[]{2,3,4});
        System.out.println(Arrays.toString(result));
    }
}

class Solution {
    Map<String,Integer> map = new HashMap<>();
    public String[] solution(String[] orders, int[] course) {
        for(int i=0;i<orders.length;i++){
            String[] order = orders[i].split("");
            Arrays.sort(order, Comparator.naturalOrder());
            for(int j=0;j<course.length;j++){
                combination(order, "", 0, order.length, course[j]);
            }
        }

        System.out.println(map);

        List<String> list = new ArrayList<>();
        for(int i=0;i<course.length;i++){
            int max = 0;
            for(String s : map.keySet()){
                if(s.length()==course[i]){
                    if(map.get(s)>max) max = map.get(s);
                }
            }
            for(String s : map.keySet()){
                if(max>=2 && s.length() == course[i] && map.get(s)==max)
                    list.add(s);
            }
        }
        list.sort(Comparator.naturalOrder());
        return list.toArray(new String[list.size()]);
    }

    public void combination(String[] arr, String s, int start, int n, int r){
        if(r==0){
            if(map.containsKey(s)){
                map.put(s, map.get(s)+1);
            } else
                map.put(s, 1);
            return;
        }

        if(start==n)
            return;

        combination(arr, s, start+1,n,r);
        combination(arr, s+arr[start], start+1,n,r-1);

    }
}