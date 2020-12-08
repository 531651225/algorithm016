import java.util.ArrayList;



//给定一个 m x n 二维字符网格 board 和一个单词（字符串）列表 words，找出所有同时在二维网格和字典中出现的单词。
//
// 单词必须按照字母顺序，通过 相邻的单元格 内的字母构成，其中“相邻”单元格是那些水平相邻或垂直相邻的单元格。同一个单元格内的字母在一个单词中不允许被重复使
//用。
//
//
//
// 示例 1：
//
//
//输入：board = [["o","a","a","n"],["e","t","a","e"],["i","h","k","r"],["i","f","l"
//,"v"]], words = ["oath","pea","eat","rain"]
//输出：["eat","oath"]
//
//
// 示例 2：
//
//
//输入：board = [["a","b"],["c","d"]], words = ["abcb"]
//输出：[]
//
//
//
//
// 提示：
//
//
// m == board.length
// n == board[i].length
// 1 <= m, n <= 12
// board[i][j] 是一个小写英文字母
// 1 <= words.length <= 3 * 104
// 1 <= words[i].length <= 10
// words[i] 由小写英文字母组成
// words 中的所有字符串互不相同
//
// Related Topics 字典树 回溯算法
// 👍 294 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class 单词搜索2 {
  List<String> res = new ArrayList<>();
  public List<String> findWords(char[][] board, String[] words) {
    for (String world : words) {
      if(exist(board, world)) res.add(world);
    }
    return res;
  }

  public boolean exist(char[][] board, String word) {
    boolean[][] used = new boolean[board.length][board[0].length];
    for (int i = 0; i < board.length; i++) {
      for (int j = 0; j < board[0].length; j++) {
        if (board[i][j] != word.charAt(0)) continue;
        if (dfs(i, j, 0, word, board, used)) return true;
      }
    }
    return false;
  }

  boolean dfs(int i, int j, int index, String word, char[][] board, boolean[][] used) {
    if (index >= word.length()) return true;
    if (i < 0 || j < 0
        || i >= board.length
        || j >= board[0].length
        || used[i][j] || board[i][j] != word.charAt(index)) return false;
    boolean isend = false;
    used[i][j] = true;

    isend = dfs(i, j + 1, index + 1, word, board, used)
        || dfs(i, j - 1, index + 1, word, board, used)
        || dfs(i + 1, j,index + 1, word, board, used)
        || dfs(i - 1, j, index + 1, word, board, used);
    used[i][j] = false;

    return isend;
  }
}
//leetcode submit region end(Prohibit modification and deletion)

