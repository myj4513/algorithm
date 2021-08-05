package level2.keepingDistance;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class KeepingDistance {
    public static void main(String[] args) {
        Solution s = new Solution();
        int[] answer = s.solution(new String[][]{{"0P00P", "00000", "00000", "00000", "00000"}});
        System.out.println(Arrays.toString(answer));
    }
}

class Solution {
    public int[] solution(String[][] places) {
        String[][][] map = new String[places.length][places[0].length][places[0][0].length()];
        for(int i=0;i<places.length;i++){
            for(int j=0;j<places[i].length;j++){
                String[] s = places[i][j].split("");
                map[i][j] = s;
            }
        }

        for(int i=0;i<5;i++){
            System.out.println(Arrays.toString(map[0][i]));
        }

        int[] answer = new int[5];
        for(int i=0;i<map.length;i++){
            int min = Integer.MAX_VALUE;
            for(int j=0;j<5;j++){
                for(int k=0;k<5;k++){
                    if(map[i][j][k].equals("P")){
                        int distance = getMinDistance(j,k,map[i]);
                        if(distance<min)
                            min = distance;
                    }
                }
            }
            answer[i] = min>2?1:0;
        }


        return answer;
    }

    public int getMinDistance(int x, int y, String[][] place){
        Queue<Location> q = new LinkedList<>();
        q.add(new Location(x,y,0));
        boolean[][] visited = new boolean[5][5];
        visited[x][y] = true;
        while(!q.isEmpty()){
            Location l = q.poll();
            int xx = l.x;
            int yy = l.y;
            int cnt = l.cnt;
            if(!visited[xx][yy] && place[xx][yy].equals("P")){
                return cnt;
            }
            visited[xx][yy] = true;
            if(xx-1>=0 && !visited[xx-1][yy] && isOnPath(place[xx-1][yy])){ //상
                q.add(new Location(xx-1, yy, cnt+1));
            }
            if(xx+1<5 && !visited[xx+1][yy] && isOnPath(place[xx+1][yy])){ //하
                q.add(new Location(xx+1, yy, cnt+1));
            }
            if(yy-1>=0 && !visited[xx][yy-1] && isOnPath(place[xx][yy-1])){ //좌
                q.add(new Location(xx, yy-1, cnt+1));
            }
            if(yy+1<5 && !visited[xx][yy+1] && isOnPath(place[xx][yy+1])){ //우
                q.add(new Location(xx, yy+1, cnt+1));
            }
        }
        return 100;
    }

    public boolean isOnPath(String s){
        return s.equals("0") || s.equals("P");
    }

    class Location{
        int x;
        int y;
        int cnt;

        public Location(int x, int y, int cnt) {
            this.x = x;
            this.y = y;
            this.cnt = cnt;
        }

        public String toString(){
            return "["+x+","+y+","+cnt+"]";
        }
    }
}