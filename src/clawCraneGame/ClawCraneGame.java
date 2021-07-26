package clawCraneGame;

import java.util.ArrayList;
import java.util.List;

public class ClawCraneGame {
    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.solution(new int[][]{{0,0,0,0,0},{0,0,1,0,3},{0,2,5,0,1},{4,2,4,4,2},{3,5,1,3,1}}, new int[]{1,5,3,5,1,2,1,4}));
    }
}

class Solution{
    public int solution(int[][] board, int[] moves){
        List<Integer> basket = getBasket(board, moves);
        return getScore(basket);
    }

    public List<Integer> getBasket(int[][] board, int[] moves){
        List<Integer> basket = new ArrayList<>();
        for(int move : moves){
            for(int i=0;i<board.length;i++){
                if(board[i][move-1]!=0){
                    basket.add(board[i][move-1]);
                    board[i][move-1] = 0;
                    break;
                }
            }
        }
        return basket;
    }

    public int getScore(List<Integer> basket){
        int count = 0;
        boolean run = true;
        while(run){
            run = false;
            for(int i=0;i<basket.size()-1;i++){
                if(basket.get(i)==basket.get(i+1)){
                    run = true;
                    basket.remove(i);
                    basket.remove(i);
                    count+=2;
                }
            }
        }
        return count;
    }
}