import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

public class WordLadder2 {

  List<List<String>> res = new ArrayList<>();
  LinkedList<String> queue = new LinkedList<>();
  HashSet<String> visited = null;
  HashSet<String> wordSet = null;
  HashMap<String, HashSet<String>> dic = new HashMap<>();

  public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
    wordSet = new HashSet<>(wordList);
    visited = new HashSet<>();
    wordSet.remove(beginWord);
    if (!bfs(beginWord, endWord, wordList)) {
      return res;
    }
    dfs(endWord, beginWord, new ArrayList<String>(Arrays.asList(beginWord)));

    return res;
  }

  private void dfs(String endWord, String lastStr, ArrayList<String> path) {
    if (lastStr.equals(endWord)) {
      res.add(new ArrayList<>(path));
      return;
    }
    if (!dic.containsKey(lastStr)) {
      return;
    }
    for (String world : dic.get(lastStr)) {
      path.add(world);
      dfs(endWord, world, path);
      path.remove(path.size() - 1);
    }

  }

  public boolean bfs(String beginWord, String endWord, List<String> wordList) {
    queue.addFirst(beginWord);
    while (!queue.isEmpty()) {
      int size = queue.size();
      // 当前层访问过的结点，当前层全部遍历完成以后，再添加到总的 visited 集合里
      Set<String> nextLevelVisited = new HashSet<>();

      for (int i = 0; i < size; i++) {
        String world = queue.removeLast();
        if (world.equals(endWord)) {
          return true;
        }
        char[] cur = world.toCharArray();
        for (int index = 0; index < cur.length; index++) {
          for (char c = 'a'; c <= 'z'; c++) {
            char origion = cur[index];
            cur[index] = c;
            String newstr = new String(cur);
            cur[index] = origion;
            if (!wordSet.contains(newstr)) {
              continue;
            }
            if (visited.contains(newstr)) {
              continue;
            }
            nextLevelVisited.add(newstr);
            queue.addFirst(newstr);
            if (dic.containsKey(world)) {
              dic.get(world).add(newstr);
            } else {
              dic.put(world, new HashSet<>(Arrays.asList(newstr)));
            }
          }
        }

      }
      visited.addAll(nextLevelVisited);
      nextLevelVisited.clear();
    }
    return false;
  }

  public static void main(String[] args) {
    String beginWord = "hit";
    String endWord = "cog";
    List<String> wordList = Arrays.asList("hot", "dot", "dog", "lot", "log", "cog");
    WordLadder2 wordLadder2 = new WordLadder2();
    wordLadder2.findLadders(beginWord, endWord, wordList);
  }

}
