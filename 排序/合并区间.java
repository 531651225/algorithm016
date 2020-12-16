//给出一个区间的集合，请合并所有重叠的区间。
//
//
//
// 示例 1:
//
// 输入: intervals = [[1,3],[2,6],[8,10],[15,18]]
//输出: [[1,6],[8,10],[15,18]]
//解释: 区间 [1,3] 和 [2,6] 重叠, 将它们合并为 [1,6].
//
//
// 示例 2:
//
// 输入: intervals = [[1,4],[4,5]]
//输出: [[1,5]]
//解释: 区间 [1,4] 和 [4,5] 可被视为重叠区间。
//
// 注意：输入类型已于2019年4月15日更改。 请重置默认代码定义以获取新方法签名。
//
//
//
// 提示：
//
//
// intervals[i][0] <= intervals[i][1]
//
// Related Topics 排序 数组
// 👍 727 👎 0


import java.util.Arrays;

//leetcode submit region begin(Prohibit modification and deletion)
class 合并区间 {

  public int[][] merge(int[][] intervals) {
    Arrays.sort(intervals, new Comparator<int[]>() {
      @Override
      public int compare (int[] a1, int[] a2){
        return a1[0] - a2[0];
      }
    });
    List<int[]> list=new ArrayList();
    list.add(intervals[0]);
    for (int i=1; i < intervals.length; i++) {
      int[] last=list.get(list.size() - 1);
      if (intervals[i][0] <= last[1]) {
        last[1] = Math.max(intervals[i][1], last[1]);
      } else {
        list.add(intervals[i]);
      }
    }
    return list.toArray(new int[list.size()][]);
  }
}

//leetcode submit region end(Prohibit modification and deletion)

