package programmers.level2.truckCrossingBridge;

import java.util.*;

public class TruckCrossingBridge {
    public static void main(String[] args) {
        Solution s = new Solution();
        int answer = s.solution(2, 10, new int[]{5,5,5,5,5,5,5,5,5,5,});
        System.out.println(answer);
    }
}

class Solution {
    public int solution(int bridge_length, int weight, int[] truck_weights) {
        Queue<Integer> waiting = new LinkedList<>();
        for(int i=0;i<truck_weights.length;i++){
            waiting.add(truck_weights[i]);
        }

        LinkedList<Truck> onBridge = new LinkedList<>();
        int second = 1;
        while(!waiting.isEmpty()){
            int totalWeight = 0;
            for(int i=0;i<onBridge.size();i++){  //이동
                onBridge.set(i, new Truck(onBridge.get(i).weight,onBridge.get(i).time+1));
            }
            for(int i=0;i<onBridge.size();i++){
                if(onBridge.get(i).time>bridge_length) {  //도착
                    onBridge.remove(i);
                }
            }

            for(int i=0;i<onBridge.size();i++){
                totalWeight += onBridge.get(i).weight;
            }
            if(totalWeight+waiting.peek()<=weight){   //트럭 추가
                onBridge.add(new Truck(waiting.poll(),1));
            }

            second++;
        }
        return second+bridge_length-1;
    }

    class Truck{
        int weight;
        int time;

        public Truck(int weight, int time) {
            this.weight = weight;
            this.time = time;
        }
    }
}

