package level2.judgecodingtestI;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        for(int i=0;i<n;i++){
            String[] s = scanner.nextLine().split(" ");
            List<Integer> list = new ArrayList<>();

            int idx = s[0].indexOf(s[1]);
            int prevIdx = 0;
            if(idx==-1) {
                System.out.println(0);
                continue;
            }
            while(idx!=-1){
                list.add(prevIdx + idx+1);
                s[0] = s[0].substring(idx+1);
                prevIdx += idx+1;
                idx = s[0].indexOf(s[1]);
            }
            System.out.println(list.size());
            for (Integer integer : list) {
                System.out.print(integer+" ");
            }
            System.out.println();
        }
    }
}
