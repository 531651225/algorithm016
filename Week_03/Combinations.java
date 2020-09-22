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
// 👍 397 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Combinations {
  List<List<Integer>> res = new ArrayList();
  public List<List<Integer>> combine(int n, int k) {
    recur(n, k, 1, new ArrayList());
    return res;
  }

  private void recur(int n, int k, int start, List<Integer> tempList) {
    if (tempList.size() == k) {
      res.add(new ArrayList(tempList));
      return;
    }
    //剪枝 当前状态集合的大小 + 剩余可选元素 小于k
    if (n - start + 1 + tempList.size() < k) {
      return;
    }
    for (int i = start; i <= n; i++) {
      tempList.add(i);
      recur(n, k, i + 1, tempList);
      tempList.remove(tempList.size() - 1);
    }
  }
}
//leetcode submit region end(Prohibit modification and deletion)
