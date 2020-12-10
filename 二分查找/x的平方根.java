//实现 int sqrt(int x) 函数。
//
// 计算并返回 x 的平方根，其中 x 是非负整数。
//
// 由于返回类型是整数，结果只保留整数的部分，小数部分将被舍去。
//
// 示例 1:
//
// 输入: 4
//输出: 2
//
//
// 示例 2:
//
// 输入: 8
//输出: 2
//说明: 8 的平方根是 2.82842...,
//     由于返回类型是整数，小数部分将被舍去。
//
// Related Topics 数学 二分查找
// 👍 553 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class x的平方根 {
  public int mySqrt(int x) {
    if(x == 0 || x == 1) return x;

    long left = 1, right = x / 2, ans = 1;
    while (right >= left) {
      long mid = left + (right - left) / 2;
      if (mid * mid > x) {
        right = mid - 1;
      } else if (mid * mid <= x) {
        left = mid + 1;
        ans = mid;
      }
    }
    return (int)ans;
  }
}
//leetcode submit region end(Prohibit modification and deletion)

