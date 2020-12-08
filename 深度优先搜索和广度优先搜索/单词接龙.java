//给定两个单词（beginWord 和 endWord）和一个字典，找到从 beginWord 到 endWord 的最短转换序列的长度。转换需遵循如下规则：
//
//
//
// 每次转换只能改变一个字母。
// 转换过程中的中间单词必须是字典中的单词。
//
//
// 说明:
//
//
// 如果不存在这样的转换序列，返回 0。
// 所有单词具有相同的长度。
// 所有单词只由小写字母组成。
// 字典中不存在重复的单词。
// 你可以假设 beginWord 和 endWord 是非空的，且二者不相同。
//
//
// 示例 1:
//
// 输入:
//beginWord = "hit",
//endWord = "cog",
//wordList = ["hot","dot","dog","lot","log","cog"]
//
//输出: 5
//
//解释: 一个最短转换序列是 "hit" -> "hot" -> "dot" -> "dog" -> "cog",
//     返回它的长度 5。
//
//
// 示例 2:
//
// 输入:
//beginWord = "hit"
//endWord = "cog"
//wordList = ["hot","dot","dog","lot","log"]
//
//输出: 0
//
//解释: endWord "cog" 不在字典中，所以无法进行转换。
// Related Topics 广度优先搜索
// 👍 492 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class 单词接龙 {

  //广度遍历
  // 时间复杂度 o(26 * N) N为单词的长度的长度
  //空间复杂度：O(M) M为wordList的长度,最坏情况visited 要保持wordList的长度
  //并且 wordSet也会保存wordList去重之后的大小
  public int ladderLength(String beginWord, String endWord, List<String> wordList) {
//注意set  可以是判断 转换的单词在不在字典  是0（1）的复杂度
    Set<String> wordset = new HashSet(wordList);
    wordList.remove(beginWord);
    if (wordset.isEmpty() || !wordset.contains(endWord)) {
      return 0;
    }
    LinkedList<String> que = new LinkedList();
    Set<String> visited = new HashSet();
    que.addLast(beginWord);
    visited.add(beginWord);
    int level = 1;

    while (!que.isEmpty()) {
      int size = que.size();
      for (int i = 0; i < size; i++) {
        String cur = que.removeFirst();
        if (cur.equals(endWord)) return level;
        char[] arr = cur.toCharArray();
        for (int j = 0; j < arr.length; j++) {
          char origin = arr[j];
          for (char c = 'a'; c <= 'z'; c++ ) {
            arr[j] = c;
            String next = new String(arr);
            if (!wordset.contains(next) || visited.contains(next)) continue;
            que.add(next);
            visited.add(next);
          }
          arr[j] = origin;//注意还原
        }
      }
      level++;
    }
    return 0;
  }


  //双向优先广度遍历
  public int ladderLength(String beginWord, String endWord, List<String> wordList) {
    // 第 1 步：先将 wordList 放到哈希表里，便于判断某个单词是否在 wordList 里
    Set<String> wordSet = new HashSet<>(wordList);
    wordSet.remove(beginWord);
    if (wordSet.size() == 0 || !wordSet.contains(endWord)) {
      return 0;
    }

    // 第 2 步：已经访问过的 word 添加到 visited 哈希表里
    Set<String> visited = new HashSet<>();
    // 分别用左边和右边扩散的哈希表代替单向 BFS 里的队列，它们在双向 BFS 的过程中交替使用
    Set<String> beginVisited = new HashSet<>();
    beginVisited.add(beginWord);
    Set<String> endVisited = new HashSet<>();
    endVisited.add(endWord);

    // 第 3 步：执行双向 BFS，左右交替扩散的步数之和为所求
    int step = 0;
    while (!beginVisited.isEmpty() && !endVisited.isEmpty()) {
      // 优先选择小的哈希表进行扩散，考虑到的情况更少
      if (beginVisited.size() > endVisited.size()) {
        Set<String> temp = beginVisited;
        beginVisited = endVisited;
        endVisited = temp;
      }
      step++;
      Set<String> nextLevelVisited = new HashSet<>();
      for (String word : beginVisited) {
        char[] charArray = word.toCharArray();
        for (int i = 0; i < word.length(); i++) {
          char originChar = charArray[i];
          for (char c = 'a'; c <= 'z'; c++) {
            if (originChar == c) {
              continue;
            }
            charArray[i] = c;
            String nextWord = String.valueOf(charArray);
            if (wordSet.contains(nextWord)) {
              if (endVisited.contains(nextWord)) {
                return step + 1;
              }
              if (!visited.contains(nextWord)) {
                nextLevelVisited.add(nextWord);
                visited.add(nextWord);
              }
            }
          }
          // 恢复，下次再用
          charArray[i] = originChar;
        }

      }

      // 原来的 beginVisited 废弃，从 nextLevelVisited 开始新的双向 BFS
      beginVisited = nextLevelVisited;
    }
    return 0;
  }
}
//leetcode submit region end(Prohibit modification and deletion)


