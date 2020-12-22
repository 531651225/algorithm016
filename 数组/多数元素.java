import java.util.Arrays;

//给定一个大小为 n 的数组，找到其中的多数元素。多数元素是指在数组中出现次数大于 ⌊ n/2 ⌋ 的元素。
//
// 你可以假设数组是非空的，并且给定的数组总是存在多数元素。
//
//
//
// 示例 1:
//
// 输入: [3,2,3]
//输出: 3
//
// 示例 2:
//
// 输入: [2,2,1,1,1,2,2]
//输出: 2
//
// Related Topics 位运算 数组 分治算法
// 👍 824 👎 0


import java.util.Arrays;

//leetcode submit region begin(Prohibit modification and deletion)
class 多数元素 {
  //1.hash表

  //2.排序
  public int majorityElement(int[] nums) {
    Arrays.sort(nums);
    return nums[nums.length / 2];
  }

  //最优解：投票法，众数个数至少比非众数多一，把COUNT加减当作一个众数抵消掉一个非众数，剩下的一定是众数
  public int majorityElement(int[] nums) {
    int major = nums[0], count = 1;
    for (int i = 0; i < nums.length; i++) {
      if (nums[i] == major) {
        count++;
      } else if (--count == 0) {
        major = nums[i];
        count = 1;
      }
    }
    return major;
  }
}
//leetcode submit region end(Prohibit modification and deletion)

