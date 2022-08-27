package programmers.level4.autocomplete;

/**
 * 프로그래머스 레벨 4 - 자동 완성
 */

public class Main {
    public static void main(String[] args) {
        System.out.println(new Solution().solution(new String[]{"word","war","warrior","world"}));
    }
}

class Solution {

    class Trie{
        private Trie[] child = new Trie['z'-'a'+1];
        private int count = 0;

        private Trie addChild(char c) {
            if (child[c - 'a'] == null) {
                child[c-'a'] = new Trie();
            }
            child[c-'a'].count++;
            return child[c-'a'];
        }

        private int getCount() {
            return this.count;
        }

        private Trie find(char c) {
            return child[c-'a'];
        }
    }

    public int solution(String[] words) {
        Trie root = new Trie();
        for (int i = 0; i < words.length; i++) {
            String word = words[i];
            Trie temp = root;
            for (int j = 0; j < word.length(); j++) {
                char c = word.charAt(j);
                temp = temp.addChild(c);
            }
        }

        int answer = 0;
        for (int i = 0; i < words.length; i++) {
            String word = words[i];
            Trie temp = root;
            for (int j = 0; j < word.length(); j++) {
                char c = word.charAt(j);
                temp = temp.find(c);
                answer++;
                if (temp.getCount() == 1) {
                    break;
                }
            }
        }

        return answer;
    }
}
