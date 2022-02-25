package programmers.level2.coloringBook;

import java.util.*;

public class ColoringBook {
    public static void main(String[] args) {
        Solution s = new Solution();
        int[] answer = s.solution(6, 4, new int[][]{{1,1,1,0},{1,2,2,0},{1,0,0,1},{0,0,0,1},{0,0,0,3},{0,0,0,3}});
        System.out.println(Arrays.toString(answer));
    }
}

class Solution{
    int[][] pic;
    int curCnt=0;
    int max=0;
    public int[] solution(int m, int n, int[][] picture){
        int sectionNum = 0;
        int[][] newPic = new int[m][n];
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                newPic[i][j] = picture[i][j];
            }
        }
        pic = newPic;
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(newPic[i][j]!=0){
                    sectionNum++;
                    dfs(i,j,0);
                    newPic[i][j]=0;
                    if(curCnt>max)
                        max=curCnt;
                    curCnt=0;
                }
            }
        }
        return new int[]{sectionNum, max};
    }

    public void dfs(int x, int y, int l){
        int path = pic[x][y];
        if(x+1<pic.length){
            if(pic[x+1][y]==path){  //하
                dfs(x+1,y,l+1);
                pic[x+1][y]=0;
            }
        }
        if(x-1>=pic.length){
            if(pic[x-1][y]==path){ //상
                dfs(x-1,y,l+1);
                pic[x-1][y]=0;
            }
        }
        if(y+1<pic[x].length){
            if(pic[x][y+1]==path){ //우
                dfs(x,y+1,l+1);
                pic[x][y+1]=0;
            }
        }
        if(y-1>=pic[x].length){
            if(pic[x][y-1]==path){ //좌
                dfs(x,y-1,l+1);
                pic[x][y-1]=0;
            }
        }
        curCnt++;
    }
}

