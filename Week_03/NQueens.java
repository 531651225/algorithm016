//设计一种算法，打印 N 皇后在 N × N 棋盘上的各种摆法，其中每个皇后都不同行、不同列，也不在对角线上。这里的“对角线”指的是所有的对角线，不只是平分整
//个棋盘的那两条对角线。
//
// 注意：本题相对原题做了扩展
//
// 示例:
//
//  输入：4
// 输出：[[".Q..","...Q","Q...","..Q."],["..Q.","Q...","...Q",".Q.."]]
// 解释: 4 皇后问题存在如下两个不同的解法。
//[
// [".Q..",  // 解法 1
//  "...Q",
//  "Q...",
//  "..Q."],
//
// ["..Q.",  // 解法 2
//  "Q...",
//  "...Q",
//  ".Q.."]
//]
//
// Related Topics 回溯算法
// 👍 41 👎 0


import java.util.ArrayList;
import javax.sound.midi.Receiver;

//leetcode submit region begin(Prohibit modification and deletion)
class NQueens {

  //时间复杂度：O(N!)，其中 N 是皇后数量

  //空间复杂度：O(N)，其中 N 是皇后数量
  //空间复杂度主要取决于递归调用层数、记录每行放置的皇后的列下标的数组以及三个集合，
  //递归调用层数不会超过 N，数组的长度为 N，每个集合的元素个数都不会超过 N。


  HashSet<Integer> cols = new HashSet();
  HashSet<Integer> pie = new HashSet();
  HashSet<Integer> na = new HashSet();

  List<List<String>> res = new ArrayList();

  public List<List<String>> solveNQueens(int n) {
    recur(n, 0, new ArrayList<String>());
    return res;
  }

  void recur(int n, int row, List<String> temp) {
    if (n == row) {
      res.add(new ArrayList<String>(temp));
      return;
    }

    for (int col = 0; col < n; col++) {
      if (check(row, col)) {
        char[] arr = new char[n];
        Arrays.fill(arr, '.');
        arr[col] = 'Q';
        cols.add(col);
        pie.add(row + col);
        na.add(row - col);
        temp.add(new String(arr));
        recur(n, row + 1, temp);
        cols.remove(col);
        pie.remove(row + col);
        na.remove(row - col);
        temp.remove(temp.size() - 1);
      }

    }

  }

  boolean check(int row, int col) {
    if (cols.contains(col) ||
        pie.contains(row + col) ||
        na.contains(row - col)) {
      return false;
    }
    return true;
  }
}
//leetcode submit region end(Prohibit modification and deletion)
