

//给定一个包含大写字母和小写字母的字符串，找到通过这些字母构造成的最长的回文串。
//
// 在构造过程中，请注意区分大小写。比如 "Aa" 不能当做一个回文字符串。
//
// 注意:
//假设字符串的长度不会超过 1010。
//
// 示例 1:
//
//
//输入:
//"abccccdd"
//
//输出:
//7
//
//解释:
//我们可以构造的最长的回文串是"dccaccd", 它的长度是 7。
//
// Related Topics 哈希表
// 👍 284 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
 public class 最长回文串{
  public int longestPalindrome(String s) {
    int[] cnts = new int[256];
    for (char c : s.toCharArray()) {
      cnts[c]++;
    }
    int palindrome = 0;
    for (int cnt : cnts) {
      palindrome += (cnt / 2) * 2;
    }
    if (palindrome < s.length()) {
      palindrome++;   // 这个条件下 s 中一定有单个未使用的字符存在，可以把这个字符放到回文的最中间
    }
    return palindrome;
  }
}
//leetcode submit region end(Prohibit modification and deletion)

