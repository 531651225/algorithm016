//给定 n 个非负整数，用来表示柱状图中各个柱子的高度。每个柱子彼此相邻，且宽度为 1 。
//
// 求在该柱状图中，能够勾勒出来的矩形的最大面积。
//
//
//
//
//
// 以上是柱状图的示例，其中每个柱子的宽度为 1，给定的高度为 [2,1,5,6,2,3]。
//
//
//
//
//
// 图中阴影部分为所能勾勒出的最大矩形面积，其面积为 10 个单位。
//
//
//
// 示例:
//
// 输入: [2,1,5,6,2,3]
//输出: 10
// Related Topics 栈 数组
// 👍 1067 👎 0


import java.util.LinkedList;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
  //暴力法,枚举每一个高度作为计算高度
  public int largestRectangleArea(int[] heights) {
    int area = 0;
    for (int i = 0; i < heights.length; i++) {
      int curHeight = heights[i];
      int left = i, right = i;
      while (left >= 0 && heights[left] >= curHeight) {
        --left;
      }
      while (right < heights.length && heights[right] >= curHeight) {
        ++right;
      }

      int curArea = curHeight * (right - left -1);
      area = Math.max(curArea, area);
    }
    return area;
  }
  //最优解单调栈
  public int largestRectangleArea(int[] heights) {
    Stack<Integer> s = new Stack();
    int len = heights.length;
    int res = 0;
    for (int i =0; i <= heights.length; i++) {
      int cur = (i == len) ? -1 : heights[i];
      while (!s.isEmpty() && heights[s.peek()] > cur) {
        int h = heights[s.pop()];
        int w = s.isEmpty() ? i : i - s.peek() -1;
        res = Math.max(res, h * w);
      }
      s.add(i);
    }
    return res;
  }
}
//leetcode submit region end(Prohibit modification and deletion)
