//给定一个非空字符串 s，最多删除一个字符。判断是否能成为回文字符串。
//
// 示例 1:
//
//
//输入: "aba"
//输出: True
//
//
// 示例 2:
//
//
//输入: "abca"
//输出: True
//解释: 你可以删除c字符。
//
//
// 注意:
//
//
// 字符串只包含从 a-z 的小写字母。字符串的最大长度是50000。
//
// Related Topics 字符串
// 👍 303 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class 验证回文字符串2 {
  public boolean validPalindrome(String s) {
    for (int i = 0, j = s.length() - 1; j > i; i++, j--) {
      if (s.charAt(i) != s.charAt(j)) {
        return validPalindrome(s, i + 1, j) ||
            validPalindrome(s, i, j - 1);
      }
    }
    return true;
  }

  public boolean validPalindrome(String s, int start, int end) {
    for ( ; start < end; start++, end--) {
      if (s.charAt(start) != s.charAt(end)) return false;
    }
    return true;
  }
}
//leetcode submit region end(Prohibit modification and deletion)

