

//给你 n 个非负整数 a1，a2，...，an，每个数代表坐标中的一个点 (i, ai) 。在坐标内画 n 条垂直线，垂直线 i 的两个端点分别为 (i,
//ai) 和 (i, 0) 。找出其中的两条线，使得它们与 x 轴共同构成的容器可以容纳最多的水。
//
// 说明：你不能倾斜容器。
//
//
//
// 示例 1：
//
//
//
//
//输入：[1,8,6,2,5,4,8,3,7]
//输出：49
//解释：图中垂直线代表输入数组 [1,8,6,2,5,4,8,3,7]。在此情况下，容器能够容纳水（表示为蓝色部分）的最大值为 49。
//
// 示例 2：
//
//
//输入：height = [1,1]
//输出：1
//
//
// 示例 3：
//
//
//输入：height = [4,3,2,1,4]
//输出：16
//
//
// 示例 4：
//
//
//输入：height = [1,2,1]
//输出：2
//
//
//
//
// 提示：
//
//
// n = height.length
// 2 <= n <= 3 * 104
// 0 <= height[i] <= 3 * 104
//
// Related Topics 数组 双指针
// 👍 2056 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class 盛水最多的容器 {
//  每次选定围成水槽两板高度 h[i],h[j] 中的短板，向中间收敛 1格
//  为什么这么做？
//  无论i和j收敛,宽度w都会减小
//  如果移动高度高的,新的积水高度min(h[i],h[j]) ,可能变大，因此水槽面积 S(i,j) 可能增大
//  如果移动高度低的,水槽的短板 min(h[i],h[j])不变或变小，下个水槽的面积一定小于当前水槽面积。
//  所以一定低的 高度和宽度都会比当前积水少,所以没有必要移动
//双指针,两边夹逼
//   时间复杂度：O(N)，双指针总计最多遍历整个数组一次。
//    空间复杂度：O(1)，只需要额外的常数级别的空间。
  class Solution {
    public int maxArea(int[] height) {
      int i = 0, j = height.length - 1;
      int maxArea = 0;
      //注意i和j在同一位置,是不能存水的
      while (j > i) {
        int minH = height[i] > height[j] ? height[j--] : height[i++];
        //上面比较的时候,i或j已经改变,故这里j- i + 1
        maxArea = Math.max(maxArea, minH * (j - i + 1));
      }
      return maxArea;
    }
  }

  //自己想到的一种做法,跟接雨水一样,不断更新提升高度的可能
  public int maxArea(int[] height) {
    int left = 0, right = height.length - 1;
    int max_left = 0, max_right = 0;
    int area = 0;
    while (right > left) {
      max_left = Math.max(height[left], max_left);
      max_right = Math.max(height[right], max_right);
      if (max_right > max_left) {
        int h = max_left;
        int w = right - left;
        area = Math.max(area, h * w);
        left++;
      }else {
        int h = max_right;
        int w = right - left;
        area = Math.max(area, h * w);
        right--;
      }
    }
    return area;
  }
}
//leetcode submit region end(Prohibit modification and deletion)

