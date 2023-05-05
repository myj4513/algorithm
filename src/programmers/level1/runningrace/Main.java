package programmers.level1.runningrace;

import java.util.Arrays;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Main {
  public static void main(String[] args) {
    Solution solution = new Solution();
    String[] result = solution.solution(new String[]{"mumu", "soe", "poe", "kai", "mine"},
        new String[]{"kai", "kai", "mine", "mine"});
    log.info(Arrays.toString(result));
  }
}
