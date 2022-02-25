package programmers.level2.openChatting;

import java.util.*;

public class OpenChatting {
    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(Arrays.toString(s.solution(new String[]{"Enter uid1234 Muzi", "Enter uid4567 Prodo","Leave uid1234","Enter uid1234 Prodo","Change uid4567 Ryan"})));
    }
}

class Solution {
    public String[] solution(String[] record) {
        String[][] records = new String[record.length][3];
        for(int i=0;i<record.length;i++){
            records[i] = record[i].split(" ");
        }
        Map<String, String> map = new HashMap<String, String>();
        for(int i=0;i<record.length;i++){
            if(records[i][0].equals("Enter")){
                map.put(records[i][1], records[i][2]);
            }
            else if(records[i][0].equals("Change")){
                map.put(records[i][1], records[i][2]);
            }
        }

        List<String> list = new ArrayList<>();
        for(int i=0;i<record.length;i++){
            if(records[i][0].equals("Enter")){
                list.add(String.format("%s님이 들어왔습니다.", map.get(records[i][1])));
            }
            else if(records[i][0].equals("Leave")){
                list.add(String.format("%s님이 나갔습니다.", map.get(records[i][1])));
            }
        }
        String[] answer = list.toArray(new String[list.size()]);
        return answer;
    }
}