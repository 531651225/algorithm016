//给定一个只包含 '(' 和 ')' 的字符串，找出最长的包含有效括号的子串的长度。
//
// 示例 1:
//
// 输入: "(()"
//输出: 2
//解释: 最长有效括号子串为 "()"
//
//
// 示例 2:
//
// 输入: ")()())"
//输出: 4
//解释: 最长有效括号子串为 "()()"
// Related Topics 字符串 动态规划
// 👍 1027 👎 0
//leetcode submit region begin(Prohibit modification and deletion)
class 最长有效括号 {

  //时间复杂度o(n)
//空间复杂度o(n)
  public int longestValidParentheses(String s) {
    if (s == null || s.length() < 2) {
      return 0;
    }
    int[] dp = new int[s.length()];
    int max = 0;

    for (int i = 1; i < s.length(); i++) {
      if (s.charAt(i) == ')') {
        //右括号前边是左括号
        if (s.charAt(i - 1) == '(') {
          dp[i] = (i >= 2) ? dp[i - 2] + 2 : 2;
          //右括号前边是右括号，并且除去前边的合法序列的前边是左括号
        } else if (i - dp[i - 1] - 1 >= 0
            && s.charAt(i - dp[i - 1] - 1) == '(') {
          dp[i] = dp[i - 1] + 2 + ((i - dp[i - 1] - 2) >= 0 ? dp[i - dp[i - 1] - 2] : 0);
        }
        max = Math.max(max, dp[i]);
      }

    }
    return max;
  }
}
//leetcode submit region end(Prohibit modification and deletion)

