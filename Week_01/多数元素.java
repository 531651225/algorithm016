
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
// 👍 754 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class 多数元素 {
  //时间复杂度 o(nlogn)
  //空间复杂度 o(1)
  //排序
//    public int majorityElement(int[] nums) {
//        Arrays.sort(nums);
//        return nums[nums.length / 2];
//    }
  // 时间 O(1)
  // 空间 O(1)
  //投票算法
  public int majorityElement(int[] nums) {
    int count = 1, majorNum = nums[0];
    for (int i = 1; i < nums.length; i++) {
      if (majorNum == nums[i]) {
        count++;
      } else if (--count == 0) {
        majorNum = nums[i];
        count = 1;
      }
    }
    return majorNum;
  }
}
//leetcode submit region end(Prohibit modification and deletion)

