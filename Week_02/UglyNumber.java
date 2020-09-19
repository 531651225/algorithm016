//我们把只包含质因子 2、3 和 5 的数称作丑数（Ugly Number）。求按从小到大的顺序的第 n 个丑数。
//
//
//
// 示例:
//
// 输入: n = 10
//输出: 12
//解释: 1, 2, 3, 4, 5, 6, 8, 9, 10, 12 是前 10 个丑数。
//
// 说明:
//
//
// 1 是丑数。
// n 不超过1690。
//
//
// 注意：本题与主站 264 题相同：https://leetcode-cn.com/problems/ugly-number-ii/
// Related Topics 数学
// 👍 72 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
// 时间复杂度 o(n)
// 空间复杂度 o(n)
class UglyNumber {
  public int nthUglyNumber(int n) {
    int a = 0, b = 0, c = 0;
    int[] dp = new int[n];
    dp[0] = 1;
    for (int i = 1; i < n; i++) {
      dp[i] = Math.min(Math.min(dp[a] * 2, dp[b] * 3), dp[c] * 5);
      if (dp[i] == dp[a] * 2) {
        a++;
      }
      if (dp[i] == dp[b] * 3) {
        b++;
      }
      if (dp[i] == dp[c] * 5) {
        c++;
      }
    }
    return dp[n - 1];
  }

  // 时间复杂度 o(n)
  // 空间复杂度 o(nlogn)
  //小根堆
//    public int nthUglyNumber(int n) {
//        int count = 0;
//        PriorityQueue<Long> que = new PriorityQueue(new Comparator<Long>(){
//            @Override
//            public int compare(Long n1, Long n2){
//                return n1.compareTo(n2);
//            }
//        });
//        int [] nums= new int[] {2, 3, 5};
//        que.offer(1L);
//        while(!que.isEmpty()) {
//            long cur = que.poll();
//            if (count++ == n - 1) return (int) cur;
//            for (int num : nums) {
//                if (! que.contains(num * cur)) {
//                    que.offer(num * cur);
//                }
//            }
//        }
//        return -1;
//    }

}
//leetcode submit region end(Prohibit modification and deletion)
