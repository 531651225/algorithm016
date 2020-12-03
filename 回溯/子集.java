//给定一组不含重复元素的整数数组 nums，返回该数组所有可能的子集（幂集）。
//
// 说明：解集不能包含重复的子集。
//
// 示例:
//
// 输入: nums = [1,2,3]
//输出:
//[
//  [3],
//  [1],
//  [2],
//  [1,2,3],
//  [1,3],
//  [2,3],
//  [1,2],
//  []
//]
// Related Topics 位运算 数组 回溯算法
// 👍 804 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class 子集 {
  List<List<Integer>> res = new ArrayList();
  public List<List<Integer>> subsets(int[] nums) {
    recur(nums, new ArrayList(), 0);
    return res;

  }

  void recur(int[] nums, List<Integer> temp, int index) {
    //terminator
    if (index == nums.length) {
      res.add(new ArrayList(temp));
      return;
    }

    //current process

    //drill down
    recur(nums, temp, index + 1);
    temp.add(nums[index]);
    recur(nums, temp, index + 1);

    //restore current status
    temp.remove(temp.size() - 1);
  }
}
//leetcode submit region end(Prohibit modification and deletion)

