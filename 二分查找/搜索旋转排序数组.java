
//给你一个整数数组 nums ，和一个整数 target 。
//
// 该整数数组原本是按升序排列，但输入时在预先未知的某个点上进行了旋转。（例如，数组 [0,1,2,4,5,6,7] 可能变为 [4,5,6,7,0,1,2]
// ）。
//
// 请你在数组中搜索 target ，如果数组中存在这个目标值，则返回它的索引，否则返回 -1 。
//
//
// 示例 1：
//
//
//输入：nums = [4,5,6,7,0,1,2], target = 0
//输出：4
//
//
// 示例 2：
//
//
//输入：nums = [4,5,6,7,0,1,2], target = 3
//输出：-1
//
// 示例 3：
//
//
//输入：nums = [1], target = 0
//输出：-1
//
//
//
//
// 提示：
//
//
// 1 <= nums.length <= 5000
// -10^4 <= nums[i] <= 10^4
// nums 中的每个值都 独一无二
// nums 肯定会在某个点上旋转
// -10^4 <= target <= 10^4
//
// Related Topics 数组 二分查找
// 👍 1092 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class 搜索旋转排序数组 {

//  其思想是，当旋转数组时，必须有一半数组仍然是有序的。
//  例如，6 7 1 2 3 4 5，顺序从7到1之间被打乱。所以当进行二分查找时，我们可以判断哪一部分是有序的以及目标是否在这个范围内，如果是，继续在这一半搜索，如果不继续在另一半搜索。

// 1.//左边正序,mid == left 情况
//   2   5
//          mid = 0  target = 3
//   left = mid + 1

// //左边正序,但是tar不在左边情况
//    5   6    2
//          mid = 1  target = 3

// //右边正序,但是tar不在与右边情况
//     7    3    5    mid = 1，tar = 2
//          mid = 1  target = 3



  public int search(int[] nums, int target) {

    int left = 0, right = nums.length - 1;
    while (right >= left) {

      //防止溢出

      int mid = left + (right - left) / 2;
      if (nums[mid] == target) {
        return mid;
      }


      //左边正序
//      注意nums[mid] >= nums[left]条件,其中=条件,要拿数据测试下边界 例如 1  0  tar =0,mid = 0
      if (nums[mid] >= nums[left]) {
        //target在正序那一边,常规操作
        if (target >= nums[left] && target < nums[mid]) {
          right = mid -1;
        }else {
          left = mid + 1;
        }

      }
      //右边有序
      if (nums[mid] < nums[right]){
        //target在正序那一边
        if (target > nums[mid] && target <= nums[right])
          left = mid + 1;
        //target不在正序那一边
      }else {
        right = mid - 1;
      }

    }
    return -1;

  }
}

//leetcode submit region end(Prohibit modification and deletion)

