//一条包含字母 A-Z 的消息通过以下映射进行了 编码 ：
//
//
//'A' -> 1
//'B' -> 2
//...
//'Z' -> 26
//
//
// 要 解码 已编码的消息，所有数字必须基于上述映射的方法，反向映射回字母（可能有多种方法）。例如，"111" 可以将 "1" 中的每个 "1" 映射为 "A
//" ，从而得到 "AAA" ，或者可以将 "11" 和 "1"（分别为 "K" 和 "A" ）映射为 "KA" 。注意，"06" 不能映射为 "F" ，因为 "
//6" 和 "06" 不同。
//
// 给你一个只含数字的 非空 字符串 num ，请计算并返回 解码 方法的 总数 。
//
// 题目数据保证答案肯定是一个 32 位 的整数。
//
//
//
// 示例 1：
//
//
//输入：s = "12"
//输出：2
//解释：它可以解码为 "AB"（1 2）或者 "L"（12）。
//
//
// 示例 2：
//
//
//输入：s = "226"
//输出：3
//解释：它可以解码为 "BZ" (2 26), "VF" (22 6), 或者 "BBF" (2 2 6) 。
//
//
// 示例 3：
//
//
//输入：s = "0"
//输出：0
//解释：没有字符映射到以 0 开头的数字。含有 0 的有效映射是 'J' -> "10" 和 'T'-> "20" 。由于没有字符，因此没有有效的方法对此进行
//解码，因为所有数字都需要映射。
//
//
// 示例 4：
//
//
//输入：s = "1"
//输出：1
//
//
//
//
// 提示：
//
//
// 1 <= s.length <= 100
// s 只包含数字，并且可能包含前导零。
//
// Related Topics 字符串 动态规划
// 👍 594 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class 解码方法 {

//  多解法说的比较好
//  https://leetcode-cn.com/problems/decode-ways/solution/xiang-xi-tong-su-de-si-lu-fen-xi-duo-jie-fa-by-2-3/
//
//  dp状态定义:dp [ i ] 代表字符串 s [ i, s.len-1 ]，也就是 s 从 i 开始到结尾的字符串的解码方式
//  BASE: dp[n] = 1;   //将递归法的结束条件初始化为 1   dp[n - 1] = s.charAt(n - 1) == '0' ? 0 : 1;//最后一个数字不等于 0 就初始化为 1
//  状态转移方程:       if (ten + one <= 26) dp[i] += dp[i + 2];
//  递归 自顶而下
//解法一的递归中，走完左子树，再走右子树会把一些已经算过的结果重新算，
// 所以我们可以用 备忘录 技术，就是算出一个结果很就保存，第二次算这个的时候直接拿出来就可以了。

  public int numDecodings(String s) {
    int n = s.length();
    int[] dp = new int[n + 1];
    dp[n] = 1;
    dp[n - 1] = s.charAt(n - 1) == '0' ? 0 : 1;
    for (int i = n - 2; i >= 0; i--) {
      if (s.charAt(i) == '0') {
        dp[i] = 0;
      } else {
        int ten = (s.charAt(i) - '0') * 10;
        int one = s.charAt(i + 1) - '0';
        dp[i] = dp[i + 1];
        if (ten + one <= 26) dp[i] += dp[i + 2];
      }
    }
    return dp[0];
  }

  private int recur(String s, int start, int[] memo) {

    //划分到了最后返回 1
    if (s.length() == start) {
      return 1;
    }
    //开头是 0,0 不对应任何字母，直接返回 0
    if (s.charAt(start) == '0') {
      return 0;
    }
    if (memo[start] != -1) {
      System.out.println(start + ":" + memo[start]);
      return memo[start];
    }
    int res1 = recur(s, start + 1, memo);
    int res2 = 0;
    //只有最后一个元素,不能进行第二种情况划分
    if (start < s.length() - 1) {
      int ten = s.charAt(start) - '0';
      int one = s.charAt(start + 1) - '0';
      int num = ten * 10 + one;
      if (num <= 26) {
        res2 = recur(s, start + 2, memo);
      }
    }
    memo[start] = res1 + res2;
    return res1 + res2;

  }
}
//leetcode submit region end(Prohibit modification and deletion)

