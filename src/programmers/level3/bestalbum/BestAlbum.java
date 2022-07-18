//package programmers.level3.bestalbum;
//
//import java.util.*;
//
//
//public class BestAlbum {
//    public static void main(String[] args) {
//        Solution s = new Solution();
////        int[] answer = s.solution(new String[]{"classic", "pop", "classic", "classic", "pop"}, new int[]{500, 600, 150, 800, 2500});
//        int[] answer = s.solution(new String[]{"a", "b", "c", "d", "e"}, new int[]{500, 600, 150, 800, 2500});
//        System.out.println("answer = " + Arrays.toString(answer));
//    }
//}
//
//
//class Solution {
//    public int[] solution(String[] genres, int[] plays) {
//        List<Integer> answerList = new ArrayList<>();
//        Map<String, List<Integer>> map = new HashMap<>();
//
//        for(int i=0;i<genres.length;i++){
//            if(map.containsKey(genres[i])){
//                map.get(genres[i]).add(i);
//            }
//            else{
//                List<Integer> list = new ArrayList<>();
//                list.add(i);
//                map.put(genres[i],list);
//            }
//        }
//
//        for (String s : map.keySet()) {
//            List<Integer> list = map.get(s);
//            Collections.sort(list, new Comparator<Integer>() {
//                @Override
//                public int compare(Integer o1, Integer o2) {
//                    int result = plays[o2] - plays[o1];
//                    if(result == 0) return o1 - o2;
//                    return result;
//                }
//            });
//        }
//        int size = map.size();
//
//        for(int i=0;i<size;i++){
//            int max = -1;
//            String maxS="";
//            for (String s : map.keySet()) {
//                int total = 0;
//                List<Integer> list = map.get(s);
//                for(int j=0;j<list.size();j++){
//                    total += plays[list.get(j)];
//                }
//                if(total>max) {
//                    max = total;
//                    maxS = s;
//                }
//            }
//            List<Integer> list = map.get(maxS);
//            if(list.size()==1) answerList.add(list.get(0));
//            else{
//                answerList.add(list.get(0));
//                answerList.add(list.get(1));
//            }
//            map.remove(maxS);
//        }
//
//        int[] answer = new int[answerList.size()];
//        for(int i=0;i<answerList.size();i++){
//            answer[i] = answerList.get(i);
//        }
//
//        return answer;
//    }
//}