//给定一个字符串，找到它的第一个不重复的字符，并返回它的索引。如果不存在，则返回 -1。
//
//
//
// 示例：
//
// s = "leetcode"
//返回 0
//
//s = "loveleetcode"
//返回 2
//
//
//
//
// 提示：你可以假定该字符串只包含小写字母。
// Related Topics 哈希表 字符串
// 👍 341 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class 字符串中的唯一字符 {
  //方法1
  public int firstUniqChar(String s) {
    HashMap<Character, Integer> count = new HashMap<Character, Integer>();
    int n = s.length();
    // build hash map : character and how often it appears
    for (int i = 0; i < n; i++) {
      char c = s.charAt(i);
      count.put(c, count.getOrDefault(c, 0) + 1);
    }

    // find the index
    for (int i = 0; i < n; i++) {
      if (count.get(s.charAt(i)) == 1)
        return i;
    }
    return -1;
  }
  //方法2hash
  public int firstUniqChar(String s) {
    char[] arr = s.toCharArray();
    int[] dic = new int[26];
    for (int i = 0; i < arr.length; i++) {
      dic[arr[i] - 'a']++;
    }
    for (int i = 0; i < arr.length; i++) {
      if (dic[arr[i] - 'a'] == 1) return i;
    }
    return -1;
  }
}
//leetcode submit region end(Prohibit modification and deletion)

