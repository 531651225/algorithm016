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
  List<List<String>> res = new ArrayList<List<String>>();
  HashMap<String, Integer> distance = new HashMap<>();
  HashMap<String, ArrayList<String>> nodeNeighbors = new HashMap<>();
  public List<List<String>> findLadders(String start, String end, List<String> wordList) {

    HashSet<String> dict = new HashSet<>(wordList);
    dict.remove(start);

    ArrayList<String> solution = new ArrayList<String>();

    dict.add(start);
    bfs(start, end, dict);
    dfs(start, end, dict, solution);
    return res;


  }

  private void bfs(String start, String end, Set<String> dict) {
    for (String str : dict)
      nodeNeighbors.put(str, new ArrayList<String>());

    Queue<String> queue = new LinkedList<String>();
    queue.offer(start);
    distance.put(start, 0);

    while (!queue.isEmpty()) {
      int count = queue.size();
      boolean foundEnd = false;
      for (int i = 0; i < count; i++) {
        String cur = queue.poll();
        if (cur.equals(end)) {
          foundEnd = true;
        }
        int curDistance = distance.get(cur);

        char chs[] = cur.toCharArray();

        for (char ch ='a'; ch <= 'z'; ch++) {
          for (int j = 0; j < chs.length; j++) {
            if (chs[j] == ch) continue;
            char old_ch = chs[j];
            chs[j] = ch;
            String next = String.valueOf(chs);
            if (dict.contains(next)) {
              nodeNeighbors.get(cur).add(next);
              if (!distance.containsKey(next)) {// Check if visited
                distance.put(next, curDistance + 1);
                queue.offer(next);
              }

            }
            chs[j] = old_ch;
          }

        }
        if (foundEnd)
          break;
      }
    }
  }

  private void dfs(String cur, String end, Set<String> dict, ArrayList<String> solution) {
    solution.add(cur);
    if (end.equals(cur)) {
      res.add(new ArrayList<String>(solution));
    } else {
      for (String next : nodeNeighbors.get(cur)) {
        if (distance.get(next) == distance.get(cur) + 1) {
          dfs(next, end, dict, solution);
        }
      }
    }
    solution.remove(solution.size() - 1);
  }


}
