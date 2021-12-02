package baekjoon.p2346;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int N = scanner.nextInt();

        StringBuilder sb = new StringBuilder();

        ArrayList<int[]> dl = new ArrayList<>();
        for(int i=0;i<N;i++){
            dl.add(new int[]{i+1, scanner.nextInt()});
        }

        while (true) {
            int[] poll = dl.remove(0);
            sb.append(poll[0]);
            sb.append(" ");
            if(dl.isEmpty())
                break;
            if(poll[1]>0){
                for(int j=0;j<poll[1]-1;j++){
                    dl.add(dl.remove(0));
                }
            }
            else{
                for(int j=0;j<-poll[1];j++){
                    dl.add(0,dl.remove(dl.size()-1));
                }
            }
        }
        System.out.println(sb);
    }
}

/*public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int N = scanner.nextInt();

        String result = "";

        LinkedList<int[]> dl = new LinkedList<>();
        for(int i=0;i<N;i++){
            dl.addLast(new int[]{i+1, scanner.nextInt()});
        }

        while (true) {
            int[] poll = dl.pollFirst();
            result += poll[0]+" ";
            if(dl.isEmpty())
                break;
            if(poll[1]>0){
                for(int j=0;j<poll[1]-1;j++){
                    dl.addLast(dl.pollFirst());
                }
            }
            else{
                for(int j=0;j<-poll[1];j++){
                    dl.addFirst(dl.pollLast());
                }
            }
        }
        System.out.println(result);
    }
}*/
