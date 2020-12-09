import java.util.ArrayList;

//给定两个单词（beginWord 和 endWord）和一个字典 wordList，找出所有从 beginWord 到 endWord 的最短转换序列。转换
//需遵循如下规则：
//
//
// 每次转换只能改变一个字母。
// 转换后得到的单词必须是字典中的单词。
//
//
// 说明:
//
//
// 如果不存在这样的转换序列，返回一个空列表。
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
//输出:
//[
//  ["hit","hot","dot","dog","cog"],
//  ["hit","hot","lot","log","cog"]
//]
//
//
// 示例 2:
//
// 输入:
//beginWord = "hit"
//endWord = "cog"
//wordList = ["hot","dot","dog","lot","log"]
//
//输出: []
//
//解释: endWord "cog" 不在字典中，所以不存在符合要求的转换序列。
// Related Topics 广度优先搜索 数组 字符串 回溯算法
// 👍 368 👎 0
class 单词接龙2 {
  List<List<String>> res = new ArrayList<>();
  public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {

    // 先将 wordList 放到哈希表里，便于判断某个单词是否在 wordList 里
    Set<String> wordSet = new HashSet<>(wordList);
    if (wordSet.size() == 0 || !wordSet.contains(endWord)) {
      return res;
    }

    // 第 1 步：使用广度优先遍历得到后继结点列表 successors
    // key：字符串，value：广度优先遍历过程中 key 的后继结点列表
    Map<String, Set<String>> successors = new HashMap<>();
    boolean found = bfs(beginWord, endWord, wordSet, successors);
    if (!found) {
      return res;
    }

    // 第 2 步：基于后继结点列表 successors ，使用回溯算法得到所有最短路径列表
    ArrayList<String> path = new ArrayList<>();
    path.add(beginWord);
    dfs(beginWord, endWord, successors, path);
    return res;
  }

  private boolean bfs(String beginWord, String endWord, Set<String> wordSet,
      Map<String, Set<String>> successors) {
    Queue<String> queue = new LinkedList<>();
    queue.offer(beginWord);

    // 标准写法，记录方法问过的单词
    Set<String> visited = new HashSet<>();
    visited.add(beginWord);

    boolean found = false;
    int wordLen = beginWord.length();
    while (!queue.isEmpty()) {
      // 当前层访问过的结点，当前层全部遍历完成以后，再添加到总的 visited 集合里
      Set<String> nextLevelVisited = new HashSet<>();

      int currentSize = queue.size();
      for (int i = 0; i < currentSize; i++) {
        String currentWord = queue.poll();
        char[] charArray = currentWord.toCharArray();
        for (int j = 0; j < wordLen; j++) {
          char originChar = charArray[j];
          for (char k = 'a'; k <= 'z'; k++) {
            if (charArray[j] == k) continue;
            charArray[j] = k;
            String nextWord = new String(charArray);
            if (wordSet.contains(nextWord)) {
              if (!visited.contains(nextWord)) {
                if (nextWord.equals(endWord)) found = true;

                // 避免下层元素重复加入队列，这里感谢 https://leetcode-cn.com/u/zhao-da-ming/ 优化了这个逻辑
                if (!nextLevelVisited.contains(nextWord)) {
                  queue.offer(nextWord);
                  nextLevelVisited.add(nextWord);
                }

                // 维护 successors 的定义
                successors.computeIfAbsent(currentWord, a -> new HashSet<>());
                successors.get(currentWord).add(nextWord);
              }
            }
          }
          charArray[j] = originChar;
        }
      }

      if (found) {
        break;
      }
      visited.addAll(nextLevelVisited);
    }
    return found;
  }

  private void dfs(String beginWord, String endWord,
      Map<String, Set<String>> successors,
      ArrayList<String> path) {
    if (beginWord.equals(endWord)) {
      res.add(new ArrayList<>(path));
      return;
    }

    if (!successors.containsKey(beginWord)) {
      return;
    }

    Set<String> successorWords = successors.get(beginWord);
    for (String nextWord : successorWords) {
      path.add(nextWord);
      dfs(nextWord, endWord, successors, path);
      path.remove(path.size() - 1);
    }
  }



}


