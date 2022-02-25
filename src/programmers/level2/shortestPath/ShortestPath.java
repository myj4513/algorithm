package programmers.level2.shortestPath;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class ShortestPath {
    public static void main(String[] args) {
        Solution s = new Solution();
        int result = s.solution(new int[][]{{1,0,1,1,1},{1,0,1,0,1},{1,0,1,1,1},{1,1,1,0,1},{0,0,0,0,1}});
        System.out.println(result);
    }
}

class Solution {
    int[][] maps, dist;
    int n;
    int m;
    public int solution(int[][] maps) {
        this.maps=maps;
        n = maps.length;
        m = maps[0].length;

        dist = new int[n][m];
        for(int i=0;i<n;i++){
            Arrays.fill(dist[i], -1);
        }

        bfs();

        return dist[n-1][m-1];
    }

    public void bfs(){
        int[] dy = {1,-1,0,0};
        int[] dx = {0,0,1,-1};

        Queue<Position> queue = new LinkedList<>();
        queue.add(new Position(0,0));
        dist[0][0]=1;
        while(!queue.isEmpty()){
            Position p = queue.poll();
            for(int d=0;d<4;d++){
                Position nextP = new Position(p.x+dx[d], p.y+dy[d]);
                if(0<=nextP.x && nextP.x<n && 0<=nextP.y && nextP.y<m){
                    if(dist[nextP.x][nextP.y]==-1 && maps[nextP.x][nextP.y]==1){
                        dist[nextP.x][nextP.y]=dist[p.x][p.y]+1;
                        queue.add(nextP);
                    }
                }
            }
        }
    }

    class Position{
        int x;
        int y;

        Position(int x, int y){
            this.x = x;
            this.y = y;
        }
    }
}
