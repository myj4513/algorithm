package programmers.level2.thatsong;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.solution("A#", new String[]{"12:00,12:01,HELLO,A#","12:00,12:02,HELLO3,A#"}));
    }
}

class Solution {
    public String solution(String m, String[] musicinfos) {
        List<Music> musicList = new ArrayList<>();
        m = replace(m);
        for (int i = 0; i < musicinfos.length; i++) {
            musicList.add(new Music(musicinfos[i]));
        }
        List<Music> candidates = new ArrayList<>();
        for (Music music : musicList) {
            if(music.matches(m)) candidates.add(music);
        }

        candidates.sort((o1, o2) -> o2.length - o1.length);

        if(candidates.isEmpty()) return "(None)";
        return candidates.get(0).name;
    }

    String replace(String s){
        s = s.replaceAll("A#", "Z");
        s = s.replaceAll("C#", "Y");
        s = s.replaceAll("D#", "X");
        s = s.replaceAll("F#", "W");
        s = s.replaceAll("G#", "V");
        return s;
    }

    class Music{
        String name;
        int length;
        String notes = "";

        boolean matches(String m){
            return notes.contains(m);
        }

        public Music(String musicInfo) {
            StringTokenizer st = new StringTokenizer(musicInfo, ",");
            String time = st.nextToken() + ":" + st.nextToken();
            String[] timeArr = time.split(":");
            this.length = (Integer.parseInt(timeArr[2]) - Integer.parseInt(timeArr[0]))* 60 + Integer.parseInt(timeArr[3]) - Integer.parseInt(timeArr[1]);
            this.name = st.nextToken();
            String fullNotes = st.nextToken();
            fullNotes = replace(fullNotes);

            int quotient = length / fullNotes.length();
            int remainder = length % fullNotes.length();
            for (int i = 0; i < quotient; i++) {
                this.notes += fullNotes;
            }
            this.notes += fullNotes.substring(0, remainder);
        }
    }
}
