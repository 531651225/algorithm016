//给定 n 个非负整数表示每个宽度为 1 的柱子的高度图，计算按此排列的柱子，下雨之后能接多少雨水。
//
//
//
// 上面是由数组 [0,1,0,2,1,0,1,3,2,1,2,1] 表示的高度图，在这种情况下，可以接 6 个单位的雨水（蓝色部分表示雨水）。 感谢 Mar
//cos 贡献此图。
//
// 示例:
//
// 输入: [0,1,0,2,1,0,1,3,2,1,2,1]
//输出: 6
// Related Topics 栈 数组 双指针
// 👍 1644 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class TrappingRainWater {

//  //单调栈：用stack保存每个柱子,当前柱子小于栈顶,说明会出现积水,入栈.当前柱子大于柱子,说明积水到这停下,出栈并触发计算雨水
//  //时间复杂度： O(n)虽然 while 循环里套了一个 while 循环，但是考虑到每个元素最多访问两次，入栈一次和出栈一次，所以时间复杂度是
//  //空间复杂度：O(n)。栈的空间
//  public int trap(int[] height) {
//    int len = height.length, res = 0;
//    LinkedList<Integer> stack = new LinkedList();
//    for (int i = 0; i < height.length; i++) {
//      while (!stack.isEmpty() && height[i] > height[stack.getLast()]) {
//        int cur = stack.removeLast();
//        // 如果栈顶元素一直相等，那么全都pop出去，只留第一个
//        while (!stack.isEmpty() && height[stack.getLast()] == height[cur]) {
//          stack.removeLast();
//        }
//        if (stack.isEmpty()) {
//          break;
//        }
//        int l = stack.getLast();
//        int w = i - l - 1;
//        int minHeight = Math.min(height[i], height[l]);
//        int area = (minHeight - height[cur]) * w;
//        res += area;
//      }
//      stack.addLast(i);
//
//    }
//    return res;
//  }

  // o(N)
  // o(1)
  //最优解,双指针
  public int trap(int[] height) {
    int res = 0;
    int left = 0, right = height.length-1;
    int maxRight = 0;
    int maxLeft = 0;
    while (right > left) {
      maxLeft = Math.max(height[left], maxLeft);
      maxRight = Math.max(height[right], maxRight);
      if (maxLeft > maxRight) {
        res += maxRight - height[right--];
      }else {
        res += maxLeft - height[left++];
      }
    }
    return res;
  }

  // o(n2)
  // o(1)
  //暴力解法
//  public int trap(int[] height) {
//    int res = 0;
//    //遍历当前柱子高度
//    for (int i = 0; i < height.length; i++) {
//      int maxLeft = 0, maxRight = 0;
//      //找到当前柱子左面最高的柱子
//      for (int left = 0; left <= i; left++) {
//        maxLeft = Math.max(height[left], maxLeft);
//      }
//      //找到当前柱子右面最高的柱子
//      for (int right = height.length -1; right >= i; right--) {
//        maxRight = Math.max(height[right], maxRight);
//      }
//      //左右最小高度-当前 作为当前积水量
//      res += Math.min(maxLeft, maxRight) - height[i];
//    }
//    return res;
//  }




}
