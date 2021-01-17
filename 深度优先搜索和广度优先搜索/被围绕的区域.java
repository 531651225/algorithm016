
//给定一个二维的矩阵，包含 'X' 和 'O'（字母 O）。
//
// 找到所有被 'X' 围绕的区域，并将这些区域里所有的 'O' 用 'X' 填充。
//
// 示例:
//
// X X X X
//X O O X
//X X O X
//X O X X
//
//
// 运行你的函数后，矩阵变为：
//
// X X X X
//X X X X
//X X X X
//X O X X
//
//
// 解释:
//
// 被围绕的区间不会存在于边界上，换句话说，任何边界上的 'O' 都不会被填充为 'X'。 任何不在边界上，或不与边界上的 'O' 相连的 'O' 最终都会被
//填充为 'X'。如果两个元素在水平或垂直方向相邻，则称它们是“相连”的。
// Related Topics 深度优先搜索 广度优先搜索 并查集
// 👍 451 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class 被围绕的区域 {
  int n, m;
  public void solve(char[][] board) {
    int m = board.length;
    if(m == 0) return ;

    int n = board[0].length;
    for (int i = 0; i < m; i++) {
      dfs(board, i, 0);
      dfs(board, i, n - 1);
    }

    for (int i = 0; i < n; i++) {
      dfs(board, 0, i);
      dfs(board, m - 1, i);

    }
    for (int i = 0; i < m; i++) {
      for(int j = 0; j < n; j++) {
        if (board[i][j] == 'A') {
          board[i][j] = 'O';
        } else if (board[i][j] == 'O') {
          board[i][j] = 'X';
        }

      }
    }
  }
  void dfs(char[][] board, int i, int j) {
    if(i < 0 || i >= board.length || j < 0 || j >= board[0].length || board[i][j] != 'O'  )
      return;
    board[i][j] = 'A';
    dfs(board, i, j - 1);
    dfs(board, i, j + 1);
    dfs(board, i + 1, j);
    dfs(board, i - 1, j);
  }
}
//leetcode submit region end(Prohibit modification and deletion)

