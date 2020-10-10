//你是一个专业的小偷，计划偷窃沿街的房屋，每间房内都藏有一定的现金。这个地方所有的房屋都围成一圈，这意味着第一个房屋和最后一个房屋是紧挨着的。同时，相邻的房屋
//装有相互连通的防盗系统，如果两间相邻的房屋在同一晚上被小偷闯入，系统会自动报警。
//
// 给定一个代表每个房屋存放金额的非负整数数组，计算你在不触动警报装置的情况下，能够偷窃到的最高金额。
//
// 示例 1:
//
// 输入: [2,3,2]
//输出: 3
//解释: 你不能先偷窃 1 号房屋（金额 = 2），然后偷窃 3 号房屋（金额 = 2）, 因为他们是相邻的。
//
//
// 示例 2:
//
// 输入: [1,2,3,1]
//输出: 4
//解释: 你可以先偷窃 1 号房屋（金额 = 1），然后偷窃 3 号房屋（金额 = 3）。
//     偷窃到的最高金额 = 1 + 3 = 4 。
// Related Topics 动态规划
// 👍 390 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class 打家劫舍2 {
  //因为首位的房屋是不能同时盗窃,所以要么盗窃第一个,要么盗窃最后一个.分两种情况 取最大.
  //时间复杂度 o(n)
  //空间复杂度 o(n)
  public int rob(int[] nums) {
    if (nums == null || nums.length == 0 ) {
      return 0;
    }
    if (nums.length == 1) {
      return nums[0];
    }

    return Math.max(rob(nums, 0, nums.length - 2), rob(nums, 1, nums.length - 1));

  }

  private int rob(int[] nums, int start, int end) {
    if (start == end) {
      return nums[start];
    }
    int[] dp = new int [nums.length];
    dp[start] = nums[start];
    dp[start + 1] = Math.max(nums[start], nums[start + 1]);
    for (int i = start + 2 ; i <= end; i++) {
      dp[i] = Math.max(dp[i - 2] + nums[i], dp[i - 1]);
    }
    return dp[end];
  }


  //时间复杂度 o(n)
  //空间复杂度 o(1) 使用滚动数组,空间降为1
  public int rob(int[] nums) {
    if (nums == null || nums.length == 0 ) {
      return 0;
    }
    if (nums.length == 1) {
      return nums[0];
    }

    return Math.max(rob(nums, 0, nums.length - 2), rob(nums, 1, nums.length - 1));

  }

  private int rob(int[] nums, int start, int end) {
    if (start == end) {
      return nums[start];
    }
    int[] dp = new int [nums.length];
    int first = nums[start], sec = dp[start + 1] = Math.max(nums[start], nums[start + 1]),
        third = 0;
    for (int i = start + 2 ; i <= end; i++) {
      third = Math.max(first + nums[i], sec);
      first = sec;
      sec = third;
    }
    return sec;
  }
}
//leetcode submit region end(Prohibit modification and deletion)

