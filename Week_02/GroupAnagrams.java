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
// 👍 470 👎 0


import com.sun.org.apache.bcel.internal.generic.AALOAD;
import java.util.Arrays;
import java.util.HashMap;

//leetcode submit region begin(Prohibit modification and deletion)
class GroupAnagrams {

  //时间复杂度：O(NKlogK)其中 N 是 strs 的长度，而 K 是 strs 中字符串的最大长度。当我们遍历每个字符串时，外部循环具有的复杂度为 O(N)。然后，我们在 O(KlogK) 的时间内对每个字符串排序。
  //空间复杂度：O(NK)，排序存储在 dic 中的全部信息内容。
//  public List<List<String>> groupAnagrams(String[] strs) {
//    List<List<String>> res = new ArrayList();
//    if (strs == null || strs.length ==0) {
//      return res;
//    }
//
//    HashMap<String, List<String>> dic = new HashMap();
//    for (String str : strs) {
//      char[] arr = str.toCharArray();
//      Arrays.sort(arr);
//      String newStr = new String(arr);
//        System.out.println(newStr);
//
//      if (!dic.containsKey(newStr)) {
//        dic.put(newStr, new ArrayList());
//      }
//      dic.get(newStr).add(str);
//    }
//
//    for (List<String> value : dic.values()) {
//      res.add(value);
//    }
//    return res;
//  }

  //时间复杂度：O(NK)，其中 N 是 strs 的长度，而 K 是 strs 中字符串的最大长度。计算每个字符串的字符串大小是线性的，我们统计每个字符串。
  //空间复杂度：O(NK)，排序存储在 ans 中的全部信息内容。
  public List<List<String>> groupAnagrams(String[] strs) {
    List<List<String>> res = new ArrayList();
    HashMap<String, List<String>> dic = new HashMap();
    for (String str : strs) {
      char[] arr = new char[26];
      for (char c : str.toCharArray()) {
        arr[c - 'a']++;
      }
      String newStr = new String(arr);
      if (!dic.containsKey(newStr)) {
        dic.put(newStr, new ArrayList());
      }
      dic.get(newStr).add(str);
    }

    for (List<String> value : dic.values()) {
      res.add(value);
    }
    return res;

  }
}
//leetcode submit region end(Prohibit modification and deletion)
