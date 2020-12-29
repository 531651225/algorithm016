import java.util.ArrayList;
//给定一个字符串 s 和一个非空字符串 p，找到 s 中所有是 p 的字母异位词的子串，返回这些子串的起始索引。
//
// 字符串只包含小写英文字母，并且字符串 s 和 p 的长度都不超过 20100。
//
// 说明：
//
//
// 字母异位词指字母相同，但排列不同的字符串。
// 不考虑答案输出的顺序。
//
//
// 示例 1:
//
//
//输入:
//s: "cbaebabacd" p: "abc"
//
//输出:
//[0, 6]
//
//解释:
//起始索引等于 0 的子串是 "cba", 它是 "abc" 的字母异位词。
//起始索引等于 6 的子串是 "bac", 它是 "abc" 的字母异位词。
//
//
// 示例 2:
//
//
//输入:
//s: "abab" p: "ab"
//
//输出:
//[0, 1, 2]
//
//解释:
//起始索引等于 0 的子串是 "ab", 它是 "ab" 的字母异位词。
//起始索引等于 1 的子串是 "ba", 它是 "ab" 的字母异位词。
//起始索引等于 2 的子串是 "ab", 它是 "ab" 的字母异位词。
//
// Related Topics 哈希表
// 👍 437 👎 0


import java.util.ArrayList;

//leetcode submit region begin(Prohibit modification and deletion)
class 找出字符串中所有字母的异位词 {
  public List<Integer> findAnagrams(String s, String p) {
    List<Integer> res = new ArrayList<>();
    int[] need = new int[26], window = new int[26];
    int left = 0, right = 0, valad = 0;;
    for (char c : p.toCharArray()) {
      need[c - 'a']++;
    }
    int total = 0;
    for (int i = 0; i < need.length; i++) {
      if(need[i] > 0) total++;
    }
    while (right < s.length()) {
      //对窗口内元素进行更新
      char c = s.charAt(right);
      if (need[c - 'a'] > 0) {
        window[c - 'a']++;
        if (window[c - 'a'] == need[c - 'a'])
          valad++;
      }
      right++;
      //判断左侧窗口是否需要收紧
      while(valad == total) {
        if (right - left == p.length()) {
          res.add(left);
        }
        //进行窗口内数据的一系列更新
        char leftchar = s.charAt(left);
        if (need[leftchar - 'a'] > 0) {
          if(need[leftchar - 'a'] == window[leftchar - 'a'])valad--;
          window[leftchar - 'a']--;
        }
        left++;
      }
    }
    return res;

  }
}
//leetcode submit region end(Prohibit modification and deletion)

