
//编写一个高效的算法来判断 m x n 矩阵中，是否存在一个目标值。该矩阵具有如下特性：
//
//
// 每行中的整数从左到右按升序排列。
// 每行的第一个整数大于前一行的最后一个整数。
//
//
//
//
// 示例 1：
//
//
//输入：matrix = [[1,3,5,7],[10,11,16,20],[23,30,34,50]], target = 3
//输出：true
//
//
// 示例 2：
//
//
//输入：matrix = [[1,3,5,7],[10,11,16,20],[23,30,34,50]], target = 13
//输出：false
//
//
// 示例 3：
//
//
//输入：matrix = [], target = 0
//输出：false
//
//
//
//
// 提示：
//
//
// m == matrix.length
// n == matrix[i].length
// 0 <= m, n <= 100
// -104 <= matrix[i][j], target <= 104
//
// Related Topics 数组 二分查找
// 👍 285 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class 搜索二维矩阵 {
//    时间复杂度 : 由于是标准的二分查找,时间复杂度为O(log⁡(mn))
//    空间复杂度 : O(1)
//    //将二维处当做一维处理
    public boolean searchMatrix(int[][] matrix, int target) {
      if (matrix.length == 0 || matrix[0].length == 0) {
        return false;
      }
      int rowl = matrix.length;
      int coll = matrix[0].length;
      int len = rowl * coll;
      int left = 0, right = len - 1;
      while (right >= left) {
        int mid = left + (right - left) / 2;
        int row = mid / coll;
        int col = mid % coll;
        if (target > matrix[row][col]) {
          left = mid + 1;
        } else if (target < matrix[row][col]) {
          right = mid - 1;
        } else {
          return true;
        }
      }
      return false;

    }
}
//leetcode submit region end(Prohibit modification and deletion)

