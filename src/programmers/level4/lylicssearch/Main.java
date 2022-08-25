package programmers.level4.lylicssearch;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * 프로그래머스 레벨 4 - 가사 검색
 */

public class Main {
    public static void main(String[] args) {
        int[] result = new Solution().solution(new String[]{"frodo", "front", "frost", "frozen", "frame", "kakao"},
                new String[]{"fro??", "????o", "fr???", "fro???", "pro?"});
        System.out.println(Arrays.toString(result));
    }
}

class Solution {
    public int[] solution(String[] words, String[] queries) {
        Map<Integer, Trie> trieMap = new HashMap<>();
        Map<Integer, Trie> reverseTrieMap = new HashMap<>();
        for (int i = 1; i <= 10000; i++) {
            trieMap.put(i, new Trie());
            reverseTrieMap.put(i, new Trie());
        }
        for (int i = 0; i < words.length; i++) {
            int len = words[i].length();
            String word = words[i];
            Trie trie = trieMap.get(len);
            Trie reverseTrie = reverseTrieMap.get(len);
            for (int j = 0; j < word.length(); j++) {
                trie = trie.addChild(word.charAt(j));
                reverseTrie = reverseTrie.addChild(word.charAt(word.length() - 1 - j));
            }
        }

        int[] answer = new int[queries.length];
        for (int i = 0; i < answer.length; i++) {
            String query = queries[i];
            int count = 0;
            Trie trie = null;
            if (query.charAt(0) == '?') {
                trie = reverseTrieMap.get(query.length());
                query = new StringBuilder(query).reverse().toString();
            } else {
                trie = trieMap.get(query.length());
            }
            for (int j = 0; j < query.length(); j++) {
                char c = query.charAt(j);
                if (c == '?') {
                    count = trie.getCount();
                    break;
                } else {
                    if (!trie.hasChild(c)) {
                        break;
                    }
                    trie = trie.getChild(c);
                }
            }
            answer[i] = count;
        }

        return answer;
    }

    class Trie {
        private Trie[] child = new Trie[26];
        private int count = 0;


        public Trie addChild(char c) {
            if (child[c - 'a'] == null) {
                child[c - 'a'] = new Trie();
            }
            count++;
            return child[c - 'a'];
        }

        public boolean hasChild(char c) {
            return child[c - 'a'] != null;
        }

        public Trie getChild(char c) {
            return child[c - 'a'];
        }

        public int getCount() {
            return count;
        }
    }
}
