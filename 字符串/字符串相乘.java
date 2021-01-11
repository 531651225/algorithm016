//给定两个以字符串形式表示的非负整数 num1 和 num2，返回 num1 和 num2 的乘积，它们的乘积也表示为字符串形式。
//
// 示例 1:
//
// 输入: num1 = "2", num2 = "3"
//输出: "6"
//
// 示例 2:
//
// 输入: num1 = "123", num2 = "456"
//输出: "56088"
//
// 说明：
//
//
// num1 和 num2 的长度小于110。
// num1 和 num2 只包含数字 0-9。
// num1 和 num2 均不以零开头，除非是数字 0 本身。
// 不能使用任何标准库的大数类型（比如 BigInteger）或直接将输入转换为整数来处理。
//
// Related Topics 数学 字符串
// 👍 544 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class 字符串相乘 {
  public String multiply(String num1, String num2) {
    int m = num1.length(), n = num2.length();
    if (num1.equals("0") || num2.equals("0")) {
      return "0";
    }
    int[] res = new int[m + n];
    for (int i = m - 1; i >= 0; i--) {
      for (int j = n - 1; j >= 0; j--) {
        int num = (num1.charAt(i)-'0')*(num2.charAt(j)-'0');
        int sum = num + res[i + j + 1];
        res[i + j + 1] = sum % 10;
        res[j + i] += sum / 10;
      }
    }

    StringBuilder builder = new StringBuilder();
    for (int i = 0; i < res.length; i++) {
      if(i == 0 && res[i] == 0){
        continue;
      }
      builder.append(res[i]);
    }
    return builder.toString();
  }
}
//leetcode submit region end(Prohibit modification and deletion)

