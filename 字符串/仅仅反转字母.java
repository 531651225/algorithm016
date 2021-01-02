
//给定一个字符串 S，返回 “反转后的” 字符串，其中不是字母的字符都保留在原地，而所有字母的位置发生反转。
//
//
//
//
//
//
// 示例 1：
//
// 输入："ab-cd"
//输出："dc-ba"
//
//
// 示例 2：
//
// 输入："a-bC-dEf-ghIj"
//输出："j-Ih-gfE-dCba"
//
//
// 示例 3：
//
// 输入："Test1ng-Leet=code-Q!"
//输出："Qedo1ct-eeLg=ntse-T!"
//
//
//
//
// 提示：
//
//
// S.length <= 100
// 33 <= S[i].ASCIIcode <= 122
// S 中不包含 \ or "
//
// Related Topics 字符串
// 👍 70 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class 仅仅反转字母 {
  public String reverseOnlyLetters(String S) {
    char[] arr = S.toCharArray();
    for (int i = 0, j = S.length() - 1; j > i; i++, j--) {
      while(j > i && !isLetter(S.charAt(i))) i++;
      while(j > i && !isLetter(S.charAt(j))) j--;
      if (j > i) {
        char temp = arr[i];arr[i] = arr[j];arr[j] = temp;
      }
    }
    return new String(arr);
  }

  boolean isLetter(char c) {
    if((c >= 'a' && c <= 'z') || (c >= 'A' && c <= 'Z')) return true;
    return false;
  }
}
//leetcode submit region end(Prohibit modification and deletion)

