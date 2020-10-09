

//给定不同面额的硬币 coins 和一个总金额 amount。编写一个函数来计算可以凑成总金额所需的最少的硬币个数。如果没有任何一种硬币组合能组成总金额，返回
// -1。
//
// 你可以认为每种硬币的数量是无限的。
//
//
//
// 示例 1：
//
// 输入：coins = [1, 2, 5], amount = 11
//输出：3
//解释：11 = 5 + 5 + 1
//
// 示例 2：
//
// 输入：coins = [2], amount = 3
//输出：-1
//
// 示例 3：
//
// 输入：coins = [1], amount = 0
//输出：0
//
//
// 示例 4：
//
// 输入：coins = [1], amount = 1
//输出：1
//
//
// 示例 5：
//
// 输入：coins = [1], amount = 2
//输出：2
//
//
//
//
// 提示：
//
//
// 1 <= coins.length <= 12
// 1 <= coins[i] <= 231 - 1
// 0 <= amount <= 231 - 1
//
// Related Topics 动态规划
// 👍 855 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
//即组成金额 S 最少的硬币数，最后一枚硬币的面值是 C。那么由于问题的最优子结构，转移方程应为：
//1.子问题 sum -> sub(sum - k) + 1
//2.dp数组定义 dp[i] = dp[i - k] + 1,组成总金额为i的最小硬币数
//3.状态方程 dp[i] = dp[i - k] + 1

//时间复杂度：O(Sn)，其中 S 是金额，n 是面额数。我们一共需要计算 O(S) 个状态，S
// 为题目所给的总金额。
// 对于每个状态，每次需要枚举 n 个面额来转移状态，所以一共需要 O(Sn) 的时间复杂度。
//空间复杂度：O(S)。DP 数组需要开长度为总金额 S 的空间。

class CoinChange {
//    public int coinChange(int[] coins, int amount) {
//        int[] dp = new int[amount + 1];
//        Arrays.fill(dp, amount + 1);
//        dp[0] = 0;
//
//        for (int i = 1; i <= amount; i++) {
//            for (int j = 0; j < coins.length; j++) {
//                int money = coins[j];
//                if (i >= money) {
//                    dp[i] = Math.min(dp[i], dp[i - money] + 1);
//                }
//            }
//        }
//        return dp[amount] == amount + 1 ? -1 : dp[amount];
//    }

  public static int coinChange(int[] coins, int amount) {
    if(amount<1) return 0;
    return recur(coins, amount, new int[amount]);
  }

  static int  recur(int[] coins, int amount, int[] memo) {
    if (amount == 0) return 0;
    //没有能组成金额的硬币组合

    if (amount < 0) return -1;
    if (memo[amount - 1] != 0) return memo[amount - 1];
    int min = Integer.MAX_VALUE;
    for (int coin : coins) {
//            if (amount >= coin) {
      int res = recur(coins, amount - coin, memo);
      if (res != -1) {
        min = Math.min(res + 1, min);
//                }
      }
    }

    if (min != Integer.MAX_VALUE) {
      memo[amount - 1] = min;
    }
    memo[amount - 1] = min == Integer.MAX_VALUE ? -1 : min;
    return memo[amount - 1];

  }

  public static void main(String[] args) {
    System.out.println(coinChange(new int[]{2}, 3));;
  }
}
//leetcode submit region end(Prohibit modification and deletion)

