public class  {

}

//给你一个由 '1'（陆地）和 '0'（水）组成的的二维网格，请你计算网格中岛屿的数量。
//
// 岛屿总是被水包围，并且每座岛屿只能由水平方向和/或竖直方向上相邻的陆地连接形成。
//
// 此外，你可以假设该网格的四条边均被水包围。
//
//
//
// 示例 1：
//
//
//输入：grid = [
//  ["1","1","1","1","0"],
//  ["1","1","0","1","0"],
//  ["1","1","0","0","0"],
//  ["0","0","0","0","0"]
//]
//输出：1
//
//
// 示例 2：
//
//
//输入：grid = [
//  ["1","1","0","0","0"],
//  ["1","1","0","0","0"],
//  ["0","0","1","0","0"],
//  ["0","0","0","1","1"]
//]
//输出：3
//
//
//
//
// 提示：
//
//
// m == grid.length
// n == grid[i].length
// 1 <= m, n <= 300
// grid[i][j] 的值为 '0' 或 '1'
//
// Related Topics 深度优先搜索 广度优先搜索 并查集
// 👍 891 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class 岛屿数量 {
  public int numIslands(char[][] grid) {
    int row = grid.length;
    if (row == 0) return 0;
    int col = grid[0].length;
    int count = 0;
//遍历所有网格,如果为1 就计数count
    for (int i = 0; i < row; i++) {
      for (int j = 0; j < col; j++) {
        if (grid[i][j] == '1') {
          count++;
          //向此节点的前后左右错深度遍历
          dfs(grid, i, j, row, col);
        }
      }
    }
    return count;

  }


  //时间复杂度 o(mn) m和n分别为行数和列数
//空间复杂度 o(nm) 最坏情况下,整个网格均为陆地,深度优先搜索的深度达到mn
  void dfs (char[][] grid, int i , int j, int row, int col) {
    if (i >= row || i < 0 || j >= col || j < 0 || grid[i][j] == '0') return;
    //将为1的网格置为0,避免重复搜索
    grid[i][j] = '0';
    dfs(grid, i + 1, j, row, col);
    dfs(grid, i - 1, j, row, col);
    dfs(grid, i, j + 1, row, col);
    dfs(grid, i, j - 1, row, col);

  }

  //时间复杂度 o(MN) m和n分别为行数和列数 最坏情况搜索所有节点
  //空间复杂度 o(min(m,n)) 在最坏情况下,整个网格均为陆地,队列大小达到o(min(m,n))
  //广度优先遍历
  void bfs (char[][] grid, int row, int col, int i, int j) {
    LinkedList<int[]> que = new LinkedList<>();
    if (i >= row || j >= col || i < 0 || j < 0 || grid[i][j] == '0') return;  //不加也行
    que.addFirst(new int[]{i, j});
    while (!que.isEmpty()) {
      int[] arr = que.removeLast();
      i = arr[0];
      j = arr[1];
      if (i >= row || j >= col || i < 0 || j < 0 || grid[i][j] == '0') continue;
      grid[i][j] = '0';
      que.addFirst(new int[]{i, j + 1});
      que.addFirst(new int[]{i, j - 1});
      que.addFirst(new int[]{i + 1, j});
      que.addFirst(new int[]{i - 1, j});
    }
}
//leetcode submit region end(Prohibit modification and deletion)

