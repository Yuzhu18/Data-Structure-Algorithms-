public class Solution {
  // 左大段 + 右小段 相当于把一个连续的分成几个一组，这个和切绳子一样，只不过切绳子是一个单位为一组
  // 这个题因为是单词，所以不能单个单词一组
  // dp思想是由小问题来解决大问题
  // dp[i] represents if the string from 0 to index i, can be split into words

  public boolean canBreak(String input, String[] dict) {
    Set<String> dictionary = new HashSet<>();
    for (String s: dict) {
      dictionary.add(s);
    }
    boolean[] dp = new boolean[input.length()];
    // base case:
    dp[0] = dictionary.contains(input.substring(0, 1));
    for (int i = 1; i < input.length(); i++) {
      if (dictionary.contains(input.substring(0, i + 1))) {
        dp[i] = true;
        continue; // 继续下一个循环
      }
      // where to split
      for (int j = 0; j < i; j++) {
        if (dp[j] && dictionary.contains(input.substring(j + 1, i + 1))) {
          dp[i] = true;
          break; // 跳出循环
        }
      }
    }
    return dp[input.length() - 1];
  }
}
