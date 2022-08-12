package codility.easy.firstunique;

// you can also use imports, for example:
// import java.util.*;

// you can write to stdout for debugging purposes, e.g.
// System.out.println("this is a debug message");
import java.util.*;

public class Solution {
    public int solution(int[] A) {
        Map<Integer, Integer> countMap = new LinkedHashMap<>();
        for(int i=0;i<A.length;i++){
            if(countMap.containsKey(A[i])) {
                countMap.put(A[i], countMap.get(A[i])+1);
            } else{
                countMap.put(A[i], 1);
            }
        }

        for(int key : countMap.keySet()){
            if(countMap.get(key)==1) {
                return key;
            }
        }
        return -1;
    }
}
