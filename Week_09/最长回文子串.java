//给定一个字符串 s，找到 s 中最长的回文子串。你可以假设 s 的最大长度为 1000。
//
// 示例 1：
//
// 输入: "babad"
//输出: "bab"
//注意: "aba" 也是一个有效答案。
//
//
// 示例 2：
//
// 输入: "cbbd"
//输出: "bb"
//
// Related Topics 字符串 动态规划
// 👍 2901 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class 最长回文子串 {

  //中间扩散
  //时间复杂度 o(n^2)
  //空间复杂度 o(1)
  int lo = 0, maxlen = 0;
  public String longestPalindrome(String s) {
    if (s.length() < 2) {
      return s;
    }

    for (int i = 0; i < s.length() - 1; i++) {
      helper(s, i, i);
      helper(s, i, i + 1);
    }
    return s.substring(lo, lo + maxlen);
  }

  void helper(String s, int i, int j) {
    while (i >= 0 && j < s.length() && s.charAt(i) == s.charAt(j)) {
      i--;
      j++;
    }

    if (j - i - 1 > maxlen) {
      lo = i + 1;
      maxlen = j - i - 1;
    }
  }

  //动态规划
  //时间复杂度 o(n^2)
  //空间复杂度 o(n^2)
  public String longestPalindrome(String s) {
    int lo = 1, len = s.length(), maxlen = 1;
    boolean[][] dp = new boolean[len + 1][len + 1];
    for (int i = 0; i <= len; i++) {
      dp[i][i] = true;
    }
    for (int j = 1; j <= len; j++) {
      for (int i = 1; i < j; i++) {
        if (s.charAt(i - 1) == s.charAt(j - 1)) {
          if (j - i < 3) {
            dp[i][j] = true;
          } else {
            dp[i][j] = dp[i + 1][j - 1];
          }
        }
        if (dp[i][j] && j - i + 1 > maxlen) {
          lo = i;
          maxlen = j - i + 1;
        }
      }
    }
    return s.substring(lo - 1, lo - 1 + maxlen);
  }
}
//leetcode submit region end(Prohibit modification and deletion)
