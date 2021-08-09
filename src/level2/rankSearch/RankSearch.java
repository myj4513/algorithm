package level2.rankSearch;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class RankSearch {
    public static void main(String[] args) {
        Solution s = new Solution();
        int[] result = s.solution(new String[]{"java backend junior pizza 150","python frontend senior chicken 210","python frontend senior chicken 150","cpp backend senior pizza 260","java backend junior chicken 80","python backend senior chicken 50"},
                new String[]{"- and - and - and - 100"});
        System.out.println(Arrays.toString(result));
    }
}

class Solution {
    List<ArrayList<String>> list = new ArrayList<>();
    String[][] q = new String[][]{{"java", "python", "cpp", "-"},
            {"frontend", "backend", "-"},
            {"junior", "senior", "-"},
            {"pizza", "chicken", "-"}};
    public int[] solution(String[] info, String[] query) {
        comb(0, q.length, new ArrayList<String>());
        System.out.println(list);
        return new int[]{};
    }

    public void comb(int index, int maxIndex, ArrayList<String> tmp){
        if(index>=maxIndex){
            list.add(new ArrayList<>(tmp));
            return;
        }
        for(int i=0;i<q[index].length;i++){
            tmp.add(q[index][i]);
            comb(index + 1, maxIndex, tmp);
            tmp.remove(q[index][i]);
        }
    }
}