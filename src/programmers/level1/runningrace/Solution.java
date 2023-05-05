package programmers.level1.runningrace;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.IntStream;

class Solution {
  public String[] solution(String[] players, String[] callings) {
    Map<String, Integer> playerMap = createPlayerMap(players);
    Arrays.stream(callings).forEach(call -> {
      int idx = playerMap.get(call);
      String prevPlayer = players[idx-1];
      players[idx-1] = call;
      players[idx] = prevPlayer;

      playerMap.put(call, idx-1);
      playerMap.put(prevPlayer, idx);
    });
    return players;
  }

  private Map<String, Integer> createPlayerMap(String[] players) {
    Map<String, Integer> playerMap = new HashMap<>();
    IntStream.range(0, players.length).forEach(i -> playerMap.put(players[i], i));
    return playerMap;
  }
}
