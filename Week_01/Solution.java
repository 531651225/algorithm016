//给定一个数组 nums，编写一个函数将所有 0 移动到数组的末尾，同时保持非零元素的相对顺序。
//
// 示例:
//
// 输入: [0,1,0,3,12]
//输出: [1,3,12,0,0]
//
// 说明:
//
//
// 必须在原数组上操作，不能拷贝额外的数组。
// 尽量减少操作次数。
//
// Related Topics 数组 双指针
// 👍 731 👎 0


//时间复杂度 O(n)
//空间复杂度 O(1)
class Solution {

  public void moveZeroes(int[] nums) {
    int len = nums.length;
    int lastNonZero = 0;
    for (int i = 0; i < len; i++) {
      if (nums[i] != 0) {
        if (i != lastNonZero) {
          nums[lastNonZero] = nums[i];
          nums[i] = 0;
        }
        lastNonZero++;
      }
    }
  }
}
//用lastNonZero保存当前非0应该放的位置
//注意不管lastNonZero是否等于i,都要lastNonZero都要++
