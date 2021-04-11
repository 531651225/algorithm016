
//给定一个非负整数数组 A，返回一个数组，在该数组中， A 的所有偶数元素之后跟着所有奇数元素。
//
// 你可以返回满足此条件的任何数组作为答案。
//
//
//
// 示例：
//
// 输入：[3,1,2,4]
//输出：[2,4,3,1]
//输出 [4,2,3,1]，[2,4,1,3] 和 [4,2,1,3] 也会被接受。
//
//
//
//
// 提示：
//
//
// 1 <= A.length <= 5000
// 0 <= A[i] <= 5000
//
// Related Topics 数组
// 👍 191 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class 按奇偶排序数组 {
  public int[] sortArrayByParity(int[] A) {
    int[] arr = new int[A.length];
    int count = 0,  odd = A.length - 1,  even = 0;
    for (int i = 0; i < A.length; i++) {
      if(A[i] % 2 == 0) {
        arr[even++] = A[i];
      }

      if(A[i] % 2 == 1) {
        arr[odd--] = A[i];
      }

    }
    return arr;
  }
}
//leetcode submit region end(Prohibit modification and deletion)

