package level2.stockprice;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class StockPrice {
    public static void main(String[] args) {
        Solution s = new Solution();
        int[] answer = s.solution(new int[]{1,2,3,2,3});
        System.out.println("answer = " + Arrays.toString(answer));
    }
}

class Solution {
    public int[] solution(int[] prices) {
        int[] answer = new int[prices.length];
        Queue<Stock> q = new LinkedList<>();

        for(int i=0;i<prices.length;i++){
            Stock stock = new Stock(i, prices[i]);
            int size = q.size();
            for(int j=0;j<size;j++){
                Stock s = q.poll();
                s.addMtnLength();
                if(s.price <= prices[i]){ //가격이 떨어지지 않았으면
                    q.add(s);
                }else{
                    answer[s.idx] = s.mtnLength;
                }
            }

            q.add(stock);
        }
        int size = q.size();
        for(int i=0;i<size;i++){
            Stock s = q.poll();
            answer[s.idx] = s.mtnLength;
        }
        return answer;
    }

    class Stock{
        int idx;
        int mtnLength =0;
        int price;

        public void addMtnLength(){
            mtnLength++;
        }

        public Stock(int idx, int price) {
            this.idx = idx;
            this.price = price;
        }
    }
}