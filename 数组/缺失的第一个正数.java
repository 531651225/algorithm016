//给你一个未排序的整数数组 nums ，请你找出其中没有出现的最小的正整数。
//
//
//
// 进阶：你可以实现时间复杂度为 O(n) 并且只使用常数级别额外空间的解决方案吗？
//
//
//
// 示例 1：
//
//
//输入：nums = [1,2,0]
//输出：3
//
//
// 示例 2：
//
//
//输入：nums = [3,4,-1,1]
//输出：2
//
//
// 示例 3：
//
//
//输入：nums = [7,8,9,11,12]
//输出：1
//
//
//
//
// 提示：
//
//
// 0 <= nums.length <= 300
// -231 <= nums[i] <= 231 - 1
//
// Related Topics 数组
// 👍 916 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class 缺失的第一个正数 {
//    public int firstMissingPositive(int[] nums) {
//        HashSet<Integer> set = new HashSet();
//        for(int i = 0;i < nums.length; i++) {
//           set.add(nums[i]);
//        }
//       for (int i = 1; i <= nums.length; i++) {
//            if(!set.contains(i)) {
//                return i;
//            }
//       }
//       return nums.length + 1;
//
//    }

  public int firstMissingPositive(int[] nums) {
    for (int i = 0; i < nums.length; i++) {
      while(nums[i] >= 1 && nums[i] <= nums.length && nums[i] != nums[nums[i] - 1]) {
        swap(nums, i, nums[i] - 1);
      }
    }
    for (int i = 0; i < nums.length; i++) {
      if(nums[i] != i + 1) {
        return i + 1;
      }
    }
    return nums.length + 1;
  }


  void swap(int[] nums, int i, int j) {
    int temp = nums[i];
    nums[i] = nums[j];
    nums[j] = temp;
  }




}




//leetcode submit region end(Prohibit modification and deletion)

//    public int firstMissingPositive(int[] nums) {
//        int n = nums.length;
//        for (int i = 0; i < n; ++i) {
//            if (nums[i] <= 0) {
//                nums[i] = n + 1;
//            }
//        }
//        for (int i = 0; i < n; ++i) {
//            int num = Math.abs(nums[i]);
//            if (num <= n) {
//                nums[num - 1] = -Math.abs(nums[num - 1]);
//            }
//        }
//        for (int i = 0; i < n; ++i) {
//            if (nums[i] > 0) {
//                return i + 1;
//            }
//        }
//        return n + 1;
//    }



