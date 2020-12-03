//给定两个整数 n 和 k，返回 1 ... n 中所有可能的 k 个数的组合。
//
// 示例:
//
// 输入: n = 4, k = 2
//输出:
//[
//  [2,4],
//  [3,4],
//  [2,3],
//  [1,2],
//  [1,3],
//  [1,4],
//]
// Related Topics 回溯算法
// 👍 448 👎 0


import java.util.ArrayList;

//leetcode submit region begin(Prohibit modification and deletion)
class 组合 {
  List<List<Integer>> res= new ArrayList();
  public List<List<Integer>> combine(int n, int k) {
    recur(n, k, 1, new ArrayList<>());
    return res;
  }
  void recur(int n, int k, int start, ArrayList<Integer> temp) {
    //terminator
    if(temp.size() == k) {
      res.add(new ArrayList<>(temp));
      return;
    }
    for (int i = start; i <= n; i++) {
      if (temp.size() + n - i + 1 < k) return;
      temp.add(i);
      recur(n, k, i + 1, temp);
      temp.remove(temp.size() - 1);
    }
  }
}
//leetcode submit region end(Prohibit modification and deletion)

