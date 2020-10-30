//给定一个二维网格 board 和一个字典中的单词列表 words，找出所有同时在二维网格和字典中出现的单词。
//
// 单词必须按照字母顺序，通过相邻的单元格内的字母构成，其中“相邻”单元格是那些水平相邻或垂直相邻的单元格。同一个单元格内的字母在一个单词中不允许被重复使用。
//
//
// 示例:
//
// 输入:
//words = ["oath","pea","eat","rain"] and board =
//[
//  ['o','a','a','n'],
//  ['e','t','a','e'],
//  ['i','h','k','r'],
//  ['i','f','l','v']
//]
//
//输出: ["eat","oath"]
//
// 说明:
//你可以假设所有输入都由小写字母 a-z 组成。
//
// 提示:
//
//
// 你需要优化回溯算法以通过更大数据量的测试。你能否早点停止回溯？
// 如果当前单词不存在于所有单词的前缀中，则可以立即停止回溯。什么样的数据结构可以有效地执行这样的操作？散列表是否可行？为什么？ 前缀树如何？如果你想学习如何
//实现一个基本的前缀树，请先查看这个问题： 实现Trie（前缀树）。
//
// Related Topics 字典树 回溯算法
// 👍 271 👎 0


//leetcode submit region begin(Prohibit modification and deletion)

//时间复杂度：O(M(4⋅3 ^L−1))，其中M 是二维网格中的单元格数，L 是单词的最大长度。
//计算回溯算法将执行的确切步数是一个棘手的问题。
// 我们为这个问题的最坏情况提供了该步骤的上限。
// 该算法循环遍历二维网格中的所有单元，因此在复杂度公式中我们有 M 作为因子。然后将其归结为每个启动单元所需的最大步骤数（即 4⋅3^L−1）。
//假设单词的最大长度是 L，从一个单元格开始，最初我们最多可以探索 4 个方向。假设每个方向都是有效的（即最坏情况），在接下来的探索中，我们最多有 3 个相邻的单元（不包括我们来的单元）要探索。
// 因此，在回溯探索期间，我们最多遍历 4⋅3L−1 个单元格。
//你可能会想最坏的情况是什么样子。这里有一个例子。想象一下，二维网格中的每个单元都包含字母 a，单词词典包含一个单词 ['aaaa']。这是算法将遇到的最坏的情况之一。
//空间复杂度：O(N)，其中 N 是字典中的字母总数。
//算法消耗的主要空间是我们构建的 Trie 数据结构。在最坏的情况下，如果单词之间没有前缀重叠，则 Trie 将拥有与所有单词的字母一样多的节点。也可以选择在 Trie 中保留单词的副本。因此，我们可能需要 2N 的空间用于 Trie


public class 单词搜索2 {

  List<String> res=new ArrayList();

  public List<String> findWords(char[][] board, String[] words) {
    Trie trie=buidTrie(words);

    int m=board.length;
    int n=board[0].length;

    for (int i=0; i < m; i++) {
      for (int j=0; j < n; j++) {
        dfs(board, i, j, m, n, trie.root);
      }
    }
    return res;
  }

  Trie buidTrie(String[] words) {
    Trie trie=new Trie();
    for (String word : words) {
      trie.insert(word);
    }
    return trie;
  }

  void dfs(char[][] board, int i, int j, int m, int n, TrieNode node) {

    if (i < 0 || j < 0 || i >= m || j >= n) {
      return;
    }
    char c=board[i][j];
    if (c == '#' || node.child[c - 'a'] == null) {
      return;
    }
    TrieNode current=node.child[c - 'a'];
    if (current.word != null) {
      res.add(current.word);
      current.word=null;
    }

    board[i][j]='#';
    dfs(board, i, j + 1, m, n, current);
    dfs(board, i, j - 1, m, n, current);
    dfs(board, i + 1, j, m, n, current);
    dfs(board, i - 1, j, m, n, current);
    board[i][j]=c;

  }


}

class TrieNode {

  public char val;
  public String word;
  public TrieNode[] child=new TrieNode[26];

  public TrieNode(char c) {
    this.val=c;
  }
}

class Trie {

  public TrieNode root;

  public Trie() {
    root=new TrieNode(' ');
  }

  void insert(String word) {
    TrieNode current=root;
    for (char c : word.toCharArray()) {
      if (current.child[c - 'a'] == null) {
        current.child[c - 'a']=new TrieNode(c);
      }
      current=current.child[c - 'a'];
    }
    current.word=word;
  }

}

//leetcode submit region end(Prohibit modification and deletion)
