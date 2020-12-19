import java.util.HashMap;
import java.util.PriorityQueue;



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
// 👍 593 👎 0


import java.util.HashMap;
    import java.util.PriorityQueue;
    import javafx.scene.layout.Priority;

//leetcode submit region begin(Prohibit modification and deletion)
class 前K个高频元素 {
  public int[] topKFrequent(int[] nums, int k) {
    int[] arr = new int[k];
    HashMap<Integer, Integer> dic = new HashMap<>();
    for (int i = 0; i < nums.length; i++) {
      dic.put(nums[i], dic.getOrDefault(nums[i], 0) + 1);
    }

    PriorityQueue<Integer> que = new PriorityQueue<>(new Comparator<Integer>(){
      public int compare(Integer a1, Integer a2) {
        return dic.get(a1).compareTo(dic.get(a2));
      }
    });
    for(Integer num : dic.keySet()) {
      if (que.size() < k) {
        que.add(num);
      } else {
        if (dic.get(num) > dic.get(que.peek())) {
          que.poll();
          que.add(num);
        }
      }
    }

    for (int i = 0; i < k; i++ ) {
      arr[i] = que.poll();
    }
    return arr;


  }
}
//leetcode submit region end(Prohibit modification and deletion)

