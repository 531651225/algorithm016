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
// 👍 241 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
//时间复杂度：O(Nlog N)，其中 N 为数组的长度。
//空间复杂度：O(N)，其中 N 为数组的长度。
class 翻转数 {
  public int reversePairs(int[] nums) {
    return mergeSort(nums, 0, nums.length - 1);
  }
  int mergeSort(int[] nums, int start, int end) {
    if(start >= end) return 0;
    int mid = start + (end - start) / 2;
    int count = mergeSort(nums, start, mid)
        + mergeSort(nums, mid + 1, end);
    for (int i = start, j = mid + 1; i <= mid; i++) {
      while(j <= end && nums[i] / 2.0 > nums[j]) j++;
      count += j - (mid + 1);
    }
    merge(nums, start, mid, end);
    return count;
  }


  static  void merge(int[] arr, int left, int mid, int right) {
    int[] temp = new int[right - left + 1];
    int i = left, j = mid + 1;
    int count = 0;
    while (i <= mid && j <= right)
      temp[count++] = arr[i] > arr[j] ? arr[j++] : arr[i++];

    while(i <= mid)
      temp[count++] = arr[i++];

    while(j <= right)
      temp[count++] = arr[j++];

    for (int n = 0; n < count; n++) {
      arr[left + n] = temp[n];
    }

  }
}
//leetcode submit region end(Prohibit modification and deletion)

