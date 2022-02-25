package programmers.level2.judge1110;

import java.util.Scanner;

public class Main {
    static boolean solved = false;
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        int[] bridge = new int[n];
        String[] str = scanner.nextLine().split(" ");
        for(int i=0;i<n;i++){
            bridge[i] = Integer.parseInt(str[i]);
        }

        bfs(bridge, 0);
        if(solved) System.out.println("Yes");
        else System.out.println("No");
    }

    public static void bfs(int[] bridge, int pos){
//        System.out.println("bridge.length, pos, <>" + bridge.length + "," + pos + ","+(pos>=bridge.length));
        if(pos>=bridge.length || solved){
            solved = true;
            return;
        }

        for(int i=bridge[pos];i>=1;i--){
//            System.out.println("i = " + i);
//            System.out.println("pos = " + pos);
            bfs(bridge, pos+i);
            if(solved) return;
        }
        return;
    }
}
