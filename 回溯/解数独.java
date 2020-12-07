//编写一个程序，通过填充空格来解决数独问题。
//
// 一个数独的解法需遵循如下规则：
//
//
// 数字 1-9 在每一行只能出现一次。
// 数字 1-9 在每一列只能出现一次。
// 数字 1-9 在每一个以粗实线分隔的 3x3 宫内只能出现一次。
//
//
// 空白格用 '.' 表示。
//
//
//
// 一个数独。
//
//
//
// 答案被标成红色。
//
// 提示：
//
//
// 给定的数独序列只包含数字 1-9 和字符 '.' 。
// 你可以假设给定的数独只有唯一解。
// 给定数独永远是 9x9 形式的。
//
// Related Topics 哈希表 回溯算法
// 👍 709 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class 解数独 {
  boolean[][] rows = new boolean[9][9];
  boolean[][] cols = new boolean[9][9];
  boolean[][] cubes = new boolean[9][9];

  public void solveSudoku(char[][] board) {
    for (int i = 0; i < 9; i++) {
      for(int j = 0; j < 9; j++) {
        if (board[i][j] != '.') {
          int num = board[i][j] - '1';
          rows[i][num] = true;
          cols[j][num] = true;
          cubes[(i / 3) * 3 + j / 3][num] = true;
        }
      }
    }
    recur(board);
  }

  boolean recur(char[][] board) {
    for (int i = 0; i < 9; i++) {
      for (int j = 0; j < 9; j++) {
        if (board[i][j] != '.') continue;
        for (char c = '1'; c <= '9'; c++) {
          if (!check(i, j, c)) {
            int num = c - '1';
            //current process

            rows[i][num] = true;cols[j][num] = true;cubes[(i / 3 ) * 3 + j / 3][num] = true;
            board[i][j] = c;
            //drill down
            if (recur(board)) return true;

            //restore state
            rows[i][num] = false;cols[j][num] = false;cubes[(i / 3 ) * 3 + j / 3][num] = false;
            board[i][j] = '.';

          }
        }
        return false;
      }
    }
    return true;
  }

  boolean check(int row, int col, char c) {
    int num = c - '1';
    if (rows[row][num] || cols[col][num] || cubes[row / 3 * 3 + col / 3][num]) return true;
    return false;
  }
}
//leetcode submit region end(Prohibit modification and deletion)

