import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;

public class WordLadder {

  //时间复杂度: o（n）如果一开始就构建图，每一个单词都需要和除它以外的另外的单词进行比较，复杂度是 O(NwordLen)，这里 N 是单词列表的长度；
  //为此，我们在遍历一开始，把所有的单词列表放进一个哈希表中，然后在遍历的时候构建图，每一次得到在单词列表里可以转换的单词，复杂度是 O(26×wordLen)，
  //26作为常数，不用加
  //空间复杂度
  // 广度优先遍历 使用wordsSet 存储字典列表,o(n)
  public int ladderLength(String beginWord, String endWord, List<String> wordList) {
    HashSet<String> wordsSet = new HashSet(wordList);
    wordsSet.remove(beginWord);
    if (!wordsSet.contains(endWord)) {
      return 0;
    }
    LinkedList<String> que = new LinkedList();
    HashSet<String> visit = new HashSet();
    que.addFirst(beginWord);
    int level = 0;
    while (!que.isEmpty()) {
      int size = que.size();
      level++;
      for (int i = 0; i < size; i++) {
        String curstr = que.removeLast();
        char[] cur = curstr.toCharArray();

        if (curstr.equals(endWord)) {
          return level;
        }
        for (int j = 0; j < cur.length; j++) {
          char originchar = cur[j];
          for (char c = 'a'; c <= 'z'; c++) {
            cur[j] = c;
            String newstr = new String(cur);
            cur[j] = originchar;

            if (!wordsSet.contains(newstr)) {
              continue;
            }

            if (visit.contains(newstr)) {
              continue;
            }
            visit.add(newstr);
            que.addFirst(newstr);

          }

        }
      }
    }
    return 0;

  }
}