//给定一个字符串 s 和一个整数 k，你需要对从字符串开头算起的每隔 2k 个字符的前 k 个字符进行反转。
//
//
// 如果剩余字符少于 k 个，则将剩余字符全部反转。
// 如果剩余字符小于 2k 但大于或等于 k 个，则反转前 k 个字符，其余字符保持原样。
//
//
//
//
// 示例:
//
// 输入: s = "abcdefg", k = 2
//输出: "bacdfeg"
//
//
//
//
// 提示：
//
//
// 该字符串只包含小写英文字母。
// 给定字符串的长度和 k 在 [1, 10000] 范围内。
//
// Related Topics 字符串
// 👍 102 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
//时间复杂度：O(N)，其中 N 是 s 的大小。我们建立一个辅助数组，用来翻转 s 的一半字符。
//空间复杂度：O(N)，a 的大小。

//    方法 1：暴力
//    算法和想法
//    我们直接翻转每个 2k 字符块。
//    每个块开始于 2k 的倍数，也就是 0, 2k, 4k, 6k, ...。需要注意的一件是：如果没有足够的字符，我们并不需要翻转这个块。
//    为了翻转从 i 到 j 的字符块，我们可以交换位于 i++ 和 j-- 的字符。

class 反转字符串2 {
  public String reverseStr(String s, int k) {
    char[] arr = s.toCharArray();
    for (int n = 0; n < arr.length - 1; n += 2*k) {
      for (int i = n, j = Math.min(n + k - 1, arr.length - 1); i < j; i++, j--) {
        char temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
      }
    }
    return new String(arr);

  }








}
//leetcode submit region end(Prohibit modification and deletion)

