public class RotateArray {
  //给定一个数组，将数组中的元素向右移动 k 个位置，其中 k 是非负数。
//
// 示例 1:
//
// 输入: [1,2,3,4,5,6,7] 和 k = 3
//输出: [5,6,7,1,2,3,4]
//解释:
//向右旋转 1 步: [7,1,2,3,4,5,6]
//向右旋转 2 步: [6,7,1,2,3,4,5]
//向右旋转 3 步: [5,6,7,1,2,3,4]
//
//
// 示例 2:
//
// 输入: [-1,-100,3,99] 和 k = 2
//输出: [3,99,-1,-100]
//解释:
//向右旋转 1 步: [99,-1,-100,3]
//向右旋转 2 步: [3,99,-1,-100]
//
// 说明:
//
//
// 尽可能想出更多的解决方案，至少有三种不同的方法可以解决这个问题。
// 要求使用空间复杂度为 O(1) 的 原地 算法。
//
// Related Topics 数组
// 👍 691 👎 0


//leetcode submit region begin(Prohibit modification and deletion)

  // 时间复杂度 o(n)
// 空间复杂度 o(1)
  class Solution {
    public void rotate(int[] nums, int k) {
      int len = nums.length;
      //处理k比数组长度长的情况
      k = k % len;
      //len个元素要
      int count = 0;
      for (int start =0; count < len; start++) {
        int cur = start; // 从0位置开始换位子
        int prev = nums[cur]; //prev保存之前去到角落的元素,通过cur是不行的,因为nums[cur]已被赋值
        do {
          int next = (cur + k) % len;
          int temp = nums[next]; // 来到角落...
          nums[next] = prev; //赋值
          prev = temp; //上一个位置
          count++;
          cur = next;

        } while (start != cur); // 循环暂停，回到起始位置，
        // 角落无人 处理数组长度和k公约数不为1的情况
        //例如len = 4, k = 2 需要两次

      }

    }
  }


//leetcode submit region end(Prohibit modification and deletion)


}
