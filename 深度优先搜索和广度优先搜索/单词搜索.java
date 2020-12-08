//给定一个二维网格和一个单词，找出该单词是否存在于网格中。
//
// 单词必须按照字母顺序，通过相邻的单元格内的字母构成，其中“相邻”单元格是那些水平相邻或垂直相邻的单元格。同一个单元格内的字母不允许被重复使用。
//
//
//
// 示例:
//
// board =
//[
//  ['A','B','C','E'],
//  ['S','F','C','S'],
//  ['A','D','E','E']
//]
//
//给定 word = "ABCCED", 返回 true
//给定 word = "SEE", 返回 true
//给定 word = "ABCB", 返回 false
//
//
//
// 提示：
//
//
// board 和 word 中只包含大写和小写英文字母。
// 1 <= board.length <= 200
// 1 <= board[i].length <= 200
// 1 <= word.length <= 10^3
//
// Related Topics 数组 回溯算法
// 👍 704 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class 单词搜索 {
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
