
//请你设计一个数据结构，支持 添加新单词 和 查找字符串是否与任何先前添加的字符串匹配 。
//
// 实现词典类 WordDictionary ：
//
//
// WordDictionary() 初始化词典对象
// void addWord(word) 将 word 添加到数据结构中，之后可以对它进行匹配
// bool search(word) 如果数据结构中存在字符串与 word 匹配，则返回 true ；否则，返回 false 。word 中可能包含一些 '
//.' ，每个 . 都可以表示任何一个字母。
//
//
//
//
// 示例：
//
//
//输入：
//["WordDictionary","addWord","addWord","addWord","search","search","search","se
//arch"]
//[[],["bad"],["dad"],["mad"],["pad"],["bad"],[".ad"],["b.."]]
//输出：
//[null,null,null,null,false,true,true,true]
//
//解释：
//WordDictionary wordDictionary = new WordDictionary();
//wordDictionary.addWord("bad");
//wordDictionary.addWord("dad");
//wordDictionary.addWord("mad");
//wordDictionary.search("pad"); // return False
//wordDictionary.search("bad"); // return True
//wordDictionary.search(".ad"); // return True
//wordDictionary.search("b.."); // return True
//
//
//
//
// 提示：
//
//
// 1 <= word.length <= 500
// addWord 中的 word 由小写英文字母组成
// search 中的 word 由 '.' 或小写英文字母组成
// 最多调用 50000 次 addWord 和 search
//
// Related Topics 深度优先搜索 设计 字典树 回溯算法
// 👍 207 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class 添加与搜索单词 {
  Node root ;
  /** Initialize your data structure here. */
  public WordDictionary() {
    root = new Node(' ', false);
  }

  public void addWord(String word) {
    Node cur = root;
    for (int i = 0; i < word.length(); i++) {
      char c = word.charAt(i);
      if(cur.childs[c - 'a'] == null) {
        cur.childs[c - 'a'] = new Node(c, false);
      }
      cur = cur.childs[c - 'a'];
    }
    cur.isworld = true;
  }

  public boolean search(String word) {
    return helper(word, root);
  }


  public boolean helper(String word, Node node) {
    Node cur = node;
    for (int i = 0; i < word.length(); i++) {
      char c = word.charAt(i);
      if (word.charAt(i) == '.') {
        for (int j = 0; j < 26; j++) {
          if(cur.childs[j] != null) {
            if(helper(word.substring(i + 1), cur.childs[j]))
              return true;
          }
        }
        return false;
      }
      if(cur.childs[c - 'a'] == null) return false;
      cur = cur.childs[c - 'a'];
    }
    return cur.isworld == true;
  }
}

class Node {
  public char val;
  public boolean isworld;
  public Node[] childs = new Node[512];
  public Node(char c, boolean isworld) {
    this.val = val;
    this.isworld = isworld;
  }


}

/**
 * Your WordDictionary object will be instantiated and called as such:
 * WordDictionary obj = new WordDictionary();
 * obj.addWord(word);
 * boolean param_2 = obj.search(word);
 */
//leetcode submit region end(Prohibit modification and deletion)

