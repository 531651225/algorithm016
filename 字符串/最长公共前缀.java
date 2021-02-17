

//编写一个函数来查找字符串数组中的最长公共前缀。
//
// 如果不存在公共前缀，返回空字符串 ""。
//
//
//
// 示例 1：
//
//
//输入：strs = ["flower","flow","flight"]
//输出："fl"
//
//
// 示例 2：
//
//
//输入：strs = ["dog","racecar","car"]
//输出：""
//解释：输入不存在公共前缀。
//
//
//
// 提示：
//
//
// 0 <= strs.length <= 200
// 0 <= strs[i].length <= 200
// strs[i] 仅由小写英文字母组成
//
// Related Topics 字符串
// 👍 1459 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class 最长公共前缀 {
  //编写一个函数来查找字符串数组中的最长公共前缀。
//
// 如果不存在公共前缀，返回空字符串 ""。
//
//
//
// 示例 1：
//
//
//输入：strs = ["flower","flow","flight"]
//输出："fl"
//
//
// 示例 2：
//
//
//输入：strs = ["dog","racecar","car"]
//输出：""
//解释：输入不存在公共前缀。
//
//
//
// 提示：
//
//
// 0 <= strs.length <= 200
// 0 <= strs[i].length <= 200
// strs[i] 仅由小写英文字母组成
//
// Related Topics 字符串
// 👍 1459 👎 0


  //leetcode submit region begin(Prohibit modification and deletion)
  class Solution {
//    public String longestCommonPrefix(String[] strs) {
//        if(strs.length == 0) return "";
//        String first = strs[0];
//        for (int i = 0; i < first.length(); i++) {
//            for (int j = 1; j< strs.length; j++) {
//                if(strs[j].length() == i ||
//                    strs[j].charAt(i) != first.charAt(i)) return first.substring(0, i);
//            }
//        }
//        return first;
//    }

    public String longestCommonPrefix(String[] strs) {
      if(strs.length == 0) return "";
      String prefix = strs[0];
      for (int i = 1; i < strs.length; i++) {
        prefix = longestCommonPrefix(prefix, strs[i]);
      }
      return prefix;
    }

    public String longestCommonPrefix(String str1, String str2) {
      int length = Math.min(str1.length(), str2.length());
      for (int i = 0; i < length; i++) {
        if(str1.charAt(i) != str2.charAt(i))  return str1.substring(0, i);
      }
      return str1.substring(0, length);
    }


  }
//leetcode submit region end(Prohibit modification and deletion)

}
//leetcode submit region end(Prohibit modification and deletion)

