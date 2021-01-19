//
//
// 有 n 个城市，其中一些彼此相连，另一些没有相连。如果城市 a 与城市 b 直接相连，且城市 b 与城市 c 直接相连，那么城市 a 与城市 c 间接相连
//。
//
// 省份 是一组直接或间接相连的城市，组内不含其他没有相连的城市。
//
// 给你一个 n x n 的矩阵 isConnected ，其中 isConnected[i][j] = 1 表示第 i 个城市和第 j 个城市直接相连，而
//isConnected[i][j] = 0 表示二者不直接相连。
//
// 返回矩阵中 省份 的数量。
//
//
//
// 示例 1：
//
//
//输入：isConnected = [[1,1,0],[1,1,0],[0,0,1]]
//输出：2
//
//
// 示例 2：
//
//
//输入：isConnected = [[1,0,0],[0,1,0],[0,0,1]]
//输出：3
//
//
//
//
// 提示：
//
//
// 1 <= n <= 200
// n == isConnected.length
// n == isConnected[i].length
// isConnected[i][j] 为 1 或 0
// isConnected[i][i] == 1
// isConnected[i][j] == isConnected[j][i]
//
//
//
// Related Topics 深度优先搜索 并查集
// 👍 474 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class 省份数量 {
//    可以把 n 个城市和它们之间的相连关系看成图，城市是图中的节点，相连关系是图中的边，给定的矩阵 isConnected即为图的邻接矩阵，省份即为图中的连通分量。
//
//    计算省份总数，等价于计算图中的连通分量数，可以通过深度优先搜索或广度优先搜索实现，也可以通过并查集实现。
//    方法一：深度优先搜索
//
//    深度优先搜索的思路是很直观的。遍历所有城市，对于每个城市，如果该城市尚未被访问过，则从该城市开始深度优先搜索，通过矩阵 isConnected
//    得到与该城市直接相连的城市有哪些，这些城市和该城市属于同一个连通分量，然后对这些城市继续深度优先搜索，直到同一个连通分量的所有城市都被访问到，即可得到一个省份。遍历完全部城市以后，即可得到连通分量的总数，即省份的总数

//    时间复杂度：O(n2)，其中 n 是城市的数量。需要遍历矩阵 nnn 中的每个元素。
//    空间复杂度：O(n)，其中 n 是城市的数量。需要使用数组 visited 记录每个城市是否被访问过，数组长度是 n，递归调用栈的深度不会超过 n。


  public int findCircleNum(int[][] grid) {

    int m = grid.length;
    int count = 0;
    boolean[] visit = new boolean[m];
    for (int i = 0; i < m; i++) {
      if(!visit[i]) {
        count++;
        dfs(grid, visit, i);
      }
    }
    return count;
  }
  void dfs(int[][] grid, boolean[] visit, int position) {
    for (int i = 0; i < visit.length; i++) {
      if(grid[i][position] == 1 && !visit[i]){
        visit[i] = true;
        dfs(grid, visit, i);
      }
    }
  }


//----------------------并查集-------------------

  class UnionFind {
    private int count = 0;
    private int[] parent;

    public UnionFind(int n) {
      count = n;
      parent = new int[n];
      for (int i = 0; i < n; i++) {
        parent[i] = i;
      }
    }

    public int find(int p) {
      while (p != parent[p]) {
        parent[p] = parent[parent[p]];
        p = parent[p];
      }
      return p;
    }

    public void union(int p, int q) {
      int rootP = find(p);
      int rootQ = find(q);
      if (rootP == rootQ) return;
      parent[rootP] = rootQ;
      count--;
    }

  }

  public int findCircleNum(int[][] isConnected) {
    int m = isConnected.length;
    if(m == 0) return 0;
    int n = isConnected[0].length;
    UnionFind u = new UnionFind(m);
    for (int i = 0; i < m; i++) {
      for (int j = 0; j < n; j++) {
        if(isConnected[i][j] == 1) {
          u.union(i, j);
        }
      }
    }
    return u.count;
  }

}
//leetcode submit region end(Prohibit modification and deletion)

