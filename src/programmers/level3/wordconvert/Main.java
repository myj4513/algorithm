package programmers.level3.wordconvert;

/**
 * 프로그래머스 레벨 3 - 단어 변환
 */

import java.util.*;

public class Main {
    public static void main(String[] args) {
        System.out.println(new Solution().solution("hit", "cog", new String[]{"hot", "dot", "dog", "lot", "log", "cog"}));
    }
}

class Solution {
    public int solution(String begin, String target, String[] words) {
        Map<String, List<String>> graph = new HashMap<>();
        for (int i = 0; i < words.length; i++) {
            graph.put(words[i], new ArrayList<>());
        }

        for (String str : graph.keySet()) {
            for (int i = 0; i < words.length; i++) {
                String word = words[i];
                int diffCnt = 0;
                for (int j = 0; j < word.length(); j++) {
                    if (str.charAt(j) != word.charAt(j)) diffCnt++;
                }
                if (diffCnt == 1) graph.get(str).add(word);
            }
        }
        if (!graph.containsKey(target)) return 0;
        int result = bfs(graph, begin, target, words);
        return result == Integer.MAX_VALUE ? 0 : result;
    }

    private int bfs(Map<String, List<String>> graph, String begin, String target, String[] words) {
        int[] count = new int[words.length];
        Arrays.fill(count, Integer.MAX_VALUE);
        Queue<Word> queue = new LinkedList<>();
        for (int i = 0; i < words.length; i++) {
            String word = words[i];
            int diffCnt = 0;
            for (int j = 0; j < word.length(); j++) {
                if (begin.charAt(j) != word.charAt(j)) diffCnt++;
            }
            if (diffCnt == 1) queue.add(new Word(1, word));
        }

        while (!queue.isEmpty()) {
            Word poll = queue.poll();
            int idx = getIdx(poll.word, words);
            if (poll.cnt < count[idx]) {
                count[idx] = poll.cnt;
                List<String> strings = graph.get(poll.word);
                for (int i = 0; i < strings.size(); i++) {
                    queue.add(new Word(poll.cnt+1, strings.get(i)));
                }
            }
        }
        int idx = getIdx(target, words);
        return count[idx];
    }

    private int getIdx(String word, String[] words) {
        for (int i = 0; i < words.length; i++) {
            if (words[i].equals(word)) {
                return i;
            }
        }
        return -1;
    }

    class Word{
        int cnt;
        String word;

        public Word(int cnt, String word) {
            this.cnt = cnt;
            this.word = word;
        }
    }
}
