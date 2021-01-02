//给定一个字符串，你需要反转字符串中每个单词的字符顺序，同时仍保留空格和单词的初始顺序。
//
//
//
// 示例：
//
// 输入："Let's take LeetCode contest"
//输出："s'teL ekat edoCteeL tsetnoc"
//
//
//
//
// 提示：
//
//
// 在字符串中，每个单词由单个空格分隔，并且字符串中不会有任何额外的空格。
//
// Related Topics 字符串
// 👍 262 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class 反转字符串中的单词3 {
  public String reverseWords(String s) {
    char[] arr = s.toCharArray();
    for (int i = 0; i < s.length(); i++) {
      int j = i;
      while (j + 1 < s.length() && s.charAt(j + 1) != ' ') j++;
      reverse(arr, i, j);
      i = j + 1;
    }
    return new String(arr);
  }
  void reverse(char[] arr, int i , int j) {
    for (; j > i; i++, j--) {
      char temp = arr[i]; arr[i] = arr[j]; arr[j] = temp;
    }
  }
}
//leetcode submit region end(Prohibit modification and deletion)

