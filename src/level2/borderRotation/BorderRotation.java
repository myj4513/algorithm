package level2.borderRotation;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Set;

public class BorderRotation {
    public static void main(String[] args) {
        Solution s = new Solution();
        int[] answer = s.solution(6,6,new int[][]{{2,2,5,4},{3,3,6,6}, {5,1,6,3}});
        System.out.println(Arrays.toString(answer));
    }
}

class Solution {
    public int[] solution(int rows, int columns, int[][] queries) {
        int[][] map = new int[rows][columns];
        int cnt = 0;
        for(int i=0;i<rows;i++){
            for(int j=0;j<columns;j++){
                map[i][j] = ++cnt;
            }
        }

        int[] answer = new int[queries.length];
        for(int i=0;i< queries.length;i++){
            answer[i] = rotateBorder(queries[i][0], queries[i][1], queries[i][2], queries[i][3], map);
        }

        return answer;
    }

    public int rotateBorder(int a, int b, int c, int d, int[][] map){
        Set<Integer> set = new HashSet<>();
        int x1 = a-1;
        int y1 = b-1;
        int x2 = c-1;
        int y2 = d-1;
        int lt = map[x1+1][y1];
        int rt = map[x1][y2-1];
        int ld = map[x2][y1+1];
        int rd = map[x2-1][y2];

        for(int i=x1+1;i<x2;i++){  //좌변
            map[i][y1] = map[i+1][y1];
            set.add(map[i][y1]);
        }
        for(int i=y2-1;i>y1;i--){  //상변
            map[x1][i] = map[x1][i-1];
            set.add(map[x1][i]);
        }
        for(int i=x2-1;i>x1;i--){  //우변
            map[i][y2] = map[i-1][y2];
            set.add(map[i][y2]);
        }

        for(int i=y1+1;i<y2;i++){  //하변
            map[x2][i] = map[x2][i+1];
            set.add(map[x2][i]);
        }
        set.add(lt);
        set.add(rt);
        set.add(ld);
        set.add(rd);
        map[x1][y1] = lt;
        map[x1][y2] = rt;
        map[x2][y1] = ld;
        map[x2][y2] = rd;
        return set.stream().min(Comparator.naturalOrder()).get();
    }
}