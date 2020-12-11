//实现一个 Trie (前缀树)，包含 insert, search, 和 startsWith 这三个操作。
//
// 示例:
//
// Trie trie = new Trie();
//
//trie.insert("apple");
//trie.search("apple");   // 返回 true
//trie.search("app");     // 返回 false
//trie.startsWith("app"); // 返回 true
//trie.insert("app");
//trie.search("app");     // 返回 true
//
// 说明:
//
//
// 你可以假设所有的输入都是由小写字母 a-z 构成的。
// 保证所有输入均为非空字符串。
//
// Related Topics 设计 字典树
// 👍 479 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Trie {

  private TrieNode root;

  /**
   * Initialize your data structure here.
   */
  public Trie() {
    root=new TrieNode(' ');
  }

  /**
   * Inserts a word into the trie.
   */
  //时间复杂度 O(N) N为word长度
  //空间复杂度 O(N) 最坏情况下,不存在前缀,N为word长度
  public void insert(String word) {
    TrieNode current=root;
    for (char c : word.toCharArray()) {
      if (current.child[c - 'a'] == null) {
        current.child[c - 'a']=new TrieNode(c);
      }
      current=current.child[c - 'a'];
    }
    current.isend=true;
  }

  /**
   * Returns if the word is in the trie.
   */
  //时间复杂度 O(N) N为word长度
  //空间复杂度 O(1)
  public boolean search(String word) {
    TrieNode current=root;
    for (char c : word.toCharArray()) {
      if (current.child[c - 'a'] == null) {
        return false;
      }
      current=current.child[c - 'a'];
    }
    return current.isend;

  }

  /**
   * Returns if there is any word in the trie that starts with the given prefix.
   */
  //时间复杂度 O(N) N为word长度
  //空间复杂度 O(1)
  public boolean startsWith(String prefix) {
    TrieNode current=root;
    for (char c : prefix.toCharArray()) {
      if (current.child[c - 'a'] == null) {
        return false;
      }
      current=current.child[c - 'a'];
    }
    return true;
  }
}


class TrieNode {

  public char val;
  public boolean isend;
  TrieNode[] child=new TrieNode[26];

  public TrieNode(char c) {
    this.val=c;
  }
}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */
//leetcode submit region end(Prohibit modification and deletion)

