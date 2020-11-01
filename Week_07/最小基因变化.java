//一条基因序列由一个带有8个字符的字符串表示，其中每个字符都属于 "A", "C", "G", "T"中的任意一个。
//
// 假设我们要调查一个基因序列的变化。一次基因变化意味着这个基因序列中的一个字符发生了变化。
//
// 例如，基因序列由"AACCGGTT" 变化至 "AACCGGTA" 即发生了一次基因变化。
//
// 与此同时，每一次基因变化的结果，都需要是一个合法的基因串，即该结果属于一个基因库。
//
// 现在给定3个参数 — start, end, bank，分别代表起始基因序列，目标基因序列及基因库，请找出能够使起始基因序列变化为目标基因序列所需的最少变
//化次数。如果无法实现目标变化，请返回 -1。
//
// 注意:
//
//
// 起始基因序列默认是合法的，但是它并不一定会出现在基因库中。
// 所有的目标基因序列必须是合法的。
// 假定起始基因序列与目标基因序列是不一样的。
//
//
// 示例 1:
//
//
//start: "AACCGGTT"
//end:   "AACCGGTA"
//bank: ["AACCGGTA"]
//
//返回值: 1
//
//
// 示例 2:
//
//
//start: "AACCGGTT"
//end:   "AAACGGTA"
//bank: ["AACCGGTA", "AACCGCTA", "AAACGGTA"]
//
//返回值: 2
//
//
// 示例 3:
//
//
//start: "AAAAACCC"
//end:   "AACCCCCC"
//bank: ["AAAACCCC", "AAACCCCC", "AACCCCCC"]
//
//返回值: 3
//
// 👍 57 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class 最小基因变化 {

  //广度遍历
  // 时间复杂度 o(26 * N) N为单词的长度的长度
  //空间复杂度：O(M) M为wordList的长度,最坏情况visited 要保持wordList的长度
  //并且 wordSet也会保存wordList去重之后的大小
  public int minMutation(String start, String end, String[] bank) {
    HashSet<String> bankSet = new HashSet(Arrays.asList(bank));
    bankSet.remove(start);
    HashSet<String> visited = new HashSet();
    char[] arr = new char[]{'A', 'C', 'G', 'T'};
    if (bankSet.isEmpty()|| !bankSet.contains(end)) {
      return -1;
    }
    int level = 0;//与单词接龙的区别是 单词接龙 是转化路径  该提是转换次数  路径要比次数多1
    LinkedList<String> queue = new LinkedList();
    queue.addLast(start);
    visited.add(start);
    while(!queue.isEmpty()) {
      int size = queue.size();
      for (int i = 0; i < size; i++) {
        String curStr = queue.removeFirst();
        char[] curArr = curStr.toCharArray();
        if (curStr.equals(end)) return level;
        for (int j = 0; j < curArr.length; j++) {
          char origin = curArr[j];
          for (char c : arr) {
            if (origin == c) continue;
            curArr[j] = c;
            String next = new String(curArr);
            if (bankSet.contains(next) && !visited.contains(next)) {
              queue.addLast(next);
              visited.add(next);
            }
          }
          curArr[j] = origin; //注意还原
        }
      }
      level++;
    }
    return -1;
  }
}
//leetcode submit region end(Prohibit modification and deletion)

