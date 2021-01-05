//给定一个字符串 s 和一个字符串 t ，计算在 s 的子序列中 t 出现的个数。
//
// 字符串的一个 子序列 是指，通过删除一些（也可以不删除）字符且不干扰剩余字符相对位置所组成的新字符串。（例如，"ACE" 是 "ABCDE" 的一个子序列
//，而 "AEC" 不是）
//
// 题目数据保证答案符合 32 位带符号整数范围。
//
//
//
// 示例 1：
//
//
//输入：s = "rabbbit", t = "rabbit"
//输出：3
//解释：
//如下图所示, 有 3 种可以从 s 中得到 "rabbit" 的方案。
//(上箭头符号 ^ 表示选取的字母)
//rabbbit
//^^^^ ^^
//rabbbit
//^^ ^^^^
//rabbbit
//^^^ ^^^
//
//
// 示例 2：
//
//
//输入：s = "babgbag", t = "bag"
//输出：5
//解释：
//如下图所示, 有 5 种可以从 s 中得到 "bag" 的方案。
//(上箭头符号 ^ 表示选取的字母)
//babgbag
//^^ ^
//babgbag
//^^    ^
//babgbag
//^    ^^
//babgbag
//  ^  ^^
//babgbag
//    ^^^
//
//
//
// 提示：
//
//
// 0 <= s.length, t.length <= 1000
// s 和 t 由英文字母组成
//
// Related Topics 字符串 动态规划
// 👍 290 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class 不同的子序列 {
//  https://leetcode-cn.com/problems/distinct-subsequences/solution/dong-tai-gui-hua-shou-dong-mo-ni-dong-tai-zhuan-yi/
//  dp状态定义:dp[i][j]代表字符串S的前j个字符所构成的子序列中包含字符串T的前i个字符的情况个数
//  base:因为空字符是任意字符串的子序列；    dp[i][0] = 1;
//  状态转移方程:
//  取S[i]，那么当前情况总数，应该和字符串S的前i-1个字符所构成的子序列中出现字符串T的前j-1个字符的情况总数相等（图中黄色框）。
//  不取S[i],那么当前情况总数，应该和字符串S的前i个字符所构成的子序列中出现字符串T的前j个字符的情况总数相等（图中蓝色框）。
//  那么dp[i][j]应等于这两种情况的和。
//
//  如果 S[i] != T[j]，那么只有一种情况，和S[i] == T[j]的第二种情况是一样的，因为当前不相等，也就不能取（图中蓝色框）。
//
//  s(i) == t(j) dp[i][j] = dp[i - 1][j -1]+ dp[i - 1][j];
//  s(i) != t(j) dp[i][j] =  dp[i - 1][j];
  public int numDistinct(String s, String t) {
    int m = s.length(), n = t.length();
    int[][] dp = new int[m + 1][n + 1];
//    dp数组的第一行都为1，因为空字符是任意字符串的子序列；
    for (int i = 0; i < m; i++) {
      dp[i][0] = 1;
    }
    for (int i = 1; i <= m; i++) {
      for (int j = 1; j <= n; j++) {
        if (s.charAt(i - 1) == t.charAt(j - 1)) {
          dp[i][j] = dp[i - 1][j - 1] + dp[i - 1][j];
        } else {
          dp[i][j] = dp[i - 1][j];
        }
      }
    }
    return dp[m][n];
  }
}
//leetcode submit region end(Prohibit modification and deletion)

