//给定一个数组 nums ，如果 i < j 且 nums[i] > 2*nums[j] 我们就将 (i, j) 称作一个重要翻转对。
//
// 你需要返回给定数组中的重要翻转对的数量。
//
// 示例 1:
//
//
//输入: [1,3,2,3,1]
//输出: 2
//
//
// 示例 2:
//
//
//输入: [2,4,3,5,1]
//输出: 3
//
//
// 注意:
//
//
// 给定数组的长度不会超过50000。
// 输入数组中的所有数字都在32位整数的表示范围内。
//
// Related Topics 排序 树状数组 线段树 二分查找 分治算法
// 👍 145 👎 0


//leetcode submit region begin(Prohibit modification and deletion)


//时间复杂度：O(Nlog⁡N)。
//空间复杂度：O(N)。
class 翻转数 {
  public int reversePairs(int[] nums) {
    if (nums == null || nums.length == 0) return 0;
    return mergeSort(nums, 0, nums.length - 1);
  }

  int mergeSort(int[] nums, int l, int r) {
    if (l >= r) return 0;
    int mid = l + (r - l) / 2;
    int count = mergeSort(nums, l, mid)
        + mergeSort(nums, mid + 1, r);

    int[] cache = new int[r - l + 1];
    int i = l, j = mid + 1, count = 0;

    while(i <= mid && j <= r) {
      cache[count++] = nums[i] > nums[j] ? nums[j] : nums[i];

    }
    while (i <= mid) {
      cache[count++] = nums[i];
    }

    while (j <= r) {
      cache[count++] = nums[j];
    }

    for (int n = 0; n < count; n++) {
      nums[l + n] = temp[n];
    }

    for (int j = mid + 1; j <= r; j++) {
      while(i <= mid && nums[i] <= 2 * (long)nums[j]) i++;
      while(t <= mid && nums[t] <= nums[j]) cache[c++] = nums[t++];
      cache[c++] = nums[j];
      count += mid - i + 1;
    }
    while (t <= mid) cache[c++] = nums[t++];

    System.arraycopy(cache, 0, nums, l, r - l + 1);
    return count;

  }



  private int mergeSort(int[] nums, int s, int e){
    if(s>=e) return 0;
    int mid = s + (e-s)/2;
    int cnt = mergeSort(nums, s, mid) + mergeSort(nums, mid+1, e);
    for(int i = s, j = mid+1; i<=mid; i++){
      while(j<=e && nums[i]/2.0 > nums[j]) j++;
      cnt += j-(mid+1);
    }
    Arrays.sort(nums, s, e+);
    return cnt;
  }
}
//leetcode submit region end(Prohibit modification and deletion)