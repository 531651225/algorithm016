//n 皇后问题研究的是如何将 n 个皇后放置在 n×n 的棋盘上，并且使皇后彼此之间不能相互攻击。
//
//
//
// 上图为 8 皇后问题的一种解法。
//
// 给定一个整数 n，返回 n 皇后不同的解决方案的数量。
//
// 示例:
//
// 输入: 4
//输出: 2
//解释: 4 皇后问题存在如下两个不同的解法。
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
//
//
//
// 提示：
//
//
// 皇后，是国际象棋中的棋子，意味着国王的妻子。皇后只做一件事，那就是“吃子”。当她遇见可以吃的棋子时，就迅速冲上去吃掉棋子。当然，她横、竖、斜都可走一或 N
//-1 步，可进可退。（引用自 百度百科 - 皇后 ）
//
// Related Topics 回溯算法
// 👍 214 👎 0

//
//import java.util.Arrays;
//import java.util.HashSet;
//
////leetcode submit region begin(Prohibit modification and deletion)
class N皇后2 {

  Set<Integer> cols=new HashSet<Integer>();
  Set<Integer> pies=new HashSet<Integer>();
  Set<Integer> nas=new HashSet<Integer>();
  int count=0;

  public int totalNQueens(int n) {
    recur(n, 0);
    return count;
  }

  void recur(int n, int row) {
    //terminator
    if (n == row) {
      count++;
      return;
    }
    for (int col=0; col < n; col++) {
      int pie=row - col;
      int na=row + col;
      if (!check(col, pie, na)) {
        cols.add(col);
        pies.add(pie);
        nas.add(na);
        recur(n, row + 1);
        cols.remove(col);
        pies.remove(pie);
        nas.remove(na);
      }
    }
  }

  boolean check(int col, int pie, int na) {
    if (cols.contains(col) || nas.contains(na) || pies.contains(pie)) {
      return true;
    }
    return false;
  }
}
