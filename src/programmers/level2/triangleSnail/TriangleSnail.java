package programmers.level2.triangleSnail;

import java.util.Arrays;

public class TriangleSnail {
    public static void main(String[] args) {
        Solution s = new Solution();
        int[] result = s.solution(5);
        System.out.println(Arrays.toString(result));
    }
}

class Solution {
    public int[] solution(int n) {
        int[][] arr = new int[n][n];
        int x=-1;
        int y=0;
        int num=1;
        for(int i=0;i<n;i++){
            for(int j=i;j<n;j++){
                if(i%3==0){
                    x++;
                }
                else if(i%3==1){
                    y++;
                }
                else if(i%3==2){
                    x--;
                    y--;
                }
                arr[x][y]=num++;
            }
        }
        int[] answer = new int[(1+n)*n/2];
        int cnt=0;
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                if(arr[i][j]==0) break;
                answer[cnt++] = arr[i][j];
            }
        }
        return answer;
    }
}