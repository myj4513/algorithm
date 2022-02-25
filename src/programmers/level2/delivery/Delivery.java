package programmers.level2.delivery;

import java.util.Arrays;

public class Delivery {
    public static void main(String[] args) {
        Solution s = new Solution();
        s.solution(6,new int[][]{{1,2,1},{1,3,2},{2,3,2},{3,4,3},{3,5,2},{3,5,3},{5,6,1}},4);
    }
}

class Solution {
    public int solution(int N, int[][] road, int K) {
        int answer = 0;
        int[][] roads = new int[N+1][N+1];
        for(int i=0;i<road.length;i++){
            if(roads[road[i][0]][road[i][1]]==0)
                roads[road[i][0]][road[i][1]] = road[i][2];
            else
                if(road[i][2]<roads[road[i][0]][road[i][1]])
                    roads[road[i][0]][road[i][1]] = road[i][2];
            if(roads[road[i][1]][road[i][0]]==0)
                roads[road[i][1]][road[i][0]] = road[i][2];
            else
                if(roads[road[i][1]][road[i][0]] > road[i][2])
                    roads[road[i][1]][road[i][0]] = road[i][2];
        }
        for(int i=0;i<roads.length;i++){
            for(int j=0;j<roads[i].length;j++){
                if(roads[i][j]==0)
                    roads[i][j] = 100000000;
            }
        }
        int[] distance = new int[N+1];
        boolean[] visited = new boolean[N+1];
        Arrays.fill(distance, Integer.MAX_VALUE-1);
        for(int i=1;i<=N;i++){
            if(roads[1][i]!=0){
                distance[i] = roads[1][i];
            }
        }
        distance[1]=0;
        visited[1] = true;
        for(int i=0;i<N-1;i++){
            int min = Integer.MAX_VALUE;
            int min_index = -1;
            for(int j=1;j<=N;j++){
                if(!visited[j]){
                    if(distance[j]<min){
                        min = distance[j];
                        min_index = j;
                    }
                }
            }
            visited[min_index] = true;
            for(int j=1;j<=N;j++){
                if(!visited[j]){
                    if(distance[j]>distance[min_index]+roads[min_index][j]){
                        distance[j] = distance[min_index]+roads[min_index][j];
                    }
                }
            }
        }
        for(int i=1;i<=N;i++){
            if(distance[i]<=K)
                answer++;
        }

        return answer;
    }
}