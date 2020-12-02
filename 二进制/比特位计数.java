//给定一个非负整数 num。对于 0 ≤ i ≤ num 范围中的每个数字 i ，计算其二进制数中的 1 的数目并将它们作为数组返回。
//
// 示例 1:
//
// 输入: 2
//输出: [0,1,1]
//
// 示例 2:
//
// 输入: 5
//输出: [0,1,1,2,1,2]
//
// 进阶:
//
//
// 给出时间复杂度为O(n*sizeof(integer))的解答非常容易。但你可以在线性时间O(n)内用一趟扫描做到吗？
// 要求算法的空间复杂度为O(n)。
// 你能进一步完善解法吗？要求在C++或任何其他语言中不使用任何内置函数（如 C++ 中的 __builtin_popcount）来执行此操作。
//
// Related Topics 位运算 动态规划
// 👍 454 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class 比特位计数 {
  //https://leetcode-cn.com/problems/counting-bits/solution/bi-te-wei-ji-shu-by-leetcode/

//    public int[] countBits(int num) {
//        int[] arr = new int[num + 1];
//        for (int i = 0; i <= num; i++) {
//            int count = 0;
//            int index = i;
//            while (index != 0) {
//                index = index & (index - 1);
//                count++;
//            }
//            arr[i] = count;
//        }
//        return arr;
//    }

  //动态规划
  //状态转移方程: dp[i] 代表数字i中位1的个数，dp[i] = dp[i & (i - 1)] + 1; i去除低位1中1的个数 + 1
  public int[] countBits(int num) {
    int[] dp = new int[num + 1];
    for (int i = 1; i <= num; i++) {
      dp[i] = dp[i & (i - 1)] + 1;
    }
    return dp;
  }
}
//leetcode submit region end(Prohibit modification and deletion)
