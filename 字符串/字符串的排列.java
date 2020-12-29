import java.util.HashMap;

//给定两个字符串 s1 和 s2，写一个函数来判断 s2 是否包含 s1 的排列。
//
// 换句话说，第一个字符串的排列之一是第二个字符串的子串。
//
// 示例1:
//
//
//输入: s1 = "ab" s2 = "eidbaooo"
//输出: True
//解释: s2 包含 s1 的排列之一 ("ba").
//
//
//
//
// 示例2:
//
//
//输入: s1= "ab" s2 = "eidboaoo"
//输出: False
//
//
//
//
// 注意：
//
//
// 输入的字符串只包含小写字母
// 两个字符串的长度都在 [1, 10,000] 之间
//
// Related Topics 双指针 Sliding Window
// 👍 214 👎 0

//leetcode submit region begin(Prohibit modification and deletion)
class 字符串的排列 {
  public boolean checkInclusion(String s1, String s2) {
    HashMap<Character, Integer> need = new HashMap<>(), window = new HashMap<>();
    for (char c : s1.toCharArray()) {
      need.put(c, need.getOrDefault(c, 0) + 1);
    }
    int left = 0, right = 0, valid = 0;
    while(right < s2.length()) {
      char c = s2.charAt(right);
      //更新window状态
      if (need.containsKey(c)) {
        window.put(c, window.getOrDefault(c, 0) + 1);
        if (window.get(c).equals(need.get(c))) {
          valid++;
        }
      }
      right++;
      while (valid == need.size()) {
        if (right - left == s1.length()) {
          return true;
        }
        char d = s2.charAt(left);
        if (need.containsKey(d)) {
          if (window.get(d).equals(need.get(d))) {
            valid--;
          }
          window.put(d, window.get(d) - 1);

        }
        left++;
      }

    }
    return false;
  }
}
//leetcode submit region end(Prohibit modification and deletion)

