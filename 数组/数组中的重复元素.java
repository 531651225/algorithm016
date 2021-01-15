//给定一个整数数组 a，其中1 ≤ a[i] ≤ n （n为数组长度）, 其中有些元素出现两次而其他元素出现一次。
//
// 找到所有出现两次的元素。
//
// 你可以不用到任何额外空间并在O(n)时间复杂度内解决这个问题吗？
//
// 示例：
//
//
//输入:
//[4,3,2,7,8,2,3,1]
//
//输出:
//[2,3]
//
// Related Topics 数组
// 👍 324 👎 0


import java.util.ArrayList;

//leetcode submit region begin(Prohibit modification and deletion)
class 数组中的重复元素 {
  public List<Integer> findDuplicates(int[] nums) {
    List<Integer> res = new ArrayList<>();
    for (int i = 0; i < nums.length; i++) {
      while(nums[i] >= 1 && nums[i] <= nums.length && nums[i] != nums[nums[i] - 1]){
        swap(nums, nums[i] - 1, i);
      }
    }
    for (int i = 0; i < nums.length; i++) {
      if (nums[i] != i + 1) {
        res.add(nums[i]);
      }
    }
    return res;
  }
  void swap(int[] nums, int i, int j) {
    int temp = nums[i];
    nums[i] = nums[j];
    nums[j] = temp;
  }

}
//leetcode submit region end(Prohibit modification and deletion)
