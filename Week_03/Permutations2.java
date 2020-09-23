//给定一个可包含重复数字的序列，返回所有不重复的全排列。
//
// 示例:
//
// 输入: [1,1,2]
//输出:
//[
//  [1,1,2],
//  [1,2,1],
//  [2,1,1]
//]
// Related Topics 回溯算法
// 👍 463 👎 0


import com.sun.org.apache.bcel.internal.generic.AALOAD;
import java.util.HashSet;

//leetcode submit region begin(Prohibit modification and deletion)

    //时间复杂度为 O(n×n!) 没看懂为啥是这个？
    //空间复杂度：O(n)。我们需要 O(n) 的标记数组，同时在递归的时候栈深度会达到 O(n)，因此总空间复杂度为 O(n+n)=O(2n)=O(n)
class Permutations2 {

  List<List<Integer>> res = new ArrayList();
  public List<List<Integer>> permuteUnique(int[] nums) {
    boolean[] used = new boolean[nums.length];
    Arrays.sort(nums);
    recur(nums, new ArrayList(), used);
    return res;
  }

  private void recur(int[] nums, List<Integer> tempList, boolean[] used) {
    //terminator
    if (tempList.size() == nums.length) {
      res.add(new ArrayList(tempList));
      return;
    }
    for (int i = 0; i < nums.length; i++) {
      if (used[i]) {
        continue;
      }
      // 剪枝条件：i > 0 是为了保证 nums[i - 1] 有意义
      // 写 !used[i - 1] 是因为 nums[i - 1] 在深度优先遍历的过程中刚刚被撤销选择
      if (i > 0 && nums[i - 1] == nums[i] && used[i - 1] == false) {
        continue;
      }

      tempList.add(nums[i]);
      used[i] = true;
      recur(nums, tempList, used);
      tempList.remove(tempList.size() - 1);
      used[i] = false;

    }
  }

}
//leetcode submit region end(Prohibit modification and deletion)
