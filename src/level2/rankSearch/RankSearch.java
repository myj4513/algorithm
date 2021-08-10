package level2.rankSearch;

import java.util.*;

public class RankSearch {
    public static void main(String[] args) {
        Solution s = new Solution();
        int[] result = s.solution(new String[]{"java backend junior pizza 150"},
                new String[]{"java and backend and junior and pizza 100","python and frontend and senior and chicken 200","cpp and - and senior and pizza 250","- and backend and senior and - 150","- and - and - and chicken 100","- and - and - and - 150"});
        System.out.println(Arrays.toString(result));
    }
}

class Solution {
    Map<String, List<Integer>> map = new HashMap<>();
    String[][] str = {{"-","java","cpp","python"}, {"-","backend","frontend"},{"-","junior","senior"},{"-","chicken","pizza"}};
    List<String> list = new ArrayList<>();
    public int[] solution(String[] info, String[] query) {
        int answer = 0;
        comb(0, 4, "");

        for(int i=0;i<list.size();i++){
            map.put(list.get(i), new ArrayList<Integer>());
        }

        for(int i=0;i< info.length;i++){
            String[] word = info[i].split(" ");
            List<String> list2 = new ArrayList<String>();
            comb2(0, 4, "", word, list2);
            for(int j=0;j<list2.size();j++){
                String s = list2.get(j);
                List<Integer> l = map.get(s);
                l.add(Integer.parseInt(word[4]));
                map.put(s, l);
            }
        }
        int[] result = new int[query.length];
        for(int i=0;i< query.length;i++){
            String[] word = query[i].split(" ");
            String s = word[0]+word[2]+word[4]+word[6];
            List<Integer> integers = map.get(s);
            integers.sort(Comparator.naturalOrder());
            int idx = Collections.binarySearch(integers, Integer.parseInt(word[7]));
            if(idx<0){
                idx = -(idx+1);
            } else{
                if(idx-1>=0){
                    while(integers.get(idx-1)== integers.get(idx)){
                        idx--;
                    }
                }
            }
            answer = integers.size() - idx;
            result[i] = answer;
        }

        return result;
    }

    public void comb2(int count, int maxCount, String s, String[] word, List<String> list2){
        if(count==maxCount){
            list2.add(s);
            return;
        }
        comb2(count+1, maxCount, s+"-", word, list2);
        comb2(count+1, maxCount, s+word[count], word, list2);
    }

    public void comb(int count, int maxCount, String s){
        if(count==maxCount){
            list.add(s);
            return;
        }
        for(int i=0;i<str[count].length;i++){
            comb(count+1, maxCount, s+str[count][i]);
        }
    }
}