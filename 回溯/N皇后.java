//n 皇后问题研究的是如何将 n 个皇后放置在 n×n 的棋盘上，并且使皇后彼此之间不能相互攻击。
//
//
//
// 上图为 8 皇后问题的一种解法。
//
// 给定一个整数 n，返回所有不同的 n 皇后问题的解决方案。
//
// 每一种解法包含一个明确的 n 皇后问题的棋子放置方案，该方案中 'Q' 和 '.' 分别代表了皇后和空位。
//
//
//
// 示例：
//
// 输入：4
//输出：[
// [".Q..",  // 解法 1
//  "...Q",
//  "Q...",
//  "..Q."],
//
// ["..Q.",  // 解法 2
//  "Q...",
//  "...Q",
//  ".Q.."]
//]
//解释: 4 皇后问题存在两个不同的解法。
//
//
//
//
// 提示：
//
//
// 皇后彼此不能相互攻击，也就是说：任何两个皇后都不能处于同一条横行、纵行或斜线上。
//
// Related Topics 回溯算法
// 👍 681 👎 0


import java.util.ArrayList;
    import java.util.Arrays;
    import java.util.HashSet;

//leetcode submit region begin(Prohibit modification and deletion)
class N皇后 {
  HashSet<Integer> cols = new HashSet();
  HashSet<Integer> pies = new HashSet();
  HashSet<Integer> nas = new HashSet();

  List<List<String>> res = new ArrayList<>();
  public List<List<String>> solveNQueens(int n) {
    recur(0, n, new ArrayList<>());
    return res;
  }
  void recur(int row, int n, List<String> temp) {
    if (row == n) {
      res.add(new ArrayList<>(temp));
      return;
    }

    for (int col = 0; col < n; col++) {
      int pie = row - col;
      int na = row + col;
      if (!check(col, pie, na)) {

        char[] arr = new char[n];
        Arrays.fill(arr, '.');
        arr[col] = 'Q';
        temp.add(row, new String(arr));

        cols.add(col);
        pies.add(pie);
        nas.add(na);

        recur(row + 1, n, temp);

        cols.remove(col);
        pies.remove(pie);
        nas.remove(na);
        temp.remove(temp.size() - 1);
      }
    }
  }

  boolean check(int col, int pie, int na) {
    if (cols.contains(col) || pies.contains(pie) || nas.contains(na)) return true;
    return false;
  }
}
//leetcode submit region end(Prohibit modification and deletion)

