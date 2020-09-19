import java.util.HashMap;

//给定一个非空的整数数组，返回其中出现频率前 k 高的元素。
//
//
//
// 示例 1:
//
// 输入: nums = [1,1,1,2,2,3], k = 2
//输出: [1,2]
//
//
// 示例 2:
//
// 输入: nums = [1], k = 1
//输出: [1]
//
//
//
// 提示：
//
//
// 你可以假设给定的 k 总是合理的，且 1 ≤ k ≤ 数组中不相同的元素的个数。
// 你的算法的时间复杂度必须优于 O(n log n) , n 是数组的大小。
// 题目数据保证答案唯一，换句话说，数组中前 k 个高频元素的集合是唯一的。
// 你可以按任意顺序返回答案。
//
// Related Topics 堆 哈希表
// 👍 519 👎 0


import java.util.HashMap;
    import javafx.scene.layout.Priority;


//leetcode submit region begin(Prohibit modification and deletion)

//时间复杂度：O(nlogk)，n 表示数组的长度。
// 首先，遍历一遍数组统计元素的频率，
// 这一系列操作的时间复杂度是 O(n)；接着，遍历用于存储元素频率的 map，如果元素的频率大于最小堆中顶部的元素，则将顶部的元素删除并将该元素加入堆中，这里维护堆的数目是 k，
// 所以这一系列操作的时间复杂度是 O(nlogk) 的；因此，总的时间复杂度是 O(nlog⁡k)。
//空间复杂度：O(n)O(n)O(n)，最坏情况下（每个元素都不同），map 需要存储 n 个键值对，优先队列需要存储 k 个元素，因此，空间复杂度是 O(n)。

class TopkFrequentElements {
  public int[] topKFrequent(int[] nums, int k) {
    HashMap<Integer, Integer> map = new HashMap();
    for (int num : nums) {
      map.put(num, map.getOrDefault(num, 0) + 1);
    }

    PriorityQueue<Integer> que = new PriorityQueue(new Comparator <Integer>() {
      @Override
      public int compare(Integer n1, Integer n2) {
        return map.get(n1) - map.get(n2);
      }
    });

    for (int key : map.keySet()) {
      if (que.size() < k) {
        que.offer(key);
      }else if (map.get(key) > map.get(que.peek())) {
        que.poll();
        que.offer(key);
      }

    }
    int[] res = new int[k];
    for (int i = k - 1; i >= 0; i--) {
      res[i] = que.poll();
    }
    return res;


  }
}
//leetcode submit region end(Prohibit modification and deletion)
