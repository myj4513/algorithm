package programmers.level2.judgecodingtestB;

import java.util.Scanner;

public class Main {
    static int result = Integer.MAX_VALUE;
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int N = Integer.parseInt(scanner.nextLine());

        int[][] map = new int[N][N];

        for(int i=0;i<N;i++){
            String[] s = scanner.nextLine().split(" ");
            for(int j=0;j<N;j++){
                map[i][j] = Integer.parseInt(s[j]);
            }
        }
        boolean[][] visited = new boolean[N][N];
        dfs(map, 0, 0, visited, 0);
        if(result == Integer.MAX_VALUE) System.out.println(-1);
        else System.out.println(2+(result-2)*3);
    }
    static void dfs(int[][] map, int x, int y, boolean[][] visited, int depth) {
        if(x < 0 || x >= map.length || y < 0 || y >= map.length || visited[x][y] || map[x][y] == 0) {
            return;
        }
        if(x == map.length-1 && y == map.length-1) {
            if(depth<result){
                result = depth;
            }
            return;
        }
        visited[x][y] = true;
        dfs(map, x+1, y, visited, depth+1);
        dfs(map, x, y+1, visited, depth+1);
        dfs(map, x, y-1, visited, depth+1);
        dfs(map, x-1, y, visited, depth+1);
    }
}
