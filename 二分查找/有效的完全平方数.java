//给定一个正整数 num，编写一个函数，如果 num 是一个完全平方数，则返回 True，否则返回 False。
//
// 说明：不要使用任何内置的库函数，如 sqrt。
//
// 示例 1：
//
// 输入：16
//输出：True
//
// 示例 2：
//
// 输入：14
//输出：False
//
// Related Topics 数学 二分查找
// 👍 181 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class 有效的完全平方数 {
  public boolean isPerfectSquare(int num) {
    if (num <= 1) return true;
    long left = 1, right = num / 2;
    while (right >= left) {
      long mid = left + (right - left) / 2;
      if (mid * mid > num) {
        right = mid - 1;
      } else if (mid * mid < num) {
        left = mid + 1;
      } else {
        return true;
      }
    }
    return false;

  }
}
//leetcode submit region end(Prohibit modification and deletion)

