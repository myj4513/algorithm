package baekjoon.p20546;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int BnPCash = Integer.parseInt(br.readLine());
        int TimingCash = BnPCash;
        int BnPStock = 0;
        int TimingStock = 0;

        StringTokenizer st = new StringTokenizer(br.readLine());
        int prevStockPrice = -1;
        int stockPrice = 0;
        int rise = 0;
        int fall = 0;
        for (int i = 0; i < 14; i++) {
            stockPrice = Integer.parseInt(st.nextToken());
            if(i>0){
                if (prevStockPrice > stockPrice) {
                    fall++;
                    rise = 0;
                } else if (prevStockPrice < stockPrice) {
                    rise++;
                    fall = 0;
                }
            }

            if(fall>=3){
                while (TimingCash - stockPrice >= 0) {
                    TimingCash -= stockPrice;
                    TimingStock++;
                }
            } else if (rise >= 3) {
                TimingCash += TimingStock * stockPrice;
                TimingStock = 0;
            }

            while (BnPCash - stockPrice >= 0) {
                BnPStock++;
                BnPCash -= stockPrice;
            }


            prevStockPrice = stockPrice;
        }

        int timing = TimingCash + stockPrice * TimingStock;
        int bnp = BnPCash + stockPrice * BnPStock;
        if(timing == bnp) System.out.println("SAMESAME");
        else if(timing > bnp) System.out.println("TIMING");
        else System.out.println("BNP");
    }
}
