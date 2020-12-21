//给定一个包含 n 个整数的数组 nums 和一个目标值 target，判断 nums 中是否存在四个元素 a，b，c 和 d ，使得 a + b + c +
// d 的值与 target 相等？找出所有满足条件且不重复的四元组。
//
// 注意：
//
// 答案中不可以包含重复的四元组。
//
// 示例：
//
// 给定数组 nums = [1, 0, -1, 0, -2, 2]，和 target = 0。
//
//满足要求的四元组集合为：
//[
//  [-1,  0, 0, 1],
//  [-2, -1, 1, 2],
//  [-2,  0, 0, 2]
//]
//
// Related Topics 数组 哈希表 双指针
// 👍 698 👎 0

//leetcode submit region begin(Prohibit modification and deletion)
class 四数之和 {
  public List<List<Integer>> fourSum(int[] nums, int target) {
    List<List<Integer>> res = new ArrayList();
    if (nums.length < 4) {
      return res;
    }
    Arrays.sort(nums);
    for (int first = 0; first < nums.length - 3; first++) {
      // if (nums[first] > target) break; 可能都是负的 加一个负的 相当于较少了
      if(first > 0 && nums[first] == nums[first - 1]) continue;
      for (int sec = first + 1; sec < nums.length- 2; sec ++) {

        // if (nums[sec] + nums[first] > target) break;
        if(sec > first + 1 && nums[sec] == nums[sec - 1]) continue;
        int i = sec + 1, j = nums.length - 1;

        while (j > i) {
          int sum = nums[first] + nums[sec] + nums[i] + nums[j];
          if (sum > target) {
            while(j > i && nums[j] == nums[--j]);
          } else if (sum < target) {
            while(j > i && nums[i] == nums[++i]);
          } else {
            res.add(Arrays.asList(nums[first], nums[sec], nums[i], nums[j]));
            while(j > i && nums[j] == nums[--j]);
            while(j > i && nums[i] == nums[++i]);
          }

        }
      }
    }
    return res;
  }
}

//leetcode submit region end(Prohibit modification and deletion)

