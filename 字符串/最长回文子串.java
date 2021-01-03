

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
// 👍 3056 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class 最长回文子串 {
  public String longestPalindrome(String s) {
    int m = s.length(), lo = 0, max = 1;
    boolean[][] dp = new boolean[m][m];
    for (int i = 0; i < m; i++) {
      dp[i][i] = true;
    }
    for (int i = m - 1; i >= 0; i--) {
      for (int j = i + 1; j < m; j++) {
        if(s.charAt(i) == s.charAt(j)) {
          if(j - 1 - (i + 1) + 1 < 2) {
            dp[i][j] = true;
          } else {
            dp[i][j] = dp[i + 1][j - 1];
          }
        }

        if (dp[i][j] && j - i + 1 > max) {
          lo = i;
          max = j - i + 1;
        }
      }
    }
    return s.substring(lo, lo + max);

  }
}
//leetcode submit region end(Prohibit modification and deletion)

