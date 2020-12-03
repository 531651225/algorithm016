//给定一个 没有重复 数字的序列，返回其所有可能的全排列。
//
// 示例:
//
// 输入: [1,2,3]
//输出:
//[
//  [1,2,3],
//  [1,3,2],
//  [2,1,3],
//  [2,3,1],
//  [3,1,2],
//  [3,2,1]
//]
// Related Topics 回溯算法
// 👍 909 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class 全排列 {
  List<List<Integer>> res = new ArrayList();
  public List<List<Integer>> permute(int[] nums) {
    boolean[] used = new boolean[nums.length];
    recur(nums, new ArrayList(), used);
    return res;
  }

  private void recur(int[] nums, List<Integer> tempList, boolean[] used) {
    //terminator
    if (tempList.size() == nums.length) {
      res.add(new ArrayList(tempList));
    }

    for (int i = 0; i < nums.length; i++) {
      if (!used[i]) {
        //current process
        tempList.add(nums[i]);
        used[i] = true;
        //drill down
        recur(nums, tempList, used);
        //restore state
        tempList.remove(tempList.size() - 1);
        used[i] = false;
      }
    }

  }

}
//leetcode submit region end(Prohibit modification and deletion)

