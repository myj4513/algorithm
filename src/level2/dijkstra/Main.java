package level2.dijkstra;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        int INF = 1000000000;

        for(int i=0;i<n;i++){
            String[] str = scanner.nextLine().split(" ");
            int P = Integer.parseInt(str[0]); //산봉우리 수
            int Q = Integer.parseInt(str[1]); //등산로 수
            int R = Integer.parseInt(str[2]); //산장의 수
            Set<Integer> setR = new HashSet<>();  //산장 번호
            int[][] matrix = new int[P][P];  //인접행렬
            for (int[] ints : matrix) {
                Arrays.fill(ints, INF);
            }
            for(int j=0;j<P;j++){
                matrix[j][j] = 0;
            }
            for(int j=0;j<Q;j++){
                str = scanner.nextLine().split(" ");
                int from = Integer.parseInt(str[0])-1;  //시작 산봉우리
                int to = Integer.parseInt(str[1])-1;  //도착 산봉우리
                int length = Integer.parseInt(str[2]);  //거리

                matrix[from][to] = Math.min(matrix[from][to], length);
            }
            str = scanner.nextLine().split(" ");
            for(int j=0;j<R;j++){
                 setR.add(Integer.parseInt(str[j])-1);
            }

            //다익스트라 알고리즘
            int[] shortestLength = new int[P];
            for(int j=0;j<P;j++){
                shortestLength[j] = dijkstra(j,P,matrix, setR);
            }

            int max = -1;
            int maxR = -1;
            for(int r=0;r<P;r++){
                if(!setR.contains(r)){
                    if(max<shortestLength[r]){
                        max = shortestLength[r];
                        maxR = r;
                    }
                }
            }
            System.out.println(maxR+1 + " " + max);
        }
    }

    public static int dijkstra(int start, int P, int[][] matrix, Set<Integer> set){
        if(set.contains(start)) return 0;  //산장에서 출발하는 경우를 제외한다

        int[] dijk = new int[P];
        boolean[] visited = new boolean[P];

        for(int i=0;i<P;i++){
            dijk[i] = matrix[start][i];
        }

        visited[start] = true;
        for(int i=0;i<P-2;i++){
            int current = getSmallIndex(dijk, visited);
            visited[current] = true;
            for(int j=0;j<P;j++){
                if (!visited[j]) {
                    if(matrix[current][j] + dijk[current]<dijk[j]){
                        dijk[j] = matrix[current][j] + dijk[current];
                    }
                }
            }
        }

        int min = Integer.MAX_VALUE;
        for(int i=0;i<P;i++){
            if(i!=start && set.contains(i)) {
                if (dijk[i] < min) {
                    min = dijk[i];
                }
            }
        }
        return min;
    }

    public static int getSmallIndex(int[] dijk, boolean[] visited){
        int min = Integer.MAX_VALUE;
        int minIdx = 0;
        for(int i=0;i<dijk.length;i++){
            if(dijk[i]<min && !visited[i]){
                min = dijk[i];
                minIdx = i;
            }
        }
        return minIdx;
    }
}
