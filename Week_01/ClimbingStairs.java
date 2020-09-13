public class ClimbingStairs {

  //假设你正在爬楼梯。需要 n 阶你才能到达楼顶。
//
// 每次你可以爬 1 或 2 个台阶。你有多少种不同的方法可以爬到楼顶呢？
//
// 注意：给定 n 是一个正整数。
//
// 示例 1：
//
// 输入： 2
//输出： 2
//解释： 有两种方法可以爬到楼顶。
//1.  1 阶 + 1 阶
//2.  2 阶
//
// 示例 2：
//
// 输入： 3
//输出： 3
//解释： 有三种方法可以爬到楼顶。
//1.  1 阶 + 1 阶 + 1 阶
//2.  1 阶 + 2 阶
//3.  2 阶 + 1 阶
//
// Related Topics 动态规划
// 👍 1223 👎 0


  //dp[i] 只与 dp[i-1] 和 dp[i-2] 有关，
  // 没有必要存储所有计算过的 dp 项。用两个临时变量去存这两个状态就好
  //时间复杂度
  //空间复杂度 o(1)
  class Solution {

    public int climbStairs(int n) {
      if (n == 1) {
        return 1;
      }
      int first = 1;
      int sec = 2;
      for (int i = 3; i <= n; i++) {
        int third = first + sec;
        first = sec;
        sec = third;
      }
      return sec;
    }
//    public int climbStairs(int n) {
//        if (n == 1) {
//            return 1;
//        }
//        int[] dp = new int[n + 1];
//        dp[1] = 1;
//        dp[2] = 2;
//        for(int i = 3; i <= n; i++) {
//            dp[i] = dp[i - 2] + dp[i -1];
//        }
//        return dp[n];
//
//    }
  }
//leetcode submit region end(Prohibit modification and deletion)

}
