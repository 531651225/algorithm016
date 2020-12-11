//编写一个高效的算法来搜索 m x n 矩阵 matrix 中的一个目标值 target 。该矩阵具有以下特性：
//
//
// 每行的元素从左到右升序排列。
// 每列的元素从上到下升序排列。
//
//
//
//
// 示例 1：
//
//
//输入：matrix = [[1,4,7,11,15],[2,5,8,12,19],[3,6,9,16,22],[10,13,14,17,24],[18,21
//,23,26,30]], target = 5
//输出：true
//
//
// 示例 2：
//
//
//输入：matrix = [[1,4,7,11,15],[2,5,8,12,19],[3,6,9,16,22],[10,13,14,17,24],[18,21
//,23,26,30]], target = 20
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
// 1 <= n, m <= 300
// -109 <= matix[i][j] <= 109
// 每行的所有元素从左到右升序排列
// 每列的所有元素从上到下升序排列
// -109 <= target <= 109
//
// Related Topics 二分查找 分治算法
// 👍 492 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class 搜索二维矩阵2 {
  public boolean searchMatrix(int[][] matrix, int target) {
    int row = 0, col = matrix[0].length - 1;
    while (row < matrix.length && col >= 0) {
      if (target > matrix[row][col]) {
        row++;
      } else if (target < matrix[row][col]) {
        col--;
      } else {
        return true;
      }
    }
    return false;
  }

//    boolean find(int[] matrix, int target){
//        int left = 0, right = matrix.length - 1;
//        while (right >= left) {
//            int mid = left + (right - left) / 2;
//            if (matrix[mid] < target) {
//                left = mid + 1;
//            } else if (matrix[mid] > target) {
//                right = mid - 1;
//            } else {
//                return true;
//            }
//        }
//        return false;
//
//    }
}


//leetcode submit region end(Prohibit modification and deletion)

