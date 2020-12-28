//给定一个字符串，验证它是否是回文串，只考虑字母和数字字符，可以忽略字母的大小写。
//
// 说明：本题中，我们将空字符串定义为有效的回文串。
//
// 示例 1:
//
// 输入: "A man, a plan, a canal: Panama"
//输出: true
//
//
// 示例 2:
//
// 输入: "race a car"
//输出: false
//
// Related Topics 双指针 字符串
// 👍 307 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class 验证回文串 {
  public boolean isPalindrome(String s) {
    for (int i = 0, j = s.length() - 1; i < j; i++, j--) {
      while (j > i && !isLetter(s.charAt(i))) i++;
      while (j > i && !isLetter(s.charAt(j))) j--;
      if (Character.toLowerCase(s.charAt(i)) != Character.toLowerCase(s.charAt(j))) return false;
    }
    return true;
  }

  boolean isLetter(char c) {
    if ((c >= '0' && c <= '9') || (c >= 'a' && c <= 'z') || (c >= 'A' && c <= 'Z'))
      return true;
    return false;
  }
}
//leetcode submit region end(Prohibit modification and deletion)


