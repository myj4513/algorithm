package gymSuit;

import java.util.ArrayList;
import java.util.List;

public class GymSuit {
    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.solution(5, new int[]{2,3,4}, new int[]{3,4,5}));
    }
}

class Solution{
    public int solution(int n, int[] lost, int[] reserve) {
        List<Integer> lostList = new ArrayList<>();
        for(int num : lost) lostList.add(num);
        List<Integer> reserveList = new ArrayList<>();
        for(int num : reserve) reserveList.add(num);

        for(int i=0;i<lostList.size();i++){
            for(int j=0;j<reserveList.size();j++){
                if(lostList.get(i)==reserveList.get(j)){
                    lostList.set(i,0);
                    reserveList.set(j,0);
                }
            }
        }

        for(int i=0;i<reserveList.size();i++){
            if(reserveList.get(i)!= 0 && lostList.contains(reserveList.get(i)-1)){
                lostList.set(lostList.indexOf(reserveList.get(i)-1), 0);
            } else if(reserveList.get(i)!= 0 && lostList.contains(reserveList.get(i)+1)){
                lostList.set(lostList.indexOf(reserveList.get(i)+1), 0);
            }
        }

        int count = 0;
        for(int l : lostList)
            if(l!=0) count++;

        return n-count;
    }
}