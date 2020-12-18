import java.util.ArrayList;
import java.util.HashMap;
//给定一个字符串数组，将字母异位词组合在一起。字母异位词指字母相同，但排列不同的字符串。
//
// 示例:
//
// 输入: ["eat", "tea", "tan", "ate", "nat", "bat"]
//输出:
//[
//  ["ate","eat","tea"],
//  ["nat","tan"],
//  ["bat"]
//]
//
// 说明：
//
//
// 所有输入均为小写字母。
// 不考虑答案输出的顺序。
//
// Related Topics 哈希表 字符串
// 👍 608 👎 0


import java.util.ArrayList;
    import java.util.HashMap;

//leetcode submit region begin(Prohibit modification and deletion)
class 字母异位词分组 {
  public List<List<String>> groupAnagrams(String[] strs) {
    HashMap<String, List<String>> dic = new HashMap();
    for (int i = 0; i < strs.length; i++) {
      String cur = strs[i];
      char[] arr = new char[26];
      for (char c : cur.toCharArray()) {
        arr[c - 'a']++;
      }
      String key = new String(arr);
      if (!dic.containsKey(key)) {
        dic.put(key, new ArrayList<>());
      }
      dic.get(key).add(cur);

    }
    return new ArrayList(dic.values());
  }
}
//leetcode submit region end(Prohibit modification and deletion)

