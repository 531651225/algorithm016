//实现 pow(x, n) ，即计算 x 的 n 次幂函数。
//
// 示例 1:
//
// 输入: 2.00000, 10
//输出: 1024.00000
//
//
// 示例 2:
//
// 输入: 2.10000, 3
//输出: 9.26100
//
//
// 示例 3:
//
// 输入: 2.00000, -2
//输出: 0.25000
//解释: 2-2 = 1/22 = 1/4 = 0.25
//
// 说明:
//
//
// -100.0 < x < 100.0
// n 是 32 位有符号整数，其数值范围是 [−231, 231 − 1] 。
//
// Related Topics 数学 二分查找
// 👍 500 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
//时间复杂度：O(log⁡n)，即为递归的层数。二分的时间复杂度为对数级别
//空间复杂度：O(log⁡n)，即为递归的层数。这是由于递归的函数调用会使用栈空间。

class PowxN {
  public double myPow(double x, int n) {
    if (n < 0) {
      return 1 / pow(x, -n);
    }else {
      return pow(x, n);
    }
  }

  private double pow (double x, int n) {
    if (n == 0) return 1D;
    if (n % 2 == 0) {
      double num = pow(x,n / 2);
      return num * num;
    }else {
      double num = pow(x,n / 2);
      return num * num * x;
    }
  }
}
//leetcode submit region end(Prohibit modification and deletion)

