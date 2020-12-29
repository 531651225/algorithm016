import java.util.HashMap;
import java.util.Map;
//给你一个字符串 s 、一个字符串 t 。返回 s 中涵盖 t 所有字符的最小子串。如果 s 中不存在涵盖 t 所有字符的子串，则返回空字符串 "" 。
//
// 注意：如果 s 中存在这样的子串，我们保证它是唯一的答案。
//
//
//
// 示例 1：
//
//
//输入：s = "ADOBECODEBANC", t = "ABC"
//输出："BANC"
//
//
// 示例 2：
//
//
//输入：s = "a", t = "a"
//输出："a"
//
//
//
//
// 提示：
//
//
// 1 <= s.length, t.length <= 105
// s 和 t 由英文字母组成
//
//
//
//进阶：你能设计一个在 o(n) 时间内解决此问题的算法吗？ Related Topics 哈希表 双指针 字符串 Sliding Window
// 👍 876 👎 0

//leetcode submit region begin(Prohibit modification and deletion)
class 最小覆盖子串 {
  public String minWindow(String s, String t) {
    int min = Integer.MAX_VALUE;
    Map<Character, Integer> need = new HashMap<>(), window = new HashMap<>();
    for(char c : t.toCharArray()) {
      need.put(c, need.getOrDefault(c, 0) + 1);
    }
    int left = 0, right = 0, valid = 0, start = 0;
    while(right < s.length()) {
      char c = s.charAt(right);
      if (need.containsKey(c)) {
        window.put(c, window.getOrDefault(c, 0) + 1);
        if (need.get(c).equals(window.get(c))) {
          valid++;
        }
      }
      right++;
      while(need.size() == valid) {
        if(right - left < min) {
          min = right - left;
          start = left;
        }
        char leftchar = s.charAt(left);
        if (need.containsKey(leftchar)) {
          if(window.get(leftchar).equals(need.get(leftchar))) {
            valid--;
          }
          window.put(leftchar, window.get(leftchar) - 1);
        }
        left++;
      }
    }
    return min == Integer.MAX_VALUE ? "" : s.substring(start, start + min);
  }
}
//leetcode submit region end(Prohibit modification and deletion)

