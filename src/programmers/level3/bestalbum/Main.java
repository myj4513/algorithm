package programmers.level3.bestalbum;

/**
 * 프로그래머스 레벨 3 - 베스트 앨범
 */

import java.util.*;

public class Main {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(new Solution()
                .solution(new String[]{
                                "classic", "pop", "classic", "classic", "pop"
                        },
                        new int[]{
                                500, 600, 150, 800, 2500
                        })));
    }
}

class Solution {
    public int[] solution(String[] genres, int[] plays) {
        List<Integer> answer = new ArrayList<>();
        Map<String, Integer> countPerGenre = new HashMap<>();
        Map<String, List<Music>> musicMap = new HashMap<>();
        for (int i = 0; i < genres.length; i++) {
            //countPerGenre 추가
            if (countPerGenre.containsKey(genres[i])) {
                countPerGenre.put(genres[i], countPerGenre.get(genres[i]) + plays[i]);
            } else {
                countPerGenre.put(genres[i], plays[i]);
            }
            //musicMap 추가
            Music music = new Music(i, plays[i]);
            if (musicMap.containsKey(genres[i])) {
                musicMap.get(genres[i]).add(music);
            } else {
                List<Music> list = new ArrayList<>();
                list.add(music);
                musicMap.put(genres[i], list);
            }
        }
        for (List<Music> list : musicMap.values()) {
            Collections.sort(list, new Comparator<Music>() {
                @Override
                public int compare(Music o1, Music o2) {
                    if (o1.count == o2.count) {
                        return o1.id - o2.id;
                    }
                    return o2.count - o1.count;
                }
            });
        }
        List<Map.Entry<String, Integer>> entries = new ArrayList<>(countPerGenre.entrySet());
        entries.sort(Map.Entry.comparingByValue(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2 - o1;
            }
        }));
        for (Map.Entry<String, Integer> entry : entries) {
            String genre = entry.getKey();
            List<Music> music = musicMap.get(genre);
            for (int i = 0; i < 2; i++) {
                if (!music.isEmpty()) {
                    answer.add(music.remove(0).id);
                }
            }
        }

        return answer.stream().mapToInt(i -> i).toArray();
    }

    class Music {
        int id;
        int count;

        public Music(int id, int count) {
            this.id = id;
            this.count = count;
        }
    }
}
