//假设按照升序排序的数组在预先未知的某个点上进行了旋转。
//
// ( 例如，数组 [0,0,1,2,2,5,6] 可能变为 [2,5,6,0,0,1,2] )。
//
// 编写一个函数来判断给定的目标值是否存在于数组中。若存在返回 true，否则返回 false。
//
// 示例 1:
//
// 输入: nums = [2,5,6,0,0,1,2], target = 0
//输出: true
//
//
// 示例 2:
//
// 输入: nums = [2,5,6,0,0,1,2], target = 3
//输出: false
//
// 进阶:
//
//
// 这是 搜索旋转排序数组 的延伸题目，本题中的 nums 可能包含重复元素。
// 这会影响到程序的时间复杂度吗？会有怎样的影响，为什么？
//
// Related Topics 数组 二分查找
// 👍 257 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class 搜索旋转排序数组2 {
//  这道题是 33 题的升级版，元素可以重复。当 nums[left] == nums[mid] 时，无法判断 target 位于左侧还是右侧，此时无法缩小区间，退化为顺序查找
//  去掉一个干扰项，本质上还是顺序查找：
  public boolean search(int[] nums, int target) {
    int left = 0, right = nums.length - 1;
    while (right >= left) {
      int mid = left + (right - left) / 2;
      if (target == nums[mid]) {
        return true;
      }
      if (nums[left] == nums[mid]) {
        left++;
        continue;
      }
      //左侧有序
      if (nums[mid] > nums[left]) {
        if (target >= nums[left] && target < nums[mid]) {
          right = mid - 1;
        }else {
          left = mid + 1;
        }
      }

      ////左侧有序  注意测试用例:[3,1,1] 有right 和mid相等的情况
      if (nums[right] >= nums[mid]) {
        if (target > nums[mid] && target <= nums[right]) {
          left = mid + 1;
        }else {
          right = mid - 1;
        }
      }


    }
    return false;
  }
}
//leetcode submit region end(Prohibit modification and deletion)
