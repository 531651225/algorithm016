//一个机器人位于一个 m x n 网格的左上角 （起始点在下图中标记为“Start” ）。
//
// 机器人每次只能向下或者向右移动一步。机器人试图达到网格的右下角（在下图中标记为“Finish”）。
//
// 现在考虑网格中有障碍物。那么从左上角到右下角将会有多少条不同的路径？
//
//
//
// 网格中的障碍物和空位置分别用 1 和 0 来表示。
//
//
//
// 示例 1：
//
//
//输入：obstacleGrid = [[0,0,0],[0,1,0],[0,0,0]]
//输出：2
//解释：
//3x3 网格的正中间有一个障碍物。
//从左上角到右下角一共有 2 条不同的路径：
//1. 向右 -> 向右 -> 向下 -> 向下
//2. 向下 -> 向下 -> 向右 -> 向右
//
//
// 示例 2：
//
//
//输入：obstacleGrid = [[0,1],[0,0]]
//输出：1
//
//
//
//
// 提示：
//
//
// m == obstacleGrid.length
// n == obstacleGrid[i].length
// 1 <= m, n <= 100
// obstacleGrid[i][j] 为 0 或 1
//
// Related Topics 数组 动态规划
// 👍 468 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class 不同路径2 {
//  假设我们定义到达右下角的走法数为 f(m,n), 因为右下角只能由它上方或者左方的格子走过去，因此可以很容易的写出递归求解式，即 f(m,n)=f(m−1,n)+f(m,n−1)，最后加上递归终止条件，SO EASY 看起来大功告成啦！
//
//  然而事情并木有结束～ 因为这样自底向上的递归会存在大量的重复计算，所以我们将其改写为在二维数组中自顶向下的递推即可，即 dp[i,j]=dp[i−1,j]+dp[i,j−1]dp[i, j] = dp[i - 1, j] + dp[i, j - 1]dp[i,j]=dp[i−1,j]+dp[i,j−1]。
//      1、状态定义：
//
//  dp[i][j] 表示走到格子 (i,j) 的方法数。
//      2、状态转移：
//  3、初始条件
//
//  第 1 列的格子只有从其上边格子走过去这一种走法，因此初始化 dp[i][0] 值为 1，存在障碍物时为 0；
//
//  第 1 行的格子只有从其左边格子走过去这一种走法，因此初始化 dp[0][j] 值为 1，存在障碍物时为 0。
//
//  int m = obstacleGrid.length, n = obstacleGrid[0].length;
//  int[][] dp = new int[m][n];
//for (int i = 0; i < m && obstacleGrid[i][0] == 0; i++) {
//    dp[i][0] = 1;
//  }
//for (int j = 0; j < n && obstacleGrid[0][j] == 0; j++) {
//    dp[0][j] = 1;
//  }

//  https://leetcode-cn.com/problems/unique-paths-ii/solution/jian-dan-dpbi-xu-miao-dong-by-sweetiee/

  public int uniquePathsWithObstacles(int[][] obstacleGrid) {
    if(obstacleGrid.length == 0) {
      return 0;
    }
    int m = obstacleGrid.length;
    int n = obstacleGrid[0].length;
    int[][] dp = new int[m][n];
    for (int i = 0; i < m; i++) {
      if (obstacleGrid[i][0] == 1) {
        break;
      }
      dp[i][0] = 1;
    }

    for (int i = 0; i < n; i++) {
      if (obstacleGrid[0][i] == 1) {
        break;
      }
      dp[0][i] = 1;
    }
    for (int i = 1; i < m; i++) {
      for (int j = 1; j < n; j++) {
        if (obstacleGrid[i][j] != 1) {
          dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
        }
      }
    }
    return dp[m - 1][n - 1];

  }
}
//leetcode submit region end(Prohibit modification and deletion)

